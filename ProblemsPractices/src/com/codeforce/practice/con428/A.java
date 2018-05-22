package com.codeforce.practice.con428;

import java.util.Scanner;

//public class A {
//    public static void main(String args[]) {
//        Scanner inp = new Scanner(System.in);
//        int n = inp.nextInt();
//        int k = inp.nextInt();
//        int min_try = -1;
//        int remain = 0;
//        for(int i = 0; i<n ; i++) {
//            int tmp = inp.nextInt();
//            remain +=tmp;
//            if(remain>=8) {
//                k -= 8;
//                remain -=8;
//            } else {
//                k-=remain;
//                remain=0;
//            }
//            if(k<=0 && min_try<0) {
//                min_try = i+1;
//            }
//        }
//        System.out.println(min_try);
//    }
//}
import java.io.*;
import java.util.*;


class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            int n = Integer.parseInt(br.readLine().trim());

            int out_ = solve(n);
            System.out.println(out_);
            System.out.println("");
        }

        wr.close();
        br.close();
    }
    static int solve(int n){
        long tmp = 1000000007L;
        long num1 = (long) (n+1);
        long num2 = (long) (n+2);
        long num3 = (long) (n+3);
        long num4 = (long) (n+4);
        int value = 24;
        if(num1%2==0 && value%2==0) {
            num1 = num1/2;
            value = value/2;
        } else if(num1%3==0 && value%3==0) {
            num1 = num1/3;
            value = value/3;
        }

        if(num2%2==0 && value%2==0) {
            num2 = num2/2;
            value = value/2;
        } else if(num2%3==0 && value%3==0) {
            num2 = num2/3;
            value = value/3;
        }
        if(num3%2==0 && value%2==0) {
            num3 = num3/2;
            value = value/2;
        } else if(num3%3==0 && value%3==0) {
            num3 = num3/3;
            value = value/3;
        }
        if(num4%2==0 && value%2==0) {
            num4 = num4/2;
            value = value/2;
        } else if(num4%3==0 && value%3==0) {
            num4 = num4/3;
            value = value/3;
        }

        long ans =  (((num3*((num1*num2)%tmp))%tmp)*num4)%tmp;
        return (int) ans;
    }
}