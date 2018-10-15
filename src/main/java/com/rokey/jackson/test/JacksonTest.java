package com.rokey.jackson.test;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.rokey.jackson.bean.Account;
import com.rokey.jackson.bean.Birthday;
import com.rokey.jackson.bean.User;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

/**
 * 参考 http://blog.csdn.net/java_huashan/article/details/46375857
 * @author chenyuejun
 * @create 2017-09-21 下午2:46.
 */
public class JacksonTest {

    private JsonFactory jsonFactory = null;
    private JsonGenerator jsonGenerator = null;
    private ObjectMapper objectMapper = null;
    private Account account = null;
    String url = "http://freemusicarchive.org/api/get/albums.json?api_key=60BLHNQCAOUFPIBZ&limit=5";
    JsonParser parser = null;
    String jsonStr = null;
    String jsonStr2 = null;
    String jsonStr3 = null;

    @Before
    public void init() throws IOException {

        account = new Account();
        account.setName("guoguo");
        account.setSex("女");

        jsonFactory = new JsonFactory();
        jsonGenerator = jsonFactory.createGenerator(System.out, JsonEncoding.UTF8);
        objectMapper = new ObjectMapper();
        jsonStr = "{\"title\":\"标题\",\"dataset\":[{\"album1\":\"A.B.C.D\"},{\"album2\":\"E.F.G.H\"}]}";
        jsonStr2 = "{\"xiaobao\":{\"name\":\"xiaobao\",\"sex\":\"男\",\"birthday\":null},\"guoguo\":{\"name\":\"guoguo\",\"sex\":\"女\",\"birthday\":null}}";
        jsonStr3 = "{\"name\":\"suisui\",\"sex\":\"女\",\"birthday\":{\"birthday\":\"1984.06.17\"}}";
    }

    @Test
    public void testTreeModelParser() throws IOException {

        JsonNode node = objectMapper.readTree(jsonStr);
        System.out.println(node.getNodeType());
        System.out.println(node.isContainerNode());
        Iterator<String> stringIterator = node.fieldNames();
        while (stringIterator.hasNext()) {

            String fieldName = stringIterator.next();
            System.out.println(fieldName);
        }
        System.out.println(node.get("title").asText());
        JsonNode dataset = node.get("dataset");
        System.out.println(dataset.getNodeType());
        JsonNode nodeNull = node.get("haha");
        System.out.println(nodeNull);
        JsonNode missingNode = node.path("haha");
        System.out.println(missingNode);
    }

    @Test
    public void testObjectNodeReplce() throws IOException {

	    ObjectNode objectNode = objectMapper.createObjectNode();
	    JsonNode node1 = objectMapper.readTree(jsonStr);
	    objectNode.put("properties", node1);
	    System.out.println(objectNode.toString());
	    JsonNode node2 = objectMapper.readTree(jsonStr2);
	    objectNode.replace("properties", node2);
	    System.out.println(objectNode.toString());
    }

    @Test
    public void testNull() {

	    ObjectNode objectNode = objectMapper.createObjectNode();
	    String aa = objectNode.path("aa").asText();
	    assertThat(true, is(StringUtils.isBlank(aa)));
    }

    @Test
    public void testObjectMapper() throws IOException {

        Map<String, Account> map = new HashMap<String, Account>();
        map.put("guoguo", account);
        Account xiaobao = new Account();
        xiaobao.setName("xiaobao");
        xiaobao.setSex("男");
        map.put("xiaobao", xiaobao);
        objectMapper.writeValue(System.out, map);
        JsonNode jsonNode = objectMapper.readTree(jsonStr2);
        System.out.println(jsonNode.toString());
    }

    @Test
    public void testMap() throws JsonProcessingException {

    	Map<Account, User> map = new HashMap<>();
    	Birthday birthday = new Birthday();
    	birthday.setBirthday(DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
    	Account account = new Account();
    	account.setName("guoguo");
    	account.setSex("girl");
    	account.setBirthday(birthday);
    	User user = new User();
    	user.setName("xiaobao");
    	user.setAge(30L);
    	map.put(account, user);
	    String s = objectMapper.writeValueAsString(map);
	    System.out.println(s);
    }

    @Test
    public void testObjectMapperStrToBean() throws IOException {

        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Account suisui = objectMapper.readValue(jsonStr3,Account.class);
        System.out.println(suisui);
    }

    @Test
    public void testPathLong() {

	    ObjectNode objectNode = objectMapper.createObjectNode();
	    long sss = objectNode.path("sss").asLong();
	    System.out.println(sss);
    }

    @Test
    public void testBoolean() {

    	try {

		    ObjectNode objectNode = objectMapper.createObjectNode();
		    objectNode.put("bb", "true");
		    objectNode.put("cc", "");
		    Boolean aa1 = this.getProductConfigFromTaskJson(objectNode, "aa");
		    Boolean aa = this.getProductConfigFromTaskJsonOrDefault(objectNode, "aa", null);
		    Boolean bb = this.getProductConfigFromTaskJsonOrDefault(objectNode, "bb", false);
		    Boolean cc = this.getProductConfigFromTaskJsonOrDefault(objectNode, "cc", true);
		    System.out.println(aa);
		    System.out.println(bb);
		    System.out.println(cc);
	    } catch (Exception e) {

    		e.printStackTrace();
	    }
    }

	public Boolean getProductConfigFromTaskJsonOrDefault(JsonNode taskJson, String configParam, Boolean defaultBoolean) {

		Boolean temp = taskJson.has(configParam) ? taskJson.path(configParam).asBoolean() : null;
		return temp == null ? defaultBoolean : temp;
	}

	public Boolean getProductConfigFromTaskJson(JsonNode taskJson, String configParam) {

		return taskJson.has(configParam) ? taskJson.path(configParam).asBoolean() : null;
	}

    @Test
    public void testEmptyStrParse() {

    	String empty = "";
	    ObjectNode emptyObjectNode = objectMapper.createObjectNode();
	    JsonNode jsonNode = null;
	    try {
		    jsonNode = objectMapper.readValue(emptyObjectNode.toString(), JsonNode.class);
		    System.out.println(jsonNode.toString());
	    } catch (IOException e) {

		    e.printStackTrace();
	    }
	    System.out.println("size: " + jsonNode.size());
	    assertThat(jsonNode, is(nullValue()));
    }

    @Test
    public void testStreamGenerator() throws IOException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("title");
        jsonGenerator.writeString("标题");
        jsonGenerator.writeFieldName("dataset");
        jsonGenerator.writeStartArray();
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("album1", "A.B.C.D");
        jsonGenerator.writeEndObject();
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("album2", "E.F.G.H");
        jsonGenerator.writeEndObject();
        jsonGenerator.writeEndArray();
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("album3", null);
        jsonGenerator.writeEndObject();
        jsonGenerator.writeEndObject();
        jsonGenerator.close();

    }

    @Test
    public void testJsonSize() {

	    ObjectNode jsonNodes = JsonNodeFactory.instance.objectNode();
	    jsonNodes.put("a", "a");
	    System.out.println(jsonNodes.size());
    }

    @Test
    public void testJsonChild() {

	    ObjectNode jsonNodes = JsonNodeFactory.instance.objectNode();
	    ObjectNode childNode1 = JsonNodeFactory.instance.objectNode();
	    jsonNodes.put("child1", childNode1);
	    ObjectNode childNode2 = JsonNodeFactory.instance.objectNode();
	    jsonNodes.set("child2", childNode2);
	    System.out.println(jsonNodes.toString());
    }

    @Test
    public void writeStringTest() throws JsonProcessingException {

	    String aaaa = objectMapper.writeValueAsString("aaaabbbbbb");
	    System.out.println(aaaa);
    }

    @Test
    public void testNullLong() {

	    ObjectNode objectNode = objectMapper.createObjectNode();
//	    objectNode.put("tradeId", "");
	    System.out.println(objectNode.path("tradeId").asLong());
    }

    @Test
    public void testTypeReference() throws IOException {

	    Birthday birthday = new Birthday();
		birthday.setBirthday(DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
	    Account account = new Account();
	    account.setBirthday(birthday);
	    account.setName("xiaobao");
	    account.setSex("女");
	    Map<Account, Birthday> map = new HashMap<>();
	    map.put(account, birthday);
	    String s = objectMapper.writeValueAsString(map);
	    System.out.println(s);
	    System.out.println("parsing......");
	    objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
//	    Map<Account, Birthday> mapAfterParsed = (Map<Account, Birthday>)objectMapper.readValue(s, new TypeReference<Map<Account, Birthday>>() {});
	    /*JsonNode jsonNode = objectMapper.readTree(s);
	    System.out.println(jsonNode.toString());*/
	    /*mapAfterParsed.entrySet().stream()
		    .forEach(entry -> System.out.println(entry.getKey() + "---" + entry.getValue()));*/
    }


    @After
    public void destory() {

        try {
            if (jsonGenerator != null) {

                jsonGenerator.flush();
            }
            if (jsonGenerator != null) {

                jsonGenerator.close();
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}