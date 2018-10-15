package com.rokey.utils;



import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author
 * @create 2017-11-20 下午10:22
 **/
public class LambdaUtils {

	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
		Map<Object, Boolean> seen = new HashMap();
		return (t) -> {
			return seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
		};
	}

	private LambdaUtils() {
	}

}
