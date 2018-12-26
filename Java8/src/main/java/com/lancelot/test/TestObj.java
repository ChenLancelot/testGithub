package com.lancelot.test;

public class TestObj implements Comparable{

	private String age;
	
	
	
	public String getAge() {
		return age;
	}



	public void setAge(String age) {
		this.age = age;
	}



	@Override
	public int compareTo(Object o) {
		if(o instanceof TestObj){
			TestObj o2 = (TestObj) o;
			return this.age.compareTo(o2.getAge());
		}
		return 0;
	}

}
