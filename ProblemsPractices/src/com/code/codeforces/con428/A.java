package com.code.codeforces.con428;

import java.util.Scanner;

public class A {
    public static void main(String args[]) {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
        int k = inp.nextInt();
        int min_try = -1;
        int remain = 0;
        for(int i = 0; i<n ; i++) {
            int tmp = inp.nextInt();
            remain +=tmp;
            if(remain>=8) {
                k -= 8;
                remain -=8;
            } else {
                k-=remain;
                remain=0;
            }
            if(k<=0 && min_try<0) {
                min_try = i+1;
            }
        }
        System.out.println(min_try);
    }
}
