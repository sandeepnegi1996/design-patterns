package com.vksviit.patterns.factorydesignpattern.simple;

public class BankAccountFactory {

    BankAccount bankAccount;
    public BankAccount createAccount(String type) {

        if (type.equals("C")) {
            bankAccount  = new CurrentAccount();
        }else if (type.equals("S")) {
            bankAccount = new SavingsAccount();
        } else {
            bankAccount = new BusinessAccount();
        }

        return bankAccount;
    }
}
