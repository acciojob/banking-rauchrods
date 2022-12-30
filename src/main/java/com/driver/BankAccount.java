package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    private String AccountNumber;  // myvariable

    public BankAccount(String name, double balance, double minBalance) {
         this.name=name;
         this.balance=balance;
         this.minBalance=minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        AccountNumber="";

          generatepassword("",digits,sum);
          if(AccountNumber.length()==0){
              throw new Exception("Account Number can not be generated");
          }
        return AccountNumber;
    }

    public void deposit(double amount) {
        //add amount to balance
         balance+=amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
       if(amount<=balance){
           balance-=amount;
           if(balance<minBalance){
               throw new Exception("Insufficient Balance");
           }
       }
    }

    public void generatepassword(String ansstr, int digits, int sum){

        if(ansstr.length()>=digits){
            int newsum=0;
            for(int i=0;i<ansstr.length();i++) {
                newsum += (int)(ansstr.charAt(i)-'0');
            }
          if(newsum==sum){
              this.AccountNumber=ansstr;
          }
          return;
        }

        for(int i=0;i<10;i++){
            generatepassword(ansstr+Integer.toString(i), digits, sum);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }
}