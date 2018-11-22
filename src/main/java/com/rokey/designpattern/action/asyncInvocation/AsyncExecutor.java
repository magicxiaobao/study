package com.rokey.designpattern.action.asyncInvocation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @author chenyuejun
 * @date 2018-11-13 8:18 PM
 **/
public interface AsyncExecutor {


	<T> AsyncResult<T> startProcess(Callable<T> callable);


	<T> AsyncResult<T> startProcess(Callable<T> callable, AsyncCallBack<T> callback);


	<T> T endProcess(AsyncResult<T> result) throws InterruptedException, ExecutionException;
}