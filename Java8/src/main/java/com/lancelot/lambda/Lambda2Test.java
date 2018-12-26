package com.lancelot.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.junit.Test;

public class Lambda2Test {
	
	@Test
	public void test1(){
		int num = 0;//jdk 1.7 前，必须是 final
		
		Runnable r = new Runnable(){
			@Override
			public void run() {
				System.out.println("Hello World!" + num);
			}
		};
		
		r.run();
		System.out.println("-------------------------------");
		
		Runnable r2 = () -> System.out.println("Hello World!" + num);
		r2.run();
	}
	
	@Test
	public void test2(){
		Consumer<String> con2 = new Consumer<String>(){

			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
		con2.accept("fei lambda");
		
		Consumer<String> con = x -> System.out.println(x);
		con.accept("string");
	}
	
	@Test
	public void test3(){
		Comparator<Integer> com = (x, y) -> {
			System.out.println("函数式接口");
			return Integer.compare(x, y);
		};
	}
	
	@Test
	public void test4(){
		Comparator<Integer> c1 = (o1,o2) -> Integer.compare(o1, o2);
	}
	
	@Test
	public void test5(){
//		String[] strs;
//		strs = {"aaa", "bbb", "ccc"};
		
		List<String> list = new ArrayList<>();
		
		show(new HashMap<>());
	}

	public void show(Map<String, Integer> map){
		
	}
	
	//需求：对一个数进行运算
	@Test
	public void test6(){
		Integer num = operation(100, (x) -> x * x);
		System.out.println(num);
		
		System.out.println(operation(200, (y) -> y + 200));
	}
	
	public Integer operation(Integer num, MyFun mf){
		return mf.getValue(num);
	}
}
