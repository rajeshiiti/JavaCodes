package com.code.codeforces.con425;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class B {
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		String goodStr = inp.nextLine();
		String pattern = inp.nextLine();
		int query = inp.nextInt();
		inp.nextLine();
		List<String> ls = new ArrayList<String>();
		for(int i=0;i<query;i++) {
			ls.add(inp.nextLine());
		}
		Set<Integer> gSet = new HashSet<Integer>();
		Set<Integer> bSet = new HashSet<Integer>();
		for(int i=0;i<goodStr.length();i++) {
			gSet.add((int)goodStr.charAt(i) - 97);
		}
		for(int i=0;i<26;i++) {
			if(!gSet.contains(i)) {
				bSet.add(i);
			}
		}
		int star_position = -1;
		for(int i=0;i<pattern.length();i++) {
			if(pattern.charAt(i)=='*') {
				star_position=i;
				break;
			}
		}
		
		for(int i=0; i<query;i++) {
			String s = ls.get(i);
			boolean match = true;
			if(star_position>-1) {
				int j=0;
				while(j<star_position && match) {
					if( (j< s.length() && pattern.charAt(j)==s.charAt(j)) 
							|| (j<s.length() && pattern.charAt(j)=='?' && gSet.contains((int)s.charAt(j) - 97)) ) {
						j++;
						continue;
					} else {
						match = false;
					}
				}
				int rs=s.length()-1;
				int k = pattern.length()-1;
				while(k>star_position && match) {
					if(rs>=star_position && pattern.charAt(k)==s.charAt(rs) 
							|| (rs>= star_position && pattern.charAt(k)=='?' && gSet.contains((int)s.charAt(rs) -97))) {
						k--;
						rs--;
						continue;
					} else {
						match = false;
					}
				}
				while( (!(j==rs && s.length()==pattern.length()-1)) && j<=rs && match) {
					if( bSet.contains((int)s.charAt(j)-97) ) {
						j++;
					} else {
						match=false;
					}
				}
			} else {
				if(pattern.length()==s.length()) {
					int j=0;
					while(j<pattern.length() && match) {
						if( (pattern.charAt(j)==s.charAt(j)) 
								|| (pattern.charAt(j)=='?' && gSet.contains( (int)s.charAt(j) -97)) ) {
							j++;
							continue;
						} else {
							match = false;
						}
					}
					
				} else {
					match = false;
				}
			}
			if(match) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		
		inp.close();
	}

}
