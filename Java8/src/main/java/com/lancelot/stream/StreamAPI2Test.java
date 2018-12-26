package com.lancelot.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

import com.lancelot.lambda.Employee;
import com.lancelot.lambda.Employee.Status;

/*
 * һ�� Stream �Ĳ�������
 * 
 * 1. ���� Stream
 * 
 * 2. �м����
 * 
 * 3. ��ֹ����
 */
public class StreamAPI2Test {
	List<Employee> emps = Arrays.asList(
			new Employee(102, "����", 59, 6666.66, Status.BUSY),
			new Employee(101, "����", 18, 9999.99, Status.FREE),
			new Employee(103, "����", 28, 3333.33, Status.VOCATION),
			new Employee(104, "����", 8, 7777.77, Status.BUSY),
			new Employee(104, "����", 8, 7777.77, Status.FREE),
			new Employee(104, "����", 8, 7777.77, Status.FREE),
			new Employee(105, "����", 38, 5555.55, Status.BUSY)
	);
	
	//3. ��ֹ����
	/*
		allMatch��������Ƿ�ƥ������Ԫ��
		anyMatch��������Ƿ�����ƥ��һ��Ԫ��
		noneMatch��������Ƿ�û��ƥ���Ԫ��
		findFirst�������ص�һ��Ԫ��
		findAny�������ص�ǰ���е�����Ԫ��
		count������������Ԫ�ص��ܸ���
		max���������������ֵ
		min��������������Сֵ
	 */
	@Test
	public void test1() {
		boolean bl = emps.stream()
				.allMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(bl);
		
		boolean bl1 = emps.stream()
				.anyMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(bl1);
		
		boolean bl2 = emps.stream()
				.noneMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(bl2);
	}

	@Test
	public void test2(){
		Optional<Employee> op = emps.stream()
			.sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
			.findFirst();
			
		System.out.println(op.get());
		
		System.out.println("--------------------------------");
		
		Optional<Employee> op2 = emps.parallelStream()
			.filter((e) -> e.getStatus().equals(Status.FREE))
			.findAny();
		
		System.out.println(op2.get());
	}

	@Test
	public void test3() {
		long count = emps.stream()
				 .filter((e) -> e.getStatus().equals(Status.FREE))
				 .count();

		System.out.println(count);
		
		Optional<Double> op = emps.stream()
			.map(Employee::getSalary)
			.max(Double::compare);
		System.out.println(op.get());
		
		Optional<Employee> op2 = emps.stream()
				.min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
			
		System.out.println(op2.get());
	}
	
	//ע�⣺����������ֹ�����󣬲����ٴ�ʹ��
	@Test
	public void test4(){
		Stream<Employee> stream = emps.stream()
		 .filter((e) -> e.getStatus().equals(Status.FREE));
		
		long count = stream.count();
		System.out.println(count);
		
		stream.map(Employee::getSalary)
			.max(Double::compare);
	}
}

