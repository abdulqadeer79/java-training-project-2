import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class MyBankFileUpdater {
    public static void main(String[] args) {
        try {
            Bank bank = new Bank();
            Scanner userInput = new Scanner(System.in);

            System.out.println("Enter bank id: ");
            int i = Integer.parseInt(userInput.nextLine());
            bank.setId(i);

            System.out.println("Enter bank name: ");
            String n = userInput.nextLine();
            bank.setBankName(n);

            System.out.println("Enter bank account number: ");
            int a = Integer.parseInt(userInput.nextLine());
            bank.setAccountNumber(a);

            System.out.println("Enter bank credit card status: ");
            boolean c = Boolean.parseBoolean(userInput.nextLine());
            bank.setCreditCardStatus(c);

            String stringBank = bank.toString();
            Files.write(Paths.get("bank.txt"), stringBank.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }
}
