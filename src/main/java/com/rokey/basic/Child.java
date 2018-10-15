package com.rokey.basic;

/**
 * @author chenyuejun
 * @create 2017-11-15 下午4:17.
 */
public class Child extends Father {

	private String name;

	private String hobby;

	private static CalendarTest calendarTest = new CalendarTest();

	private ArrayTest arrayTest = new ArrayTest();

	public Child(String name) {

		super(1);
		System.out.println("Child Constructor with param name");
		this.name = name;
	}

	public Child() {

		System.out.println("Child Constructor withOut param");
	}

	public static void main(String[] args) {

		Child child1 = new Child("小宝");
	}


	/*@Override
	protected void sayHello(String str) {

		System.out.println("child say hello");
	}*/

	private void sayPrivate(String str) {

		System.out.println("say private");
	}

	public void sayPublic(String str) {

		System.out.println("say Public");
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
}
