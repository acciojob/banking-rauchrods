package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {

          BankAccount acc1 = new BankAccount("rauch",10000,500);
        System.out.println(acc1.generateAccountNumber(3,22));

        SavingsAccount  s1 = new SavingsAccount("lala",1000,500,7);
        s1.withdraw(500);
        System.out.println(s1.getSimpleInterest(5));
        System.out.println(s1.getCompoundInterest(1,5));;

        CurrentAccount c1 = new CurrentAccount("bambu",10000,"ABCDDD");
        c1.validateLicenseId();

    }
}