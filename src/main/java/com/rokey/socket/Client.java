package com.rokey.socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author chenyuejun
 * @date 2018-03-22 下午4:40
 **/
public class Client {



	public static void main(String[] args) throws IOException {

		String clientMsg;
		String serverMsg;
		Socket clientSocket = new Socket("127.0.0.0", 5557);
		BufferedReader fromUser = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader fromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		DataOutputStream toServer = new DataOutputStream(clientSocket.getOutputStream());
		clientMsg = fromUser.readLine();
		toServer.writeBytes(clientMsg);
		serverMsg = fromServer.readLine();
		System.out.println(serverMsg);
		clientSocket.close();


	}

}