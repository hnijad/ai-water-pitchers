package com.hnijad;

public class Main {
    public static void main(String[] args) {
        try {
            String fileName = args[0];
            var input = Reader.getInput(fileName);
            System.out.println(input);
            Solution sol = new Solution(input);
            System.out.println(sol.getMinStepsUsingAStar());
        } catch (Exception e) {
            System.out.println("Exception happened:  " + e.getMessage());
        }
    }
}