package com.qadeer.user.service;

import com.qadeer.user.model.User;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Service;

import java.io.*;


import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import java.io.IOException;


@Service
public class UserService {


    public UserService() throws FileNotFoundException {
    }

    public User getUserById(int id) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/Users/aqadeer/Desktop/java-training-project-2/create-file/merged.txt"));
        String myLine = br.readLine();
        while (myLine != null) {

            if (Integer.parseInt(String.valueOf(myLine.charAt(0))) == id) {
                User user = new User();
                List<String> userList = Arrays.asList(myLine.split(","));
                user.setId(id);
                user.setName(userList.get(1).trim());
                user.setAge(Integer.parseInt(userList.get(2).trim()));
                user.setProfession(userList.get(3).trim());
                user.setMartialStatus(Boolean.parseBoolean(userList.get(4)));
                return user;
            }
            myLine = br.readLine();
        }
        return null;

    }

    public String updateUserById(int id, String status) throws IOException {
        boolean flag = false;
        StringBuilder result = new StringBuilder();

        //java 8
        String contents = FileUtils.readFileToString(new File("/Users/aqadeer/Desktop/java-training-project-2/create-file/merged.txt"), "UTF-8");
        String[] contentArray = contents.split("\n");

        for (String x : contentArray) {

            List<String> myStringList = Arrays.asList(x.split(","));
            int myId = Integer.parseInt(myStringList.get(0));
            String profession = myStringList.get(3).trim();


            if (myId == id && (profession.equals("business") || profession.equals("banker"))) {
                String someStr = String.valueOf(x).replaceAll(" [^,]*$", " " + status);
                result.append(someStr);
                result.append("\n");
                contentArray = ArrayUtils.remove(contentArray, 0);
                flag = true;
                break;
            }
            else {
                result.append(x);
                result.append("\n");
                contentArray = ArrayUtils.remove(contentArray, 0);

            }
        }
        String finalString = String.join("\n", contentArray);
        result.append(finalString);
        result.append("\n");


        if (flag) {
            PrintWriter pw = new PrintWriter("/Users/aqadeer/Desktop/java-training-project-2/create-file/merged.txt");
            pw.println(String.valueOf(result));
            pw.flush();
            pw.close();
            return "user updated.";
        }
        return "not allowed";
    }

//        while (myLine != null) {
//
//            List<String> myStringList = Arrays.asList(myLine.split(","));
//            int myId = Integer.parseInt(myStringList.get(0));
//            String profession = myStringList.get(3).trim();
//            int x = Integer.parseInt(String.valueOf(myLine.charAt(0)));
//            if (x == id && (profession.equals("business") || profession.equals("banker"))) {
//                String someStr = String.valueOf(myString).replaceAll(" [^,]*$", " " + status);
//                result.append(someStr);
//                result.append("\n");
//                flag = true;
//            }
//            else {
//                result.append(myString);
//
//            }
//
//            myLine = br.readLine();
//            if (myLine == null) {
//                break;
//            }
//            myString = new StringBuilder();
//            myString.append(myLine);
//            myString.append("\n");
//
//
//        }
//        if (flag) {
//            PrintWriter pw = new PrintWriter("/Users/aqadeer/Desktop/java-training-project-2/create-file/merged.txt");
//            int last = result.lastIndexOf("\n");
//            if (last >= 0) { result.delete(last, result.length()); }
//            pw.println(String.valueOf(result));
//            pw.flush();
//            pw.close();
//            return "user updated.";
//        }
//        return "not allowed";
//    }
}
