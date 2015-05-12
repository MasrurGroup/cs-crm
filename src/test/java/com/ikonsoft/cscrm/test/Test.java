package com.ikonsoft.cscrm.test;

public class Test {

	public static void main(String[] args) {
		int min=10000;
		int max=100000000;
		int rndNumber = (int) (Math.random() * (max - min)) + min;

        System.out.println("Number: " + rndNumber);

	}

}
