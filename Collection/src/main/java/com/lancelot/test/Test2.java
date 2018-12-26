package com.lancelot.test;

public class Test2 {
	public static void main(String[] args) {
		Worker work = new Worker();
		work.setShengao(130);
		System.out.println(work.getShengao());
	}
}



class Worker{
	private Integer age = 1;

	private Integer shengao;
	public Worker() {
		super();
	}

	public Worker(Integer age) {
		super();
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getShengao() {
		return shengao;
	}

	public void setShengao(Integer shengao) {
		this.shengao = shengao;
	}
	
	
}
