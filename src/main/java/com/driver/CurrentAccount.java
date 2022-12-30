package com.driver;

import java.util.HashMap;
import java.util.Map;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception

     super(name,balance,5000);
     this.tradeLicenseId=tradeLicenseId;
        if(balance<5000){
            throw new Exception("Insufficient Balance");
        }
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        boolean isvalid=true;
        for(int i=0;i<tradeLicenseId.length()-1;i++){
            if(tradeLicenseId.charAt(i)==tradeLicenseId.charAt(i+1)){
                isvalid=false;
                break;
            }
        }
        if(!isvalid){
            Map<Character,Integer> hm = new HashMap<>();
            for(int i=0;i<tradeLicenseId.length();i++){
                if(!hm.containsKey(tradeLicenseId.charAt(i))){
                    hm.put(tradeLicenseId.charAt(i),1);
                }
                else{
                    hm.put(tradeLicenseId.charAt(i),hm.get(tradeLicenseId.charAt(i))+1);
                }
            }
            int maxvalue=0;
            for(Integer i: hm.values()){
                maxvalue=Math.max(maxvalue,i);
            }
            if(maxvalue>Math.ceil(tradeLicenseId.length()/2)){
                throw new Exception("Valid License can not be generated");
            }
        }
    }

}
