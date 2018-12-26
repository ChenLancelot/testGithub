package com.lancelot.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalTest {
	
	public static void main(String[] args) {
		List<Long> list = new ArrayList<>();
		list.add(new Long(1));
		list.add(new Long(2));
		list.add(new Long(3));
		
		Long l = new Long(3);
		Optional<Long> findFirst = list.stream().filter(x -> x.equals(l)).findFirst();
		if (findFirst.isPresent()) {
			System.out.println(findFirst.get());
		} else {
			System.out.println("no value");
		}
	}
}
