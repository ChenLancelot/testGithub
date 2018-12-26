package com.lancelot.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/*
 * Java8 ���õ��Ĵ���ĺ���ʽ�ӿ�
 * 
 * Consumer<T> : �����ͽӿ�
 * 		void accept(T t);
 * 
 * Supplier<T> : �����ͽӿ�
 * 		T get(); 
 * 
 * Function<T, R> : �����ͽӿ�
 * 		R apply(T t);
 * 
 * Predicate<T> : �����ͽӿ�
 * 		boolean test(T t);
 * 
 */
public class Lambda3Test {
	
	//Consumer<T> �����ͽӿ� :
	@Test
	public void test1() {
		happy(1000D, x -> System.out.println(x * x));
	} 
	
	@Test
	public void test11() {
		happy(1000D, new Consumer<Double>() {
			@Override
			public void accept(Double t) {
				System.out.println(t * t);
			}
		});
	} 
	
	public void happy(double money, Consumer<Double> con) {
		con.accept(money);
	}
	
	//Supplier<T> �����ͽӿ� :
	@Test
	public void test2(){
		List<Integer> numList = getNumList(10, () -> (int)(Math.random() * 100));
		
		for (Integer num : numList) {
			System.out.println(num);
		}
	}
	
	//���󣺲���ָ�������������������뼯����
	public List<Integer> getNumList(int num, Supplier<Integer> sup){
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < num; i++) {
			Integer n = sup.get();
			list.add(n);
		}
		
		return list;
	}
	
	//Function<T, R> �����ͽӿڣ�
	@Test
	public void test3(){
		String strHandler = strHandler("        ����������һ����д          ", x -> x.trim());
		System.out.println(strHandler);

		String strHandler2 = strHandler("��˵��Ҫ�غ��ң�", x -> x.substring(2, 5));
		System.out.println(strHandler2);
	}
	
	//�������ڴ����ַ���
	public String strHandler(String str, Function<String, String> fun){
		return fun.apply(str);
	}
	
	//Predicate<T> �����ͽӿڣ�
	@Test
	public void test4(){
		List<String> list = Arrays.asList("Hello", "atguigu", "Lambda", "www", "ok");
		List<String> strList = filterStr(list, (s) -> s.length() > 3);
		
		for (String str : strList) {
			System.out.println(str);
		}
	}
	
	//���󣺽������������ַ��������뼯����
	public List<String> filterStr(List<String> list, Predicate<String> pre){
		List<String> strList = new ArrayList<>();
		
		for (String str : list) {
			if(pre.test(str)){
				strList.add(str);
			}
		}
		
		return strList;
	}
}
