package com.company;


import java.util.Date;
import java.util.Scanner;

/**
 *  Here is our Main class that performs the actions that customer can do
 */
public class Main{
    public static void main(String[] args){

        // Customer Account Details
        Account[]  a = new Account[11];
        a[1] = new Account("Ravi","41301",1111,50000);
        a[2] = new Account("Rahul","41302",1112,500);
        a[3] = new Account("Arun","41303",1113,7000);
        a[4] = new Account("Aditya","41304",1114,6000);
        a[5] = new Account("Yash","41305",1115,2000);
        a[6] = new Account("Yashwanth","41306",1116,40);
        a[7] = new Account("Charan","41307",1117,640);
        a[8] = new Account("Ganesh","41308",1118,33);
        a[9] = new Account("Balu","41309",1119,2159);
        a[10] = new Account("Madhavi","41310",1110,80000);



        int no = 0;
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("===========================================");
            System.out.println("             <<< Welcome >>>               ");
            System.out.println("===========================================");

            System.out.println("\nEnter your Account Number");
            String accountNo = sc.next();
            int k= 1;
            for(k=1; k<11; k++){
                if (a[k].getAccountNumber().equals(accountNo)){
                    no = k;
                    if (a[no].getAccountNumber().equals(accountNo)) {

                        System.out.println("Hello " + a[no].getName());
                        System.out.println("Please enter your pin");
                        int pin = sc.nextInt();

                        while(a[no].getPin() != pin){
                            System.out.println("\nWrong Pin Entered");
                            System.out.println("Please enter your pin Again");
                            pin = sc.nextInt();

                        }
                        int response = 0;
                        System.out.println("\nSelect  any response "+a[no].getName());
                        System.out.println("1. Deposit");
                        System.out.println("2. Withdraw");
                        System.out.println("3.Fast Cash");
                        System.out.println("4. Display Transactions");
                        System.out.println("5.Current Balance");
                        System.out.println("6.Change Pin");
                        System.out.println("7.Cancel Transaction");

                        response = sc.nextInt();
                        double depAmt = 0.0;
                        int withdrawAmt = 0;
                        String reason = " ";
                        switch (response){
                            case 1 :

                                System.out.println(" how much do u want to deposit");
                                depAmt = sc.nextDouble();
                                while (depAmt < 0){
                                    System.out.println("enter amount greater than 0 and multiple of 500                         ");
                                    depAmt = sc.nextDouble();
                                }
                                while(depAmt%500 != 0){
                                    System.out.println("enter amount greater than 500.0");
                                    depAmt = sc.nextDouble();
                                }
                                a[no].deposit(depAmt);
                                System.out.println("\n\n       <<< ThankYou, Visit Again >>      \n\n\n");
                                break;
                            case  2 :

                                System.out.println("how much do u want to withdraw");
                                withdrawAmt = sc.nextInt();
                                while (withdrawAmt < 0 || withdrawAmt%500 != 0){
                                    System.out.println("Enter a valid amount multiple of 500  excluding 0");
                                    withdrawAmt = sc.nextInt();
                                }
                                System.out.println("Enter a reason");
                                reason = sc.next();
                                a[no].Withdraw(withdrawAmt,reason);
                                System.out.println("\n\n       <<< ThankYou, Visit Again >>      \n\n\n");
                                break;
                            case 3:

                                System.out.println("\nSelect  any response "+a[no].getName());
                                System.out.println("1.500 Rs");
                                System.out.println("2.1000 Rs");
                                System.out.println("3.2000 Rs");
                                System.out.println("4.5000 Rs");
                                System.out.println("5.10000 Rs");
                                int Response = sc.nextInt();
                                if(Response == 1){
                                    a[no].Withdraw(500,"Fast Cash");
                                }
                                else if(Response == 2){
                                    a[no].Withdraw(1000," Fast Cash");
                                }
                                else if(Response == 3){
                                    a[no].Withdraw(2000," Fast Cash");
                                }
                                else if(Response == 4){
                                    a[no].Withdraw(5000," Fast Cash");
                                }
                                else if(Response == 5){
                                    a[no].Withdraw(10000," Fast Cash");
                                }
                                else{
                                    System.out.println("Invalid Entry");
                                }

                                break;


                            case 4 :

                                a[no].displayTransactionEntries();
                                System.out.println("\n\n       <<< ThankYou, Visit Again >>      \n\n\n");
                                break;
                            case 5:

                                System.out.println("Current balance : "+a[no].getCurrentAmount());
                                System.out.println("\n\n       <<< ThankYou, Visit Again >>      \n\n\n");
                                break;
                            case 6:

                                int cPin1,cPin2;
                                System.out.println("Enter New Pin");
                                cPin1 = sc.nextInt();
                                System.out.println("Enter New Pin again to confirm");
                                cPin2 = sc.nextInt();
                                if(cPin1 == cPin2){
                                    a[no].ChangePin(cPin2);
                                }
                                else{
                                    System.out.println("Entered Pins are not Same\n Transaction Unsuccessful");
                                }
                                System.out.println("\n\n       <<< ThankYou, Visit Again >>      \n\n\n");
                                break;
                            case 7 :
                                System.out.println("Transaction Cancelled ");
                                System.out.println("\n\n       <<< ThankYou, Visit Again >>      \n\n\n");
                                break;
                            default:

                                System.out.println("Invalid Entry");



                        }

                    }
                    break;
                }
            }
            if(k==11){
                System.out.println("Invalid Account Number Entered");
            }

        }
    }
}
