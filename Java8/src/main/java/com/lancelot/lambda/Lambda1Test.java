package com.lancelot.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

public class Lambda1Test {

	//�����ڲ�����ʽ
	@Test
	public void test1(){
		//������lambda���ʽ
		Comparator<String> com= new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		};
		TreeSet<String> ts = new TreeSet<>(com);
		
		TreeSet<String> ts2 = new TreeSet<>(new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
			
		});
	}
	
	//lambda��ʽ
	@Test
	public void test2(){
		TreeSet<String> ts2 = new TreeSet<>((s1, s2) -> Integer.compare(s1.length(), s2.length()));
	}
	
	List<Employee> emps = Arrays.asList(
			new Employee(101, "����", 18, 9999.99),
			new Employee(102, "����", 59, 6666.66),
			new Employee(103, "����", 28, 3333.33),
			new Employee(104, "����", 8, 7777.77),
			new Employee(105, "����", 38, 5555.55)
	);

	//���󣺻�ȡ��˾������С�� 35 ��Ա����Ϣ
	public List<Employee> filterEmployeeAge(List<Employee> emps){
		List<Employee> list = new ArrayList<>();
		
		for (Employee emp : emps) {
			if(emp.getAge() <= 35){
				list.add(emp);
			}
		}
		return list;
	}
	
	//����С�� 35 ��Ա����Ϣ
	@Test
	public void test3(){
		List<Employee> list = filterEmployeeAge(emps);
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
	
	//���󣺻�ȡ��˾�й��ʴ��� 5000 ��Ա����Ϣ
	public List<Employee> filterEmployeeSalary(List<Employee> emps){
		List<Employee> list = new ArrayList<>();
		
		for (Employee emp : emps) {
			if(emp.getSalary() >= 5000){
				list.add(emp);
			}
		}
		
		return list;
	}
	
	//�Ż���ʽһ���������ģʽ
	public List<Employee> filterEmployee(List<Employee> emps, MyPredicate<Employee> mp){
		List<Employee> list = new ArrayList<>();
		
		for (Employee employee : emps) {
			if(mp.test(employee)){
				list.add(employee);
			}
		}
		
		return list;
	}
	
	@Test
	public void test4(){
		List<Employee> list = filterEmployee(emps, new FilterEmployeeForAge());
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
		System.out.println("------------------------------------------");
		
		List<Employee> list2 = filterEmployee(emps, new FilterEmployeeForSalary());
		for (Employee employee : list2) {
			System.out.println(employee);
		}
	}
	
	//�Ż���ʽ���������ڲ���
	@Test
	public void test5(){
		List<Employee> list = filterEmployee(emps, new MyPredicate<Employee>() {
			@Override
			public boolean test(Employee t) {
				return t.getId() <= 103;
			}
		});
		
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
	
	//�Ż���ʽ����Lambda ���ʽ
	@Test
	public void test6(){
		List<Employee> list = filterEmployee(emps, e -> e.getAge() <= 35);
		list.forEach(System.out::println);

	}
	
	//�Ż���ʽ�ģ�Stream API
	@Test
	public void test7(){
		emps.stream().filter(e -> e.getAge() <= 35).forEach(System.out::println);
		System.out.println("----------------------------------------------");
		emps.stream()
		    .map(Employee::getName)
			.limit(3)
			.sorted()
			.forEach(System.out::println);
	}
	
}
