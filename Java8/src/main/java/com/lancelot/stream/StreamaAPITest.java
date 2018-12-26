package com.lancelot.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.lancelot.lambda.Employee;

/**
 * 
 * @author Lancelot
 * 1.������
 * 
 * 2.�м����
 * 
 * 3.��ֹ����
 */
public class StreamaAPITest {

	@Test
	public void test1(){
		//1. ���� Stream
		List<String> list = new ArrayList<String>();
		Stream<String> stream = list.stream();	// ��ȡһ��˳����
		Stream<String> parallelStream = list.parallelStream(); // ��ȡһ��������
		
		//2. ͨ�� Arrays �е� stream() ��ȡһ��������
		Integer[] arr = new Integer[10];
		Stream<Integer> stream2 = Arrays.stream(arr);
		
		//3. ͨ�� Stream ���о�̬���� of()
		Stream<Integer> of = Stream.of(arr);
		
		//4. ����������
		//����
		Stream<Integer> stream3 = Stream.iterate(0, x -> x + 2);
		
		Stream<Double> stream4 = Stream.generate(Math::random).limit(2);
		stream4.forEach(System.out::println);
	}
	
	//2. �м����
	List<Employee> emps = Arrays.asList(
			new Employee(102, "����", 59, 6666.66),
			new Employee(101, "����", 18, 9999.99),
			new Employee(103, "����", 28, 3333.33),
			new Employee(104, "����", 8, 7777.77),
			new Employee(104, "����", 8, 7777.77),
			new Employee(104, "����", 8, 7777.77),
			new Employee(105, "����", 38, 5555.55)
	);
	
	/*
	  ɸѡ����Ƭ
		filter�������� Lambda �� �������ų�ĳЩԪ�ء�
		limit�����ض�����ʹ��Ԫ�ز���������������
		skip(n) ���� ����Ԫ�أ�����һ���ӵ���ǰ n ��Ԫ�ص�����������Ԫ�ز��� n �����򷵻�һ���������� limit(n) ����
		distinct����ɸѡ��ͨ����������Ԫ�ص� hashCode() �� equals() ȥ���ظ�Ԫ��
	 */
	
	//�ڲ��������������� Stream API �ڲ����
	@Test
	public void test2() {
		//���е��м�����������κεĴ���
		Stream<Employee> stream = emps.stream()
				.filter(x -> {
					System.out.println("�����м����");
					return x.getAge() < 35;
			});
		stream.forEach(System.out::println);
	}
	
	//�ⲿ����
	@Test
	public void test3(){
		Iterator<Employee> it = emps.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	@Test
	public void test4() {
		emps.stream()
			.filter(x -> {
				System.out.println("��·��"); // &&  ||
				return x.getSalary() > 5000;
			})
			.limit(5)
			.forEach(System.out::println);
	}
	
	@Test
	public void test5() {
		emps.parallelStream()
			.filter(x -> x.getSalary() >= 5000)
			.skip(2)
			.forEach(System.out::println);
	}
	
	@Test
	public void test51() {
		emps.stream()
			.filter(x -> x.getSalary() >= 5000)
			.skip(2)
			.forEach(System.out::println);
	}
	
	@Test
	public void test6() {
		emps.stream()
			.distinct()
			.forEach(System.out::println);
	}
	
}

































