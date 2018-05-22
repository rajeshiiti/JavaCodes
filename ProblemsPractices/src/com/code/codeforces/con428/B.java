package com.code.codeforces.con428;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		int n = inp.nextInt();
		int k = inp.nextInt();
		List<Integer> sgroup = new ArrayList<Integer>();
		for(int i=0; i<k ;i++) {
			sgroup.add(inp.nextInt());
		}
		Collections.sort(sgroup, Collections.reverseOrder());
		int _4g = n;
		int _2g = 2*n;
		int _1g = 0;
		int oneCount = 0;
		
		for(int i=0; i < k ; i++) {
			int tmp = sgroup.get(i);
			while(tmp>=4 && _4g>0) {
				tmp-=4;
				_4g--;
			}
			while(tmp>=4 && _2g>0) {
				tmp-=2;
				_2g--;
			}
			sgroup.set(i, tmp);
		}
		for(int i=0; i < sgroup.size() ; i++) {
			int tmp = sgroup.get(i);
			if(tmp==3 && _4g>0) {
				tmp=0;
				_4g--;
			}
			if(tmp==3 && _2g>0) {
				tmp=1;
				_2g-=1;
				if(tmp>0 && _2g>0) {
					tmp=0;
					_2g-=1;
				}
			}
			sgroup.set(i, tmp);
		}
		for(int i=0; i < sgroup.size() ; i++) {
			int tmp = sgroup.get(i);
			if(tmp==2 && _4g>0) {
				tmp=0;
				_4g--;
				_1g++;
			}
			if(tmp==2 && _2g>0) {
				tmp=0;
				_2g-=1;
			}
			sgroup.set(i, tmp);
		}
		for(int i=0; i < sgroup.size() ; i++) {
			int tmp = sgroup.get(i);
			while(_4g>0 && tmp>0) {
				tmp--;
				_4g--;
				_1g++;
			}
			while(_2g>0 && tmp>0) {
				tmp--;
				_2g--;
			}
			while(_1g>0 && tmp>0) {
				tmp--;
				_1g--;
			}
			if(tmp>0) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
		
		inp.close();
		
	}

}
