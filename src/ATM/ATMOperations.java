package ATM;

import java.util.Scanner;


public class ATMOperations implements ATMOperationsInterface{
    ATMInformation atm = new ATMInformation();
    static ATMOperationsInterface op = new ATMOperations();
    private double balance;
    private double depositAmount;
    private double withdrawAmount;
    private double transferAmount;
    private int countOfDeposit;
    private int countOfWithdraw;

    public int getCountOfDeposit() {
        return countOfDeposit;
    }

    public void setCountOfDeposit(int countOfDeposit) {
        this.countOfDeposit = countOfDeposit;
    }

    public int getCountOfWithdraw() {
        return countOfWithdraw;
    }

    public void setCountOfWithdraw(int countOfWithdraw) {
        this.countOfWithdraw = countOfWithdraw;
    }

    public int getCountOfTransfer() {
        return countOfTransfer;
    }

    public void setCountOfTransfer(int countOfTransfer) {
        this.countOfTransfer = countOfTransfer;
    }

    private int countOfTransfer;

    public double getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(double transferAmount) {
        this.transferAmount = transferAmount;
    }

    static void displayMenu() {
        System.out.println("1. Show balance\n" +
                "2. Make operation\n" +
                "3. Show history\n" +
                "4. Exit");
    }
    static void checkDataOfCard(int atmNumber, int atmPIN){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Write a atm number of your card: ");

        int writtenNumber = scanner.nextInt();
        System.out.print("Write a PIN of your card: ");
        int writtenPIN = scanner.nextInt();

        if (writtenNumber == atmNumber && writtenPIN == atmPIN){
            System.out.println("Authentication successful!");
        }
        else {
            System.out.println("Error!! The incorrect data of your card");
            System.exit(0);
        }
    }
    static void makeChoose(){
        while (true){
            ATMOperations.displayMenu();
            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    op.viewBalance();
                    break;
                case 2:
                    op.operate();
                    break;
                case 3:
                    op.showRecentTransactions();
                case 4:
                    op.exit();
            }
        }
    }

    @Override
    public void viewBalance() {
        System.out.println("Your balance is "+atm.getBalance());
    }

    @Override
    public void showRecentTransactions() {
        System.out.println("Select operation: ");
        System.out.println("1. Show deposit history\n" +
                "2. Show withdraw history\n" +
                "3. Show transfer history\n");
        Scanner scanner = new Scanner(System.in);
        int chooseOfOperationOfHistory = scanner.nextInt();
        switch (chooseOfOperationOfHistory){
            case 1:
                System.out.println("Count of deposits equals "+ getCountOfDeposit());

                break;
        }

    }

    @Override
    public void operate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select operation: ");
        System.out.println("1. Deposit money\n" +
                "2. Withdraw money\n" +
                "3. Transfer money\n" +
                "4. Back to menu\n");
        int chooseOfOperationWithMoney = scanner.nextInt();
        switch (chooseOfOperationWithMoney){
            case 1: // deposit operation
                System.out.println("Write the amount to deposit: ");
                depositAmount = scanner.nextDouble();
                System.out.println(depositAmount + " Deposited successfully !!");
                atm.setBalance(atm.getBalance()+ depositAmount);
                countOfDeposit++;


                break;
            case 2: // withdraw operation
                System.out.println("Write the amount to withdraw: ");
                withdrawAmount = scanner.nextDouble();
                System.out.println(withdrawAmount + " Withdraw successfully !!");
                atm.setBalance(atm.getBalance() - withdrawAmount);
                break;
            case 3: //transfer operation
                System.out.println("Write the amount to transfer: ");
                transferAmount = scanner.nextDouble();
                System.out.println("Write the phone number to who you want to transfer money");
                String numberPhone = scanner.next();
                System.out.println(transferAmount + " Transfer successful on "+ numberPhone);
                atm.setBalance(atm.getBalance() - transferAmount);
            case 4:
                // ничего не прописывается поскольку у нас цикл while
        }
    }

    @Override
    public void exit() {
        System.out.println("Thank you for being with us :)");
        System.exit(0);
    }
}
