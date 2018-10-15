package com.rokey.basic;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @author chenyuejun
 * @date 2018-03-08 下午5:48
 **/
public class CustomClassLoader extends ClassLoader {

	public CustomClassLoader() {

	}

	public CustomClassLoader(ClassLoader parent) {

		super(parent);
	}

	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {

		File file = this.getClassFile(name);
		try {
			byte[] fileBytes = this.getFileBytes(file);
			Class<?> c = this.defineClass(name, fileBytes, 0, fileBytes.length);
			return c;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.loadClass(name);
	}

	private byte[] getFileBytes(File file) throws Exception {

		ByteArrayOutputStream byteArrayOutputStream;
		try (FileInputStream fileInputStream = new FileInputStream(file)) {
			FileChannel channel = fileInputStream.getChannel();
			byteArrayOutputStream = new ByteArrayOutputStream();
			try (WritableByteChannel writableByteChannel = Channels.newChannel(byteArrayOutputStream)) {
				ByteBuffer bf = ByteBuffer.allocate(1024);
				while (true) {

					int read = channel.read(bf);
					if (read == 0 || read == -1) {

						break;
					}
					bf.flip();
					writableByteChannel.write(bf);
					bf.clear();
				}
			}
			fileInputStream.close();
		}
		return byteArrayOutputStream.toByteArray();
	}

	private File getClassFile(String name) {

		return new File("/Users/chenyueshun/IdeaProjects/rokeyStudy/src/main/java/com/rokey/basic/ClassForNameTest.class");
	}

	public static void main(String[] args) throws Exception {

		CustomClassLoader customClassLoader = new CustomClassLoader();
		Class<?> aClass = Class.forName("com.rokey.basic.StringTest", true, customClassLoader);
		Object o = aClass.newInstance();
		System.out.println(o);
		System.out.println(o.getClass().getClassLoader());

		Class<?> aClass1 = Class.forName("com.rokey.basic.StringTest", true, ClassLoader.getSystemClassLoader());
		Object o1 = aClass1.newInstance();
		System.out.println(o1);
		System.out.println(o.equals(o1));

	}
}