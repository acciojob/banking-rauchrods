package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {

          BankAccount acc1 = new BankAccount("rauch",10000,500);
        System.out.println(acc1.generateAccountNumber(3,22));    ;
    }
}