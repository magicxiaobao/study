package com.rokey.designpattern.action.asyncInvocation;

import java.util.concurrent.ExecutionException;

/**
 * 异步任务返回结果
 *
 * @author chenyuejun
 * @date 2018-11-13 8:15 PM
 **/
public interface AsyncResult<T> {


	/**
	 * 获取结果
	 * @return
	 * @throws ExecutionException
	 */
	T getValue() throws ExecutionException;


	/**
	 * 是否完成
	 */
	boolean isComplete();

	/**
	 * 阻塞当前线程，直到被notify
	 */
	void await() throws InterruptedException;

}