package edu.ithaca.dragon.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance; other values will have no change
     */
    public void withdraw (double amount)  {
        balance -= amount;

    }


    public static boolean isEmailValid(String email){
        int atSignIndex = email.indexOf("@");
        if (atSignIndex == -1) {
            return false;
        }
        if (atSignIndex == 0){
            return false;
        }
        int dotComIndex=email.indexOf(email.indexOf("."));
        if( not (email.charAt(dotComIndex)==(".") or email.charAt(dotComIndex+1)==("c") or email.charAt(dotComIndex+2)==("o") or email.charAt(dotComIndex+3)==("m")) ){
            return false;
        }
        else {
            return true;
        }
    }
}
