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
     * Has a border case of all positive doubles
     */
    public void withdraw (double amount) {
        balance -= amount;

    }

    /**
     * Border case of any string with prefixes of letters (a-z), numbers, underscores, periods, and dashes.
     * An underscore, period, or dash must be followed by one or more letter or number.
     * Email domain formats have letters, numbers, dashes.
     * The last portion of the domain must be at least two characters, for example: .com, .org, .cc
     */
    public static boolean isEmailValid(String email){
        int atSignIndex = email.indexOf(@);
        if (atSignIndex == -1) {
            return false;
        }
        if (atSignIndex == 0){
            return false;
        }
        int dotComIndex=email.indexOf(.,atSignIndex);
        if not (charAt(dotComIndex).equals(".") or charAt(dotComIndex+1).equals("c") or charAt(dotComIndex+2).equals("o") or charAt(dotComIndex+3).equals("m") ){
            return false;
        }
        else {
            return true;
        }
    }
}
