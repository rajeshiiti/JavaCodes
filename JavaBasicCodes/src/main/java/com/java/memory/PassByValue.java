package com.java.memory;

public class PassByValue {
	public static void main(String[] args) {
		int localValue = 5;
		calculate(localValue);
		System.out.println(localValue);
	}
	
	public static void calculate(int localValue) {
		localValue = localValue*100;
	}

}
