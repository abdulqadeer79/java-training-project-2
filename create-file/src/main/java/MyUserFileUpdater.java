import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class MyUserFileUpdater {
    public static void main(String[] args) {
        try {
            User user = new User();
            Scanner userInput = new Scanner(System.in);

            System.out.println("Enter user id");
            int i = Integer.parseInt(userInput.nextLine());
            user.setId(i);

            System.out.println("Enter user name");
            String n = userInput.nextLine();
            user.setName(n);

            System.out.println("Enter user age");
            int a = Integer.parseInt(userInput.nextLine());
            user.setAge(a);

            System.out.println("Enter user profession");
            String p = userInput.nextLine();
            user.setProfession(p);

            System.out.println("Enter user martial status");
            boolean m = Boolean.parseBoolean(userInput.nextLine());
            user.setMartialStatus(m);


            String stringUser = user.toString();
            Files.write(Paths.get("user.txt"), stringUser.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }
}
