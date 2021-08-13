package com.example.demo.common.utils;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Supplier;

import com.example.demo.common.exception.AssertException;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AssertUtil {

	// public static void isTrue(boolean expression, String message) {
	// 	if (!expression) {
	// 		throw new AssertException(IS_TRUE, message);
	// 	}
	// }
	//
	// public static void isTrue(boolean expression, Supplier<String> message) {
	// 	if (!expression) {
	// 		throw new AssertException(IS_TRUE, message.get());
	// 	}
	// }
	//
	// public static void isFalse(boolean expression, String message) {
	// 	if (expression) {
	// 		throw new AssertException(IS_FALSE, message);
	// 	}
	// }
	//
	// public static void isFalse(boolean expression, Supplier<String> message) {
	// 	if (expression) {
	// 		throw new AssertException(IS_FALSE, message.get());
	// 	}
	// }
	//
	// public static void isNull(Object object, String message) {
	// 	if (Objects.nonNull(object)) {
	// 		throw new AssertException(IS_NULL, message);
	// 	}
	// }
	//
	// public static void isNull(Object object, Supplier<String> message) {
	// 	if (Objects.nonNull(object)) {
	// 		throw new AssertException(IS_NULL, message.get());
	// 	}
	// }
	//
	// public static void notNull(Object object, String message) {
	// 	if (Objects.isNull(object)) {
	// 		throw new AssertException(NOT_NULL, message);
	// 	}
	// }
	//
	// public static void notNull(Object object, Supplier<String> message) {
	// 	if (Objects.isNull(object)) {
	// 		throw new AssertException(NOT_NULL, message.get());
	// 	}
	// }
	//
	// public static void notEmpty(Collection collection, String message) {
	// 	if (Objects.isNull(collection) || collection.isEmpty()) {
	// 		throw new AssertException(NOT_EMPTY, message);
	// 	}
	// }
	//
	// public static void notEmpty(Collection collection, Supplier<String> message) {
	// 	if (Objects.isNull(collection) || collection.isEmpty()) {
	// 		throw new AssertException(NOT_EMPTY, message.get());
	// 	}
	// }
	//
	// public static void status(boolean expression, String message) {
	// 	if (!expression) {
	// 		throw new AssertException(STATUS, message);
	// 	}
	// }
	//
	// public static void status(boolean expression, Supplier<String> message) {
	// 	if (!expression) {
	// 		throw new AssertException(STATUS, message.get());
	// 	}
	// }
	//
	// public static void isMatch(boolean expression, String message) {
	// 	if (!expression) {
	// 		throw new AssertException(IS_MATCH, message);
	// 	}
	// }
	//
	// public static void isMatch(boolean expression, Supplier<String> message) {
	// 	if (!expression) {
	// 		throw new AssertException(IS_MATCH, message.get());
	// 	}
	// }
	//
	// public static void force(String message) {
	// 	throw new AssertException(FORCE, message);
	// }
}
