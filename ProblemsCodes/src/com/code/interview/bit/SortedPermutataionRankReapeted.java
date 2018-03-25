package com.code.interview.bit;

public class SortedPermutataionRankReapeted {
	public static void main(String[] args) {
		System.out.println(rankPerm("GGAABGAA"));
	}
	public static long mod = 1000003;
	public static long rankPerm(String perm) {
	    long rank = 1;
	    long suffixPermCount = 1;
	    java.util.Map<Character, Integer> charCounts =
	        new java.util.HashMap<Character, Integer>();
	    for (int i = perm.length() - 1; i > -1; i--) {
	        char x = perm.charAt(i);
	        int xCount = charCounts.containsKey(x) ? charCounts.get(x) + 1 : 1;
	        charCounts.put(x, xCount);
	        for (java.util.Map.Entry<Character, Integer> e : charCounts.entrySet()) {
	            if (e.getKey() < x) {
	                rank += suffixPermCount * e.getValue() / xCount;
	                rank = rank %mod;
	            }
	        }
	        suffixPermCount *= perm.length() - i;
	        suffixPermCount /= xCount;
	    }
	    return rank % mod;
	}
}
