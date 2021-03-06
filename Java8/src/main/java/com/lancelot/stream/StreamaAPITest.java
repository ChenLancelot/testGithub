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
 * 1.创建流
 * 
 * 2.中间操作
 * 
 * 3.终止操作
 */
public class StreamaAPITest {

	@Test
	public void test1(){
		//1. 创建 Stream
		List<String> list = new ArrayList<String>();
		Stream<String> stream = list.stream();	// 获取一个顺序流
		Stream<String> parallelStream = list.parallelStream(); // 获取一个并行流
		
		//2. 通过 Arrays 中的 stream() 获取一个数组流
		Integer[] arr = new Integer[10];
		Stream<Integer> stream2 = Arrays.stream(arr);
		
		//3. 通过 Stream 类中静态方法 of()
		Stream<Integer> of = Stream.of(arr);
		
		//4. 创建无限流
		//迭代
		Stream<Integer> stream3 = Stream.iterate(0, x -> x + 2);
		
		Stream<Double> stream4 = Stream.generate(Math::random).limit(2);
		stream4.forEach(System.out::println);
	}
	
	//2. 中间操作
	List<Employee> emps = Arrays.asList(
			new Employee(102, "李四", 59, 6666.66),
			new Employee(101, "张三", 18, 9999.99),
			new Employee(103, "王五", 28, 3333.33),
			new Employee(104, "赵六", 8, 7777.77),
			new Employee(104, "赵六", 8, 7777.77),
			new Employee(104, "赵六", 8, 7777.77),
			new Employee(105, "田七", 38, 5555.55)
	);
	
	/*
	  筛选与切片
		filter——接收 Lambda ， 从流中排除某些元素。
		limit——截断流，使其元素不超过给定数量。
		skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
		distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
	 */
	
	//内部迭代：迭代操作 Stream API 内部完成
	@Test
	public void test2() {
		//所有的中间操作不会做任何的处理
		Stream<Employee> stream = emps.stream()
				.filter(x -> {
					System.out.println("测试中间操作");
					return x.getAge() < 35;
			});
		stream.forEach(System.out::println);
	}
	
	//外部迭代
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
				System.out.println("短路！"); // &&  ||
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

































