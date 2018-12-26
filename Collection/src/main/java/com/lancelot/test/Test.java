package com.lancelot.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ʹ��java 8 ��ȡ��list��bean��ĳһ����
 * 
 * @author viruser
 *
 */
public class Test {
	public static void main(String[] args) {
		List<Student> stuList = new ArrayList<Student>();
		Student st1 = new Student("123","aaa");
		Student st2 = new Student("234","bbb");
		Student st3 = new Student("345","ccc");
		Student st4 = new Student("345","ccc");
		stuList.add(st1);
		stuList.add(st2);
		stuList.add(st3);
		stuList.add(st4);
		//1.��ȡ��list�����е�һ������
		List<String> stIdList1 = stuList.stream()
				.map(Student::getId)
				.collect(Collectors.toList());
		stIdList1.forEach(s -> System.out.print(s+" "));
		System.out.println();
		System.out.println("----------");
		
		//2.��ȡ��list�����е�һ�����Բ�ȥ��
		List<String> stIdList2 = stuList.stream()
				.map(Student::getId).distinct()
				.collect(Collectors.toList());
		stIdList2.forEach(s -> System.out.print(s+" "));
	}
}

class Student {
	private String id;

	private String name;

	public Student(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
