package com.rokey.basic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author chenyuejun
 * @date 2018-01-24 下午7:31
 **/
public class ClassWithNullBooleanParam {

	private Boolean active;

	public ClassWithNullBooleanParam() { }

	public ClassWithNullBooleanParam(boolean active) {

		this.active = active;
	}

	public Boolean getActive() {

		return active;
	}

	public void setActive(Boolean active) {

		this.active = active;
	}

	public Boolean getProductConfigFromTaskJson(JsonNode taskJson, String configParam) {

		return !taskJson.has(configParam) ? null : (taskJson.path(configParam).asLong() == 1L ? true : false);
	}

	public static void main(String[] args) {

		ClassWithNullBooleanParam classWithNullBooleanParam = new ClassWithNullBooleanParam();
		classWithNullBooleanParam.setActive(true);
		System.out.println(classWithNullBooleanParam.getActive());

		ObjectNode taskJson = JsonNodeFactory.instance.objectNode();
		Boolean aaa = classWithNullBooleanParam.getProductConfigFromTaskJson(taskJson, "aaa");
		System.out.println(aaa);
	}
}