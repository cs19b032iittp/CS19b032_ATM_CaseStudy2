package com.company;

import java.util.Date;

/**
 * here there is class named Account which has the data of the Customer (name , account number ,pin balance ,transaction history
 * and it has methods to perform required activities like
 * Withdraw, Deposit , Change Pin ...
 */
public class Account {
    // Amount in the ATM
    static int balance = 100000;
    private String name;// name of Customer
    private String accountNumber;// account number of customer
    private int pin;// customer pin
    private double currentAmmount;// customer current balance
    private TransactionEntry[] accountTransaction;// customer transaction history
    Date date = new Date(); // object of Date Class


    private int transactionEntryCount;// transactions count
    private final int Max = 100;// maximum Transactions that can be stored

    //Account Constructor
    public Account(String pName, String pAccNum, int pPin, double pAmount) {
        name = pName;
        accountNumber = pAccNum;
        pin = pPin;
        currentAmmount = pAmount;
        transactionEntryCount = 0;
        initTransaction();
    }

    // First transaction of the Customer while creating Account
    private void initTransaction() {
        accountTransaction = new TransactionEntry[Max];
        accountTransaction[transactionEntryCount] = new TransactionEntry();
        accountTransaction[transactionEntryCount].addEntry("Deposit", "initial Deposit", currentAmmount, currentAmmount, "Sun Nov 01 13:22:46 IST 2020");
        transactionEntryCount += 1;
    }

    // Method to deposit Money
    public void deposit(double depAmt) {
        currentAmmount += depAmt;
        balance += depAmt;
        accountTransaction[transactionEntryCount] = new TransactionEntry();
        accountTransaction[transactionEntryCount].addEntry("Deposit", null, depAmt, currentAmmount, date.toString());
        transactionEntryCount += 1;
        System.out.println("Transaction Successful\nAmount credited :" + depAmt + " (in Rupees)\nTime : " + date.toString());
    }

    // Method to withdraw Money
    public void Withdraw(double drawAmt, String reason) {
        if (balance >= drawAmt) {

            if (drawAmt <= currentAmmount) {
                currentAmmount -= drawAmt;
                balance -= drawAmt;
                accountTransaction[transactionEntryCount] = new TransactionEntry();
                accountTransaction[transactionEntryCount].addEntry("Withdraw ", reason, drawAmt, currentAmmount, date.toString());
                transactionEntryCount += 1;
                System.out.println("Transaction Successful\nAmount withdrawn :" + drawAmt + " (in Rupees)\nTime : " + date.toString());
            } else {
                accountTransaction[transactionEntryCount] = new TransactionEntry();
                accountTransaction[transactionEntryCount].addEntry("Withdraw Unsuccessful ", "Insufficient Funds in your Account", drawAmt, currentAmmount, date.toString());
                transactionEntryCount += 1;
                System.out.println("Transaction Failed");
                System.out.println("Insufficient Funds in your Account");
            }

        } else {
            accountTransaction[transactionEntryCount] = new TransactionEntry();
            accountTransaction[transactionEntryCount].addEntry("Withdraw UnSuccessFul", " Insufficient Funds in your Account", drawAmt, currentAmmount, date.toString());
            transactionEntryCount += 1;
            System.out.println("Transaction Failed");
            System.out.println("Insufficient Funds in the ATM");
        }

    }

    // Method to Change Pin
    public void ChangePin(int cPin) {
        pin = cPin;

    }

    // Method to Display Transactions
    public void displayTransactionEntries() {
        System.out.println("Account Name: " + getName());
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("***********************************************");
        for (int i = 0; i < transactionEntryCount; i++) {
            accountTransaction[i].displayEntry();
        }
        System.out.println("***********************************************");

    }

    // Method to get Name;
    public String getName() {

        return name;
    }

    // Method to return Name;
    public String getAccountNumber() {
        return accountNumber;
    }

    // Method to return Account No;
    public int getPin() {
        return pin;
    }

    // Method to return Current Balance;
    public double getCurrentAmount() {
        return currentAmmount;
    }


}
