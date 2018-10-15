package com.rokey.guawa.retry;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import org.junit.Before;
import org.junit.Test;

import com.github.rholder.retry.RetryException;
import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.google.common.base.Predicates;

/**
 * @author chenyuejun
 * @create 2018-01-09 上午9:40
 **/
public class GuawaRetryTest {

	private Callable<Void> checkedExceptionCallable;

	private Callable<Void> runtimeExceptionCallable;

	private Callable<Void> errorCallable;

	private Callable<Boolean> booleanCallable;

	private Callable<CharSequence> charSequenceCallable;

	@Before
	public void setUp() {

		checkedExceptionCallable = () -> {

			System.out.println("throw checked Exception");
			throw new IOException("IOException");
		};

		runtimeExceptionCallable = new Callable<Void>() {

			@Override
			public Void call() throws Exception {

				System.out.println("throw runtime Exception");
				throw new NullPointerException("NullPointException");
			}
		};

		errorCallable = new Callable<Void>() {

			@Override
			public Void call() throws Exception {

				System.out.println("error");
				throw new ThreadDeath();
			}
		};

		booleanCallable = new Callable<Boolean>() {

			private int count = 0;
			@Override
			public Boolean call() throws Exception {

				System.out.println("Boolean task was Called");
				if (count ==0) {

					count++;
					return false;
				} else {

					return true;
				}
			}
		};

		charSequenceCallable = new Callable<CharSequence>() {

			private int count = 0;
			@Override
			public CharSequence call() throws Exception {

				System.out.println("charSequence task was Called");
				if (count == 0) {

					count++;
					return UUID.randomUUID() + "_false";
				} else {

					return UUID.randomUUID() + "_success";
				}
			}
		};
	}

	@Test
	public void retryTestWhenExceptionOccur() {

		Retryer<Void> retryer = RetryerBuilder.<Void>newBuilder()
			.retryIfException()
			.withStopStrategy(StopStrategies.stopAfterAttempt(3))
			.build();
		try {

			retryer.call(checkedExceptionCallable);
		} catch (ExecutionException e) {

			e.printStackTrace();
		} catch (RetryException e) {

			e.printStackTrace();
		}

		try {

			retryer.call(runtimeExceptionCallable);
		} catch (ExecutionException e) {

			e.printStackTrace();
		} catch (RetryException e) {

			e.printStackTrace();
		}

		try {

			retryer.call(errorCallable);
		} catch (ExecutionException e) {

			e.printStackTrace();
		} catch (RetryException e) {

			e.printStackTrace();
		}
	}

	@Test
	public void retryTestWhenRunntimeExceptionOccur() {

		Retryer<Void> retryer = RetryerBuilder.<Void>newBuilder()
			.retryIfRuntimeException()
			.withStopStrategy(StopStrategies.stopAfterAttempt(3))
			.build();
		try {

			retryer.call(checkedExceptionCallable);
		} catch (ExecutionException e) {

			e.printStackTrace();
		} catch (RetryException e) {

			e.printStackTrace();
		}

		try {

			retryer.call(runtimeExceptionCallable);
		} catch (ExecutionException e) {

			e.printStackTrace();
		} catch (RetryException e) {

			e.printStackTrace();
		}

		try {

			retryer.call(errorCallable);
		} catch (ExecutionException e) {

			e.printStackTrace();
		} catch (RetryException e) {

			e.printStackTrace();
		}
	}

	@Test
	public void retryTestWhenReturnBoolean() {

		Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()
			.retryIfResult(Predicates.equalTo(false))
			.withStopStrategy(StopStrategies.stopAfterAttempt(3))
			.build();
		try {

			retryer.call(booleanCallable);
		} catch (ExecutionException e) {

			e.printStackTrace();
		} catch (RetryException e) {

			e.printStackTrace();
		}
	}

	@Test
	public void retryTestWhenReturnString() {

		Retryer<CharSequence> retryer = RetryerBuilder.<CharSequence>newBuilder()
			.retryIfResult(Predicates.containsPattern("_false$"))
			.withStopStrategy(StopStrategies.stopAfterAttempt(3))
			.build();
		try {

			retryer.call(charSequenceCallable);
		} catch (ExecutionException e) {

			e.printStackTrace();
		} catch (RetryException e) {

			e.printStackTrace();
		}
	}
}