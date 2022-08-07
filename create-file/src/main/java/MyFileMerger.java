
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyFileMerger
{
    public static void main(String[] args) throws IOException
    {


        // loop to copy each line of
        // file1.txt to file3.txt
//        while (bankLine != null)
//        {
//            BufferedReader ur = new BufferedReader(new FileReader("/Users/aqadeer/Desktop/java-training-project-2/create-file/user.txt"));
//            String userLine = ur.readLine();
//            List<String> bankList = Arrays.asList(bankLine.split(","));
//            while (userLine != null) {
//                List<String> userList = Arrays.asList(userLine.split(","));
//                if (bankList.get(0).equals(userList.get(0))) {
//                    List<String> newList = Stream.concat(bankList.stream(), userList.stream().filter(x -> !Objects.equals(x, userList.get(0))))
//                            .collect(Collectors.toList());
//                    String myStr = newList.toString();
//                    pw.println(myStr);
//                }
//                userLine = ur.readLine();
//            }
//            bankLine = br.readLine();
//
//        }

        // PrintWriter object for file3.txt
        PrintWriter pw = new PrintWriter("merged.txt");

        Map<Integer, List<String>> bankMap = new HashMap<>();
        Map<Integer, List<String>> userMap = new HashMap<>();

        // BufferedReader object for file1.txt
        BufferedReader br = new BufferedReader(new FileReader("/Users/aqadeer/Desktop/java-training-project-2/create-file/bank.txt"));
        BufferedReader ur = new BufferedReader(new FileReader("/Users/aqadeer/Desktop/java-training-project-2/create-file/user.txt"));

        String bankLine = br.readLine();
        String userLine = ur.readLine();

        while (bankLine != null)
        {
            List<String> bankList = Arrays.asList(bankLine.split(","));
            bankMap.put(Integer.valueOf(bankList.get(0)), bankList.subList(1,bankList.size()));
            bankLine = br.readLine();

        }

        while (userLine != null)
        {
            List<String> userList = Arrays.asList(userLine.split(","));
            userMap.put(Integer.valueOf(userList.get(0)), userList.subList(1,userList.size()));
            userLine = ur.readLine();

        }

        Set<Integer> userKey = userMap.keySet();

        for (int id: userKey) {
            List<String> present;
            present = bankMap.get(id);
            if (present != null) {
//                List<String> userList = userMap.get(id);
//                List<String> bankList = bankMap.get(id);
//                pw.println(id + " " + userList.toString().replace("[", "").replace("]", "") + " " +
//                        bankList.toString().replace("[", "").replace("]", ""));

                pw.println(id + ", " + userMap.get(id).get(0) + ", " + userMap.get(id).get(1) + ", " + userMap.get(id).get(2) + ", " + userMap.get(id).get(3) + ", " +
                        bankMap.get(id).get(0) + ", " + bankMap.get(id).get(1) + ", " + bankMap.get(id).get(2));
            }
        }



//
//        line = br.readLine();
//
//        // loop to copy each line of
//        // file2.txt to file3.txt
//        while(line != null)
//        {
//            pw.println(line);
//            line = br.readLine();
//        }

        pw.flush();

        // closing resources
        br.close();
        pw.close();

        System.out.println("Merged file1.txt and file2.txt into file3.txt");
    }
}

