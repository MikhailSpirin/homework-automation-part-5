package com.wix;

/**
 * Created by mikhails on 31.10.2016
 */
public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
        System.out.println(String.format("New account is created! Your summary balance is: %s", this.balance));
    }

    public void withdraw(double moneyToWithDraw) {
        System.out.println(String.format("Try to withdraw: %s", moneyToWithDraw));
        if (this.balance <= moneyToWithDraw) {
            throw new NegativeBalanceException();
        } else {
            this.balance -= moneyToWithDraw;
            System.out.println(String.format("Left: %s, withdrawed: %s", this.balance, moneyToWithDraw));
        }
    }
}
