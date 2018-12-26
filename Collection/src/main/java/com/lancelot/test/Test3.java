package com.lancelot.test;

import java.util.ArrayList;
import java.util.List;

public class Test3 {
	public static void main(String[] args) {
		AreaLevel a1 = new AreaLevel("003",1);
		AreaLevel a2 = new AreaLevel("003001",2);
		AreaLevel a3 = new AreaLevel("003001",3);
		AreaLevel a4 = new AreaLevel("003",1);
		AreaLevel a5 = new AreaLevel("003001",2);
		
		AreaLevel a6 = new AreaLevel("003001",2);
		
		List<AreaLevel> list = new ArrayList<>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		list.add(a4);
		list.add(a5);
		
		System.out.println(list.contains(a6));
	}
}
class AreaLevel{
	private String areaCode;
	
	private Integer level;

	public AreaLevel() {
		super();
	}

	public AreaLevel(String areaCode, Integer level) {
		super();
		this.areaCode = areaCode;
		this.level = level;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((areaCode == null) ? 0 : areaCode.hashCode());
//		result = prime * result + ((level == null) ? 0 : level.hashCode());
//		return result;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AreaLevel other = (AreaLevel) obj;
		if (areaCode == null) {
			if (other.areaCode != null)
				return false;
		} else if (!areaCode.equals(other.areaCode))
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AreaLevel [areaCode=" + areaCode + ", level=" + level + "]";
	}
}