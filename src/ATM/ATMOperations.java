package ATM;

import java.util.Scanner;


public class ATMOperations implements ATMOperationsInterface{
    ATMInformation atm = new ATMInformation();
    static ATMOperationsInterface op = new ATMOperations();
    private int countOfDeposit;
    private int countOfWithdraw;

    public double getTotalAmountDeposit() {
        return totalAmountDeposit;
    }

    public void setTotalAmountDeposit(double totalAmountDeposit) {
        this.totalAmountDeposit = totalAmountDeposit;
    }

    private double totalAmountDeposit;

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
                System.out.println("The sum of all replenishments equals "+ getTotalAmountDeposit());
                break;
            case 2:
                // ДОРАБОТАТЬ ИСТОРИЮ ВЫВОДА СРЕДСТВ
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
                atm.setDepositAmount(scanner.nextDouble());
                System.out.println(atm.getDepositAmount() + " Deposited successfully !!");
                atm.setBalance(atm.getBalance()+ atm.getDepositAmount());
                countOfDeposit++;
                totalAmountDeposit += atm.getDepositAmount();
                break;
            case 2: // withdraw operation
                System.out.println("Write the amount to withdraw: ");
                atm.setWithdrawAmount(scanner.nextDouble());
                System.out.println(atm.getWithdrawAmount() + " Withdraw successfully !!");
                atm.setBalance(atm.getBalance() - atm.getWithdrawAmount());
                break;
            case 3: //transfer operation
                System.out.println("Write the amount to transfer: ");
                atm.setTransferAmount(scanner.nextDouble());
                System.out.println("Write the phone number to who you want to transfer money");
                String numberPhone = scanner.next();
                System.out.println(atm.getTransferAmount() + " Transfer successful on "+ numberPhone);
                atm.setBalance(atm.getBalance() - atm.getTransferAmount());
            case 4:
                // ничего не прописывается поскольку у нас цикл while
                break;
        }
    }

    @Override
    public void exit() {
        System.out.println("Thank you for being with us :)");
        System.exit(0);
    }
}
