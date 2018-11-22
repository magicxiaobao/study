package com.rokey.concurrency.queue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author chenyuejun
 * @date 2018-03-14 下午4:06
 **/
public class PriorityBlockingQueueTest {

	public static void main(String[] args) {

		PriorityBlockingQueue<User> users = new PriorityBlockingQueue<>();
		users.add(new User("guoguo", 6));
		users.add(new User("suisui", 10));
		users.add(new User("xiaobao", 8));
		for (User user : users) {

			try {
				System.out.println(users.take().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}


class User implements Comparable<User>{

	private String name;

	private Integer age;

	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}


	@Override
	public int compareTo(User o) {
		return this.getAge() - o.getAge() > 0 ? -1 : 1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}