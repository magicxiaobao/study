package com.rokey.designpattern.action.asyncInvocation;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenyuejun
 * @date 2018-11-13 8:28 PM
 **/
public class ThreadAsyncExecutor implements AsyncExecutor {


	private AtomicInteger index = new AtomicInteger();

	@Override
	public <T> AsyncResult<T> startProcess(Callable<T> callable) {
		return startProcess(callable, null);
	}

	@Override
	public <T> AsyncResult<T> startProcess(Callable<T> callable, AsyncCallBack<T> callback) {
		CompletableResult<T> result = new CompletableResult<>(callback);
		new Thread(() -> {
			try {
				T t = callable.call();
				result.setValue(t);
			} catch (Exception e) {
				result.setException(e);
			}
		}, "executor-" + index.incrementAndGet()).start();
		return result;
	}

	@Override
	public <T> T endProcess(AsyncResult<T> result) throws InterruptedException, ExecutionException {
		if (!result.isComplete()) {
			result.await();
		}
		return result.getValue();
	}

	private static class CompletableResult<T> implements AsyncResult<T>{

		static final int RUNNING = 1;
		static final int FAILED = 2;
		static final int COMPLETED = 3;

		Object lock;
		Optional<AsyncCallBack<T>> callback;

		volatile int state = RUNNING;
		T value;
		Exception exception;

		CompletableResult(AsyncCallBack<T> callBack) {
			this.lock = new Object();
			this.callback = Optional.ofNullable(callBack);
		}

		void setValue(T value) {
			this.state = COMPLETED;
			this.value = value;
			this.callback.ifPresent(cb -> cb.onComplete(this.value, Optional.empty()));
			synchronized (lock) {
				lock.notifyAll();
			}
		}

		void setException(Exception exception) {
			this.state = FAILED;
			this.callback.ifPresent(cb -> cb.onComplete(null, Optional.of(exception)));
			synchronized (lock) {
				lock.notifyAll();
			}
		}

		@Override
		public T getValue() throws ExecutionException {
			if (state == COMPLETED) {
				return value;
			} else if (state == FAILED) {
				throw new ExecutionException(exception);
			} else {
				throw new IllegalStateException("Execution not completed");
			}
		}

		@Override
		public boolean isComplete() {
			return state == COMPLETED;
		}

		@Override
		public void await() throws InterruptedException {
			synchronized (lock) {
				while (!isComplete()) {
					lock.wait();
				}
			}
		}
	}
}