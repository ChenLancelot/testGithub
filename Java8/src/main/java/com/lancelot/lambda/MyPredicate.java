package com.lancelot.lambda;

@FunctionalInterface
public interface MyPredicate<T> {

	public boolean test(T t);
	
}
