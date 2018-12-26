package com.lancelot.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NullListTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		Collections.sort(list, (o1, o2) -> Integer.compare(o1, o2));
		for (Integer temp : list) {
			System.out.println("sdfasdf");
		}
		if (1 == 1) {

		} else if (1 == 1) {

		}
		// OO a = new OO();
		// a.setAge(a.getAge() + 3);
	}

}

class OO {
	private Integer age;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
