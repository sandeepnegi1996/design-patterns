package com.vksviit.patterns.factorydesignpattern.simple;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SavingsAccount implements BankAccount {
    @Override
    public void registerAccount() {
      log.info("Savings Account..");
    }
}
