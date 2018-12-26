package com.lancelot.test;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("003");
		list.add("002");
		list.add("001");
		list.add("003002");
		list.add("003001");
		list.add("003001002");
		list.add("003002001");

		long count = list.stream().filter(x -> x.startsWith("003003")).count();
		System.out.println(count);
		if (true) {

		}
	}
}
