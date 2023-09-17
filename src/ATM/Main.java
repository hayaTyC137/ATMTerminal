package ATM;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int atmNumber = 123;
        int atmPIN = 12345;
        ATMOperationsInterface op = new ATMOperations();
        ATMOperations.checkDataOfCard(atmNumber, atmPIN);
        ATMOperations.makeChoose();

    }
}
