package com.code.codeforces.con425;

import java.math.BigInteger;
import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		String n = inp.nextLine();
		String[] strArray= n.split(" ");
		BigInteger bd = new BigInteger(strArray[0]);
		BigInteger bd1 = new BigInteger(strArray[1]);
		BigInteger bigDivide = bd.divide(bd1);
		BigInteger b2 = new BigInteger("2");
		BigInteger b1 = new BigInteger("1");
		if(bigDivide.mod(b2).equals(b1)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		inp.close();
	}

}