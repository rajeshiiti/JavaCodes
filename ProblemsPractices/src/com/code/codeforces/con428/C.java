package com.code.codeforces.con428;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class C {
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		int n = inp.nextInt();
		if(n==1) {
			System.out.println("0.00000000");
			return;
		}
		Map<Integer, Node> maps = new HashMap<Integer, Node>();
		
		for(int i =0;i<n; i++) {
			maps.put(i+1, new Node(0,0));
		}
		for(int i=0;i<n-1;i++) {
			int a = inp.nextInt();
			int b = inp.nextInt();
			maps.get(a).neighbourList.add(b);
			maps.get(b).neighbourList.add(a);
		}
		for(int i=0;i<n-1;i++) {
			Node node = maps.get(i+1);
			if(!node.isVisited) {
				node.d = dfs(node, maps);
			}
			
		}
		/***
		 * DecimalFormat df = new DecimalFormat("#.####");
			df.setRoundingMode(RoundingMode.CEILING);
			for (Number n : Arrays.asList(12, 123.12345, 0.23, 0.1, 2341234.212431324)) {
			    Double d = n.doubleValue();
			    System.out.println(df.format(d));
			}
		 */
		System.out.println( maps.get(1).d);
		inp.close();
	}
	public static double dfs(Node node, Map<Integer, Node> maps) {
		if(node.isVisited) {
			return 0.0000000;
		}
		node.isVisited = true;
		double no_child = 0.0000;
		for(Integer nd:node.neighbourList){
			if(!maps.get(nd).isVisited) {
				node.isAnyChild = true;
				Node nod = maps.get(nd);
				node.d = node.d+ dfs(nod, maps) +1.0000000;
				no_child = no_child + 1.0000000;
			}
		}
		if (no_child >0 ) {
			node.d = node.d / no_child;
		}
		
		return node.d;
	}

}
class Node {
	int p;
	double d;
	boolean isVisited;
	boolean isAnyChild;
	List<Integer> neighbourList;
	Node(int p, double d) {
		this.p = p;
		this.d = d;
		this.isAnyChild = false;
		this.isVisited = false;
		this.neighbourList = new ArrayList<Integer>();
	}
	
}