package com.lancelot.stream;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import com.lancelot.lambda.Employee;
import com.lancelot.lambda.Employee.Status;


public class StreamAPI3Test {
	
	List<Employee> emps = Arrays.asList(
			new Employee(102, "����", 79, 6666.66, Status.BUSY),
			new Employee(101, "����", 18, 9999.99, Status.FREE),
			new Employee(103, "����", 28, 3333.33, Status.VOCATION),
			new Employee(104, "����", 8, 7777.77, Status.BUSY),
			new Employee(104, "����", 8, 7777.77, Status.FREE),
			new Employee(104, "����", 8, 7777.77, Status.FREE),
			new Employee(105, "����", 38, 5555.55, Status.BUSY)
	);
	
	//3. ��ֹ����
	/*
		��Լ
		reduce(T identity, BinaryOperator) / reduce(BinaryOperator) �������Խ�����Ԫ�ط�������������õ�һ��ֵ��
	 */
	@Test
	public void test1(){
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

		Integer reduce = list.stream()
			.reduce(2, (x, y) -> (x + y));
		System.out.println(reduce);
		
		System.out.println("----------------------------------------");

		Optional<Double> op = emps.stream()
			.map(Employee::getSalary)
			.reduce(Double::sum);
		System.out.println(op.get());
		
	}
	
	//�������������� ������ ���ֵĴ���
	@Test
	public void test2(){
		Optional<Integer> sum = emps.stream()
			.map(Employee::getName)
			.flatMap(StreamAPI1Test::filterCharacter)
			.map((ch) -> {
				if(ch.equals('1'))
					return 1;
				else 
					return 0;
			}).reduce(Integer::sum);
		
		System.out.println(sum.get());
	}
	
	//collect��������ת��Ϊ������ʽ������һ�� Collector�ӿڵ�ʵ�֣����ڸ�Stream��Ԫ�������ܵķ���
	@Test
	public void test3() {
		List<String> list = emps.stream()
			.map(Employee::getName)
			.collect(Collectors.toList());
		list.forEach(System.out::println);
		
		System.out.println("----------------------------------");
		
		Set<String> set = emps.stream()
			.map(Employee::getName)
			.collect(Collectors.toSet());
		
		set.forEach(System.out::println);
		System.out.println("----------------------------------");

		HashSet<String> hs = emps.stream()
				.map(Employee::getName)
				.collect(Collectors.toCollection(HashSet::new));
			
		hs.forEach(System.out::println);
	}
	
	@Test
	public void test4() {
		Optional<Double> max = emps.stream()
			.map(Employee::getSalary)
			.collect(Collectors.maxBy(Double::compareTo));
		System.out.println(max.get());
		//(e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())
		
		Optional<Employee> min = emps.stream()
			.collect(Collectors.minBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
		
		System.out.println(min.get());
		
		Double sum = emps.stream()
			.collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println(sum);
		
		Double sum2 = emps.stream()
			.collect(Collectors.summingDouble(e -> e.getSalary()));
		System.out.println(sum2);
		
		Double average = emps.stream()
			.collect(Collectors.averagingDouble(e -> e.getSalary()));
		System.out.println(average);
		
		Long count = emps.stream()
			.collect(Collectors.counting());
		System.out.println(count);
		
		Long count2 = emps.stream().count();
		System.out.println(count2);
		
		System.out.println("--------------------------------------------");
		
		DoubleSummaryStatistics dss = emps.stream()
			.collect(Collectors.summarizingDouble(e -> e.getSalary()));
		System.out.println(dss.getMax());
	}
	
	/**
	 * ����
	 */
	@Test
	public void test5() {
		Map<Status, List<Employee>> map = emps.stream()
			.collect(Collectors.groupingBy(Employee::getStatus));
		for (Object key : map.keySet()) {
			for (Employee e : map.get(key)){
				System.out.println(e);
			}
			System.out.println();
		}
	}
	
	/**
	 * �༶����
	 */
	@Test
	public void test6() {
		Map<Status, Map<String, List<Employee>>> map = emps.stream()
			.collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
				if(e.getAge() >= 60)
					return "����";
				else if(e.getAge() >= 35)
					return "����";
				else
					return "����";
			})));
			
		System.out.println(map);
	}
	
	/**
	 * ����
	 */
	@Test
	public void test7() {
		Map<Boolean, List<Employee>> partition = emps.stream()
			.collect(Collectors.partitioningBy(e -> e.getSalary() > 5000));
		System.out.println(partition);
		for (Object key : partition.keySet()) {
			for (Employee e : partition.get(key)){
				System.out.println(key + ":" + e);
			}
			System.out.println();
		}
	}
	
	/**
	 * ��������ÿ���ַ���
	 */
	@Test
	public void test8() {
		String str = emps.stream()
			.map(Employee::getName)
			.collect(Collectors.joining(","));
		System.out.println(str);
		
		String str2 = emps.stream()
			.map(Employee::getName)
			.collect(Collectors.joining("," , "----", "----"));
		System.out.println(str2);
	}
	
	@Test
	public void test9(){
		Optional<Double> sum = emps.stream()
			.map(Employee::getSalary)
			.collect(Collectors.reducing(Double::sum));
		
		System.out.println(sum.get());
	}
	
	@Test
	public void test10 (){
		emps.forEach(System.out::println);
		
		emps.forEach(x -> {
			x.setAge(80);
		});
		System.out.println("------------------------------");
		emps.forEach(System.out::println);
	}
	
}
