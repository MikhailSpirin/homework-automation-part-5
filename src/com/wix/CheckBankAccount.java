package com.wix;

/**
 * Created by mikhails on 31.10.2016
 */
public class CheckBankAccount {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100.0);
        account.withdraw(50);
        account.withdraw(75);
    }
}
