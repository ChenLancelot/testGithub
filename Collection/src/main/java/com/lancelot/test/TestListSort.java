package com.lancelot.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestListSort {
	
	public static void main(String[] args) {
		AreaCode code = new AreaCode("003001002");
		AreaCode code2 = new AreaCode("003001");
		AreaCode code3 = new AreaCode("003002");
		AreaCode code4 = new AreaCode("003001004");
		AreaCode code5 = new AreaCode("003002002");
		AreaCode code6 = new AreaCode("003001003");
		AreaCode code7 = new AreaCode("003");
		
		List<AreaCode> list = new ArrayList<AreaCode>();
		list.add(code);
		list.add(code2);
		list.add(code3);
		list.add(code4);
		list.add(code5);
		list.add(code6);
		list.add(code7);
		
		Collections.sort(list, new Comparator<AreaCode>(){
			@Override
			public int compare(AreaCode c1, AreaCode c2) {
				return c1.getCode().compareTo(c2.getCode());
			}
		});
		
		for(AreaCode c: list){
			System.out.println(c.getCode());
		}
	}
	
	
}
