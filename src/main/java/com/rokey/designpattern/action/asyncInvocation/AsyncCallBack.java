package com.rokey.designpattern.action.asyncInvocation;

import java.util.Optional;

/**
 * @author chenyuejun
 * @date 2018-11-13 8:22 PM
 **/
public interface AsyncCallBack<T> {


	void onComplete(T t, Optional<Exception> ex);

}