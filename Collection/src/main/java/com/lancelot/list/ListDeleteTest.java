package com.lancelot.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListDeleteTest {
	
	private List<Integer> list;
	
	@Before
	public void createList(){
		list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	}
	
	@After
	public void printlnList(){
		System.out.println("------------------------");
		for(Integer temp: list){
			System.out.println(temp);
		}
	}
	
	
	@Test
	public void test(){
		for(Integer temp: list){
			System.out.println(temp);
		}
	}	
	
	@Test
	public void test2(){
		for (int i = 0; i < list.size(); i++) {
		    if (2 == list.get(i)) {
		    	list.remove(i);
		    }
		}
	}
	
	@Test
	public void test3(){
		for (Integer a : list) {
		    if (2 == a) {
		    	list.remove(a);
		    }
		}
	}
	
	@Test
	public void test4() {
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()){
		    Integer s = iter.next();
		    if(2 == s){
		    	System.out.println("sdf");
		        iter.remove();
		    }
		}
		System.out.println(list);
//		for(Integer temp: list){
//			System.out.println(temp);
//		}
	}
}
