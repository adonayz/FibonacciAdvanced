package com.company;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> input = new LinkedList<>();
        HashMap<Integer, BigInteger> fibHash = new HashMap<>();
        fibHash.put(0, BigInteger.ZERO);
        fibHash.put(1, BigInteger.ONE);

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()){
            findFibonacci(fibHash, scanner.nextInt());
            scanner.nextLine();
        }
    }

    public static void findFibonacci(HashMap<Integer, BigInteger> fibHash, int n){

        if(n == 0){
            System.out.println(0);
        }else if(n == 1){
            System.out.println(1);
        }else if(fibHash.containsKey(n - 1)){
            System.out.println(fibHash.get(n-1).add(fibHash.get(n-2)));
        }else{
            calculateFibonacci(fibHash, n);
            System.out.println(fibHash.get(n-1).add(fibHash.get(n-2)));
        }
    }

    public static void calculateFibonacci(HashMap<Integer, BigInteger> fibHash, int n){
        BigInteger fibOfN;
        int max = Collections.max(fibHash.keySet());
        BigInteger fibOfNMinusOne = fibHash.get(max);
        BigInteger fibOfNMinusTwo = fibHash.get(max - 1);
        for(int i = max; i <= n; i++){
            fibOfN = fibOfNMinusOne.add(fibOfNMinusTwo);
            fibHash.put(++max, fibOfN);
            fibOfNMinusTwo = fibOfNMinusOne;
            fibOfNMinusOne = fibOfN;
        }
    }
}
