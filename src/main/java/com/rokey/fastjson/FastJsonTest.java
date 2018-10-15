package com.rokey.fastjson;

import java.io.IOException;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author chenyuejun
 * @date 2018-01-17 下午3:52
 **/
public class FastJsonTest {


	@Test
	public void testJsonEmptyString() {

		JSONObject jsonObject = new JSONObject();
		System.out.println(jsonObject.toString());
	}

	@Test
	public void testJsonArrayEmptyString() {

		JSONArray jsonArray = new JSONArray();
		System.out.println(jsonArray.toString());
		ObjectMapper objectMapper = new ObjectMapper();
		try {

			JsonNode value = objectMapper.readValue(jsonArray.toJSONString(), JsonNode.class);
			System.out.println(value.size());
			for(JsonNode jsonNode: value) {

				System.out.println(jsonNode.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}