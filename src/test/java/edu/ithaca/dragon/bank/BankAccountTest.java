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
        //True Tests
        assertTrue(BankAccount.isEmailValid( "a@b.com"));
        //tests standard email with just one character as the username and one character as the website, not a border case
        assertTrue(BankAccount.isEmailValid( "a-a@b.com"));
        //tests one hyphen in the email, not a border case
        assertTrue(BankAccount.isEmailValid( "a_a@b.com"));
        //tests one underscore in the email, not a border case
        assertTrue(BankAccount.isEmailValid( "a@b.cc"));
        //tests .cc instead of .com, not a border case
        assertTrue(BankAccount.isEmailValid( "a@b.org"));
        // tests .org instead of .com, not a border case
        //False Tests
        assertFalse( BankAccount.isEmailValid(""));
        //tests no input as a false case, not a border case
        assertFalse(BankAccount.isEmailValid( "a-@b.com"));
        // tests hyphen before @ symbol which is a false case, not a border case
        assertFalse( BankAccount.isEmailValid("a..a@b.com"));
        // tests two dots next to each other which is a false case, not a border case
        //assertFalse(BankAccount.isEmailValid( "a@b..com"));
        //assertFalse(BankAccount.isEmailValid( "a@b.c"));
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