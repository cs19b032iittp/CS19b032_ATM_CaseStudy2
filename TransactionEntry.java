package com.company;

/**
 * Here is class Named TransactionEntry that Saves the data of Transactions of Customers
 */
 public class TransactionEntry {


    private double amount;//  account Balance
    private String reason;// transaction reason
    private double depositWithdrawAmt;// transaction Amount
    private String entrytype; // Withdraw or Deposit
    String date;// date of Transaction


    public void addEntry(String pEntrytype, String pReason, double pdepositWithdrawAmt, double currentAmt, String pDate) {
        entrytype = pEntrytype;
        reason = pReason;
        depositWithdrawAmt = pdepositWithdrawAmt;
        amount = currentAmt;
        date = pDate;
    }

    // Displays the data of Transactions of Customers
    public void displayEntry() {
        System.out.println("---------------------------------------------");
        System.out.println("Entry Type : " + entrytype);
        if (reason != null) {
            System.out.println("Reason :" + reason);
        }
        System.out.printf("Amount: %.3fRs\n", depositWithdrawAmt);
        System.out.printf("Current Balance : %.3fRs \n", amount);

        System.out.println(date);
        System.out.println("---------------------------------------------");


    }

}
