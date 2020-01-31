package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankAccountTest {

    /*
    Has an equivalence class with other functions: withdrawtest, complexwithdraw test
 */

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 1);

        assertEquals(1, bankAccount.getBalance());

        BankAccount bankAccount2 = new BankAccount("a@b.com", 0);

        assertEquals(0, bankAccount2.getBalance());
    }

    /*
    Has an equivalence class with other functions: withdrawtest, complexwithdraw test
    Has a border case of all positive doubles
    */

    @Test
    void withdrawTest() throws InsufficientFundsException {
        BankAccount bankAccount = new BankAccount("a@b.com", 2);
        bankAccount.withdraw(1);

        assertEquals(1, bankAccount.getBalance());

        bankAccount.withdraw(0);
        assertEquals(1, bankAccount.getBalance());
    }


    /*
    Has an equivalence class with other functions: withdrawtest, getbalance test

     */

    @Test
    void complexWithdrawTest() throws InsufficientFundsException {
        BankAccount bankAccount = new BankAccount("a@b.com", 1);

        //EC: Negative numbers
        assertThrows(IllegalArgumentException.class, ()-> bankAccount.withdraw(-1));
        assertThrows(IllegalArgumentException.class, ()-> bankAccount.withdraw(0.001));
        assertEquals(1, bankAccount.getBalance());

        //EC: Amounts larger than the balance
        assertThrows(InsufficientFundsException.class, ()-> bankAccount.withdraw(2));
        assertEquals(1, bankAccount.getBalance());

        //EC: Legal amounts
        bankAccount.withdraw(1);
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void depositTest() throws InsufficientFundsException {
        BankAccount bankAccount = new BankAccount("a@b.com", 1);
        bankAccount.deposit(1);

        assertEquals(2, bankAccount.getBalance());

        bankAccount.withdraw(0);
        assertEquals(2, bankAccount.getBalance());

        //EC: Negative numbers
        assertThrows(IllegalArgumentException.class, ()-> bankAccount.deposit(-1));
        assertThrows(IllegalArgumentException.class, ()-> bankAccount.deposit(0.001));
        assertEquals(2, bankAccount.getBalance());

        //EC: Legal amounts
        bankAccount.deposit(2);
        assertEquals(4, bankAccount.getBalance());
    }

    @Test
    void transferTest() throws InsufficientFundsException {
        //EC: Legal interaction
        BankAccount source = new BankAccount ("a@b.com", 2);
        BankAccount destination = new BankAccount("a@b.com", 0);
        BankAccount.transfer(source, destination, 1);
        assertEquals(1, source.getBalance());
        assertEquals(1, destination.getBalance());

        //EC: Negative values
        assertThrows(IllegalArgumentException.class, ()-> BankAccount.transfer(source, destination, -1));
        //EC: More than 2 decimal places
        assertThrows(IllegalArgumentException.class, ()-> BankAccount.transfer(source, destination, 0.001));
        //EC: Too-large amount
        assertThrows(InsufficientFundsException.class, ()-> BankAccount.transfer(source, destination, 10));
    }

    @Test
    void isAmountValidTest(){
        //EC: Negative amounts
        assertEquals(false, BankAccount.isAmountValid(-1));
        assertEquals(true, BankAccount.isAmountValid(1));
        //EC: Too many decimals
        assertEquals(false, BankAccount.isAmountValid(0.001));
        assertEquals(true, BankAccount.isAmountValid(0.01));
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
        BankAccount bankAccount = new BankAccount("a@b.com", 1);
        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(1, bankAccount.getBalance());
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 1));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("a@b.com", -1));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 0.001));
    }

}