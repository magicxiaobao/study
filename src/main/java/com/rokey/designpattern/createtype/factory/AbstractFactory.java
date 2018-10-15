package com.rokey.designpattern.createtype.factory;

/**
 * @author chenyuejun
 * @date 2018-03-15 上午10:30
 **/
public class AbstractFactory {

	public static void main(String[] args) {

		Sender sender = new MailProvider().provide();
		sender.send();
	}

}


interface Sender {

	void send();
}

interface Provider {

	Sender provide();
}

class MailProvider implements Provider {

	@Override
	public Sender provide() {
		return new MailSender();
	}
}

class MailSender implements Sender {

	@Override
	public void send() {

		System.out.println("is sending mail");
	}
}

class SmsSender implements Sender {

	@Override
	public void send() {

		System.out.println("is send SMS");
	}
}