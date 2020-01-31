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
        } else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
        if (isAmountValid(startingBalance)) {
            this.balance = startingBalance;
        } else {
            throw new IllegalArgumentException("Amount: " + startingBalance + " is invalid, cannot create account");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getEmail() {
        return email;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative, has 2 or fewer decimal places and is smaller than balance; too-large values throw an insufficient funds exception, and other incorrect values will throw an illegal argument exception.
     * Has a border case of all positive doubles
     */
    public void withdraw(double amount) throws InsufficientFundsException {
        if (isAmountValid(amount) == false) {
            throw new IllegalArgumentException("Amount: " + amount + " is invalid.");
        } else {
            if (amount > this.balance) {
                throw new InsufficientFundsException("Amount: " + amount + " is invalid.");
            } else {
                balance -= amount;
            }
        }

    }
    /**
     * @post increases the balance by amount if amount is non-negative and has two or fewer decimal places; incorrect values will throw an illegal argument exception.
     * Has a border case of all positive doubles
     */
    public void deposit(double amount) throws InsufficientFundsException {
        if (isAmountValid(amount) == false) {
            throw new IllegalArgumentException("Amount: " + amount + " is invalid.");
        } else {
            balance += amount;
        }
    }
    //Reduces the balance of the source by the amount, then adds that amount to the destination, assuming the amount is valid.
    //If the amount is larger than the source's balance, it throws an insufficient funds exception, and if it is otherwise invalid, it throws an illegal argument exception.
    static void transfer(BankAccount source, BankAccount destination, double amount) throws InsufficientFundsException {
        if (isAmountValid(amount) == false) {
            throw new IllegalArgumentException("Amount: " + amount + " is invalid.");
        } else {
            if (amount > source.balance) {
                throw new InsufficientFundsException("Amount: " + amount + " is invalid.");
            } else {
                source.withdraw(amount);
                destination.deposit(amount);
            }
        }
    }

    public static boolean isAmountValid(double amount){
        if (amount  < 0) {
            return false;
        }
        String amountChecker = Double.toString(amount);
        if (amountChecker.length() - amountChecker.indexOf('.') - 1 > 2){
            return false;
        }
        return true;
    }

    /**
     * Border case of any string with prefixes of letters (a-z), numbers, underscores, periods, and dashes.
     * An underscore, period, or dash must be followed by one or more letter or number.
     * Email domain formats have letters, numbers, dashes.
     * The last portion of the domain must be at least two characters, for example: .com, .org, .cc
     */
    public static boolean isEmailValid(String email) {
        //Fails if more than 1 @ sign is present.
        if (email.lastIndexOf("@") != email.indexOf("@")) {
            return false;
        }
        int atSignIndex = email.indexOf("@");
        //Fails if @ sign is not present.
        if (atSignIndex == -1) {
            return false;
        }
        //Fails if @ sign is the first symbol.
        if (atSignIndex == 0) {
            return false;
        }
        //before @ checks
        int beforeAt=atSignIndex-1;
        //Fails if a period is followed by another period.
        if (email.charAt(email.indexOf('.') + 1) == '.'){
            return false;
        }
        //Fails if a dash is adjacent to the @.9
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
