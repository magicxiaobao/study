package com.rokey.commonLang; /**
 * Copyright (c) 2005-2011 springside.org.cn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * $Id: PropertyFilter.java 1627 2011-05-23 16:23:18Z calvinxiu $
 */

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 与具体ORM实现无关的属性过滤条件封装类, 主要记录页面中简单的搜索过滤条件.
 * 
 * @author calvin
 */
public class PropertyFilter {

	/** 多个属性间OR关系的分隔符. */
	public static final String OR_SEPARATOR = "_OR_";

	/** 属性比较类型. */
	public enum MatchType {
		EQ, NE, LIKE, LT, GT, LE, GE, IN, EMPTY, NOTEMPTY;
	}

	/** 属性数据类型. */
	public static enum PropertyType {
		S(String.class), I(Integer.class), L(Long.class), N(Double.class), D(
				Date.class), B(Boolean.class), E(Enum.class), C(Collection.class);

		private Class<?> clazz;

		private PropertyType(Class<?> clazz) {
			this.clazz = clazz;
		}

		public Class<?> getValue() {
			return clazz;
		}
	}

	private MatchType matchType = null;
	private Object[] matchValues = null;

	private Class<?> propertyClass = null;
	private String[] propertyNames = null;

	private Class<?> enumClass = null;

	public PropertyFilter() {
	}

	/**
	 * @param filterName 比较属性字符串,含待比较的比较类型、属性值类型及属性列表. eg. LIKES_NAME_OR_LOGIN_NAME
	 * @param value 待比较的值.
	 */
	public PropertyFilter(final String filterName, final Object value) {

		String firstPart = StringUtils.substringBefore(filterName, "_");
		String matchTypeCode = StringUtils.substring(firstPart, 0, firstPart.length() - 1);
		String propertyTypeCode = StringUtils.substring(firstPart, firstPart.length() - 1, firstPart.length());

		try {
			matchType = Enum.valueOf(MatchType.class, matchTypeCode);
		} catch (RuntimeException e) {
			throw new IllegalArgumentException("filter名称" + filterName
					+ "没有按规则编写,无法得到属性比较类型.", e);
		}

		try {

			propertyClass = Enum.valueOf(PropertyType.class, propertyTypeCode)
					.getValue();
		} catch (RuntimeException e) {
			throw new IllegalArgumentException("filter名称" + filterName
					+ "没有按规则编写,无法得到属性值类型.", e);
		}

		String propertyNameStr = StringUtils.substringAfter(filterName, "_");
		// AssertUtils.isTrue(StringUtils.isNotBlank(propertyNameStr),
		// "filter名称" + filterName + "没有按规则编写,无法得到属性名称.");
		propertyNames = StringUtils.splitByWholeSeparator(propertyNameStr,
				PropertyFilter.OR_SEPARATOR);

		// 这里只过滤由string类型而来的日期,否则有些参数本来就是以Date类型传递进来的就会出错了
		// string之外的类型如果要转换成date类型的话,直接返回对象本身
		boolean isString = value instanceof String;
		
		Object[] values = null;
		if (isString) {
			// 如果value是string,则拆开其OR操作符获取几个待选值
			values = StringUtils.splitByWholeSeparator(value.toString(), PropertyFilter.OR_SEPARATOR);
		} else {
			
			values = new Object[] { value };
		}
		
		matchValues = new Object[values.length];
		int i = 0;
		for (Object inValue : values) {
			try {

				if (propertyClass == Date.class && isString) {
					// 只支持三种时间格式,这样做可能不是很合理
					this.matchValues[i] = DateUtils.parseDate(inValue.toString(),
							new String[] { "yyyy-MM-dd", "yyyy-MM-dd HH:mm", "yyyy-MM-dd HH:mm:ss" });
				} else {

					this.matchValues[i] = ConvertUtils.convert(inValue, propertyClass);
				}
				++i;
			} catch (Exception e) {

				throw new RuntimeException(e);
			}
		}
	}
	
	public PropertyFilter(final String filterName) {

		this(filterName, "");
		matchValues = new Object[] {""};
	}

	/**
	 * 从HttpRequest中创建PropertyFilter列表, 默认Filter属性名前缀为filter.
	 * 
	 * @see #buildFromHttpRequest(HttpServletRequest, String)
	 */
	public static List<PropertyFilter> buildFromHttpRequest(
			final HttpServletRequest request) {
		return buildFromHttpRequest(request, "filter", null);
	}

	/**
	 * 从HttpRequest中创建PropertyFilter列表, 默认Filter属性名前缀为filter.
	 * 
	 * @see #buildFromHttpRequest(HttpServletRequest, String)
	 */
	public static List<PropertyFilter> buildFromHttpRequest(
			final HttpServletRequest request, Class<?> enumClass) {
		return buildFromHttpRequest(request, "filter", enumClass);
	}
	

	/**
	 * 从HttpRequest中创建PropertyFilter列表
	 * PropertyFilter命名规则为Filter属性前缀_比较类型属性类型_属性名.
	 * 
	 * eg. filter_EQS_name filter_LIKES_name_OR_email
	 */
	public static List<PropertyFilter> buildFromHttpRequest(
			final HttpServletRequest request, final String filterPrefix) {
		List<PropertyFilter> filterList = new ArrayList<PropertyFilter>();

		// 从request中获取含属性前缀名的参数,构造去除前缀名后的参数Map.
		Map<String, Object> filterParamMap = WebUtils
				.getParametersStartingWith(request, filterPrefix + "_");

		// 分析参数Map,构造PropertyFilter列表
		for (Map.Entry<String, Object> entry : filterParamMap.entrySet()) {
			String filterName = entry.getKey();
			String value = (String) entry.getValue();
			// 如果value值为空,则忽略此filter.
			if (StringUtils.isNotBlank(value)) {
				PropertyFilter filter = new PropertyFilter(filterName, value);
				filterList.add(filter);
			}
		}

		return filterList;
	}

	/**
	 * 从HttpRequest中创建PropertyFilter列表
	 * PropertyFilter命名规则为Filter属性前缀_比较类型属性类型_属性名.
	 * 
	 * eg. filter_EQS_name filter_LIKES_name_OR_email
	 */
	public static List<PropertyFilter> buildFromHttpRequest(
			final HttpServletRequest request, final String filterPrefix,
			Class<?> enumClass) {
		List<PropertyFilter> filterList = new ArrayList<PropertyFilter>();

		// 从request中获取含属性前缀名的参数,构造去除前缀名后的参数Map.
		Map<String, Object> filterParamMap = WebUtils
				.getParametersStartingWith(request, filterPrefix + "_");

		// 分析参数Map,构造PropertyFilter列表
		for (Map.Entry<String, Object> entry : filterParamMap.entrySet()) {
			String filterName = entry.getKey();
			String value = (String) entry.getValue();
			// 如果value值为空,则忽略此filter.
			if (StringUtils.isNotBlank(value)) {
				PropertyFilter filter = new PropertyFilter(filterName, value);
				if (filter.isEnumValue()) {
					filter.setEnumClass(enumClass);
				}
				filterList.add(filter);
			}
		}

		return filterList;
	}

	/**
	 * 获取比较值的类型.
	 */
	public Class<?> getPropertyClass() {
		return propertyClass;
	}

	/**
	 * 获取比较方式.
	 */
	public MatchType getMatchType() {
		return matchType;
	}

	/**
	 * 获取比较值.
	 */
	public Object[] getMatchValues() {
		return matchValues;
	}

	/**
	 * 获取比较属性名称列表.
	 */
	public String[] getPropertyNames() {
		return propertyNames;
	}

	/**
	 * 获取唯一的比较属性名称.
	 */
	public String getPropertyName() {
		// AssertUtils.isTrue(propertyNames.length == 1,
		// "There are not only one property in this filter.");
		return propertyNames[0];
	}

	/**
	 * 是否比较多个属性.
	 */
	public boolean hasMultiProperties() {
		return (propertyNames.length > 1);
	}

	/**
	 * 获取比较属性名称列表.
	 */
	public boolean isEnumValue() {
		return Enum.class.isAssignableFrom(propertyClass);
	}

	public void setEnumClass(Class<?> enumClass) {
		this.enumClass = enumClass;
	}

	public Class<?> getEnumClass() {
		return enumClass;
	}
}