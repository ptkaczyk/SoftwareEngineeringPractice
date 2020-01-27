package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    /*
    Has an equivalence class with other functions: withdrawtest, complexwithdraw test
 */
    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());
    }
    /*
    Has an equivalence class with other functions: withdrawtest, complexwithdraw test
    Has a border case of all positive doubles
    */
    @Test
    void withdrawTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);

        assertEquals(100, bankAccount.getBalance());
    }

    /*
    Has an equivalence class with other functions: withdrawtest, getbalance test

     */
    @Test
    void complexWithdrawTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(-100);

        assertEquals(200, bankAccount.getBalance());

        bankAccount.withdraw(500);

        assertEquals(200, bankAccount.getBalance());
    }

    /*
    has an equivalence class with constructor
    Border case of any string with prefixes of letters (a-z), numbers, underscores, periods, and dashes.
     * An underscore, period, or dash must be followed by one or more letter or number.
     * Email domain formats have letters, numbers, dashes.
     * The last portion of the domain must be at least two characters, for example: .com, .org, .cc
     */
    @Test
    void isEmailValidTest(){
        assertTrue(BankAccount.isEmailValid( "a@b.com"));
        assertFalse( BankAccount.isEmailValid(""));
    }
    /*
    has an equivalence class with constructor
    Border case of any string with prefixes of letters (a-z), numbers, underscores, periods, and dashes.
     * An underscore, period, or dash must be followed by one or more letter or number.
     * Email domain formats have letters, numbers, dashes.
     * The last portion of the domain must be at least two characters, for example: .com, .org, .cc
     */
    @Test
    void emailValidComplexTest(){
        assertFalse( BankAccount.isEmailValid("@b.com"));
        assertFalse( BankAccount.isEmailValid("a@"));
    }
    /*
    Has an equivalence class with other all other functions

 */
    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
    }

}