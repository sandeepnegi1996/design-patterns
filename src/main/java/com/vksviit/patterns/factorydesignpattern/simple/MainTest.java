package com.vksviit.patterns.factorydesignpattern.simple;

public class MainTest {
    public static void main(String[] args) {
        BankAccountFactory b =new BankAccountFactory();
       BankAccount bankAccount=  b.createAccount("B");
        bankAccount.registerAccount();

         bankAccount=  b.createAccount("C");
        bankAccount.registerAccount();

         bankAccount=  b.createAccount("S");
        bankAccount.registerAccount();
    }
}
