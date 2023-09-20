package ATM;


public class Main {
    public static void main(String[] args) {
        int atmNumber = 123;
        int atmPIN = 12345;
        ATMOperations.checkDataOfCard(atmNumber, atmPIN);
        ATMOperations.makeChoose();

    }
}
