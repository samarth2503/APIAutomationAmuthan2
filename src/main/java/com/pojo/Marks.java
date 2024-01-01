package com.pojo;

public class Marks {
	
	private int tamil;
	private int english;
	
	public Marks(int tamil, int english)
	{
		this.tamil = tamil;
		this.english = english;
	}
	
	public int getTamil()
	{
		return tamil;
	}
	
	public Marks setTamil(int tamil)
	{
		this.tamil = tamil;
		return this;
	}
	
	public int getEnglish()
	{
		return english;
	}

}
