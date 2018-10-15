package com.rokey.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chenyuejun
 * @date 2018-03-22 下午4:49
 **/
public class Server {

	public static void main(String[] args) throws IOException {

		String clientMsg;
		String serverMsg;
		ServerSocket serverSocket = new ServerSocket(5557);
		while(true) {

			Socket collect = serverSocket.accept();
			DataInputStream fromClient = new DataInputStream(collect.getInputStream());
			DataOutputStream toClient = new DataOutputStream(collect.getOutputStream());
			clientMsg = fromClient.readUTF();
			System.out.println("read From Client, Msg = " + clientMsg);
			serverMsg = "msg from server";
			toClient.writeBytes(serverMsg);
			System.out.println("collect succeed");
		}

	}

}