<<<<<<< HEAD
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
=======
package edu.ithaca.dragon.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance) {
        if (isEmailValid(email)) {
            this.email = email;
            this.balance = startingBalance;
        } else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getEmail() {
        return email;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance; other values will have no change
     * Has a border case of all positive doubles
     */
    public void withdraw(double amount) {
        balance -= amount;

    }

    /**
     * Border case of any string with prefixes of letters (a-z), numbers, underscores, periods, and dashes.
     * An underscore, period, or dash must be followed by one or more letter or number.
     * Email domain formats have letters, numbers, dashes.
     * The last portion of the domain must be at least two characters, for example: .com, .org, .cc
     */
    public static boolean isEmailValid(String email) {
        int atSignIndex = email.indexOf("@");
        if (atSignIndex == -1) {
            return false;
        }
        if (atSignIndex == 0) {
            return false;
        }
        //before @ check
        int beforeAt=atSignIndex-1;
        if (email.charAt(email.indexOf('.') + 1) == '.'){
            return false;
        }
        if( email.indexOf('@') - 1 == email.indexOf('-')){
            return false;
        }
        if(email.indexOf('@') + 1 == email.indexOf('-')){
            return false;
        }
        //check if it has .com

        int dotComIndex = email.indexOf(".", atSignIndex);
        char c = 'c';
        if (Character.compare(email.charAt(dotComIndex + 1), Character.valueOf('c')) == 0) {
            if (Character.compare(email.charAt(dotComIndex + 2), Character.valueOf('o')) == 0) {
                if (Character.compare(email.charAt(dotComIndex + 3), Character.valueOf('m')) == 0) {
                    return true;
                }
            }
        }
        if (Character.compare(email.charAt(dotComIndex + 1), Character.valueOf('o')) == 0) {
            if (Character.compare(email.charAt(dotComIndex + 2), Character.valueOf('r')) == 0) {
                if (Character.compare(email.charAt(dotComIndex + 3), Character.valueOf('g')) == 0) {
                    return true;
                }
            }
        }
        if (Character.compare(email.charAt(dotComIndex + 1), Character.valueOf('c')) == 0) {
            if (Character.compare(email.charAt(dotComIndex + 2), Character.valueOf('c')) == 0) {
                    return true;
            }
        }
        return false;
    }
}

>>>>>>> master
