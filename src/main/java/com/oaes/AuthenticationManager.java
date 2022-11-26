package com.oaes;

import com.oaes.entity.Student;
import com.oaes.entity.User;
import com.oaes.service.AuthenticationService;
import com.oaes.service.UserService;
import com.oaes.service.TestService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AuthenticationManager {
    private AuthenticationService authenticationService;
    private UserService userService;
    private static AuthenticationManager instance;
    private TestService testService;

    private AuthenticationManager(){
        authenticationService = new AuthenticationService();
        userService = new UserService();
        testService = TestService.getInstance();
    }

    public static AuthenticationManager getInstance(){
        if (instance == null){
            synchronized(AuthenticationManager.class){
                if (instance == null) instance = new AuthenticationManager();
            }
        }
        return instance;
    }

    public Object authenticateByEmail(String email, String password) throws Exception {
        User user = userService.getUserByEmail(email);
//        return user;
        if(user==null) return "Invalid details";
        String res = authenticationService.authenticate(user, password);
        if(!res.equals("valid")) return res;
        else return user;
    }

    public Object authenticateByUserID(long userID, String password) throws Exception {
        User user = userService.getUserById(userID);
        if(user==null) return "Invalid details";
        String res = authenticationService.authenticate(user, password);
        if(!res.equals("valid")) return res;
        else return user;
    }

    public void startTest(){
        testService.startTest();
    }

//    public void authenticate() throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Enter login details... \nChoose login method: 1) StudentID 2) Email");
//        int response = Integer.parseInt(br.readLine());
//        Student student = null;
//        String password = "";
//        if(response==1){
//            System.out.print("Enter student id: ");
//            long studentId = Integer.parseInt(br.readLine());
//            System.out.print("Enter password: ");
//            password = br.readLine();
//            if(password.length()==0){
//                System.out.println("Exception: Please enter all the details");
//                return;
//            }
//            else{
//                try {
//                    student = userService.getStudentById(studentId);
//                }
//                catch (Exception e) {
//                    System.out.println(e);
//                    return;
//                }
//            }
//        }
//        else if(response==2){
//            System.out.print("Enter Email: ");
//            String email = br.readLine();
//            System.out.print("Enter password: ");
//            password = br.readLine();
//            if(email.length()==0 || password.length()==0){
//                System.out.println("Exception: Please enter all the details");
//                return;
//            }
//            else {
//                try {
//                    student = userService.getStudentByEmail(email);
//                }
//                catch (Exception e) {
//                    System.out.println(e);
//                    return;
//                }
//            }
//        }
//        else System.out.println("Invalid response!");
//        if(student==null){
//            System.out.println("Invalid ID!");
//            return;
//        }
//        boolean valid = authenticationService.authenticate(student, password);
//        if(!valid) return;
//        System.out.println("Successfully authenticated....\nRedirecting to Examination interface....");
//        System.out.print("Do you accept the terms and conditions? (y/n): ");
//        String op = br.readLine();
//        if(op.equals("n")){
//            System.out.println("You cannot continue without accepting the terms and conditions of the exam.");
//            return;
//        }
//        System.out.print("Please provide webcam and microphone access.. (y/n): ");
//        op = br.readLine();
//        if(op.equals("n")){
//            System.out.println("Webcam and microphone access is mandatory to continue with the exam.");
//            return;
//        }
//        int permissions = 1;
//        if(permissions==0){
//            System.out.println("Failed to access webcam and microphone! Please try refreshing the page or changing your browser.");
//            return;
//        }
//        testService.subscribe(student);
//        System.out.println("Please wait while the exam coordinator starts your test.");
//        while(!testService.isTestStarted());
//        System.out.println("Exam started! Redirecting to Questions....");
//        student.setTestStatus(0);
//        userService.updateStudent(student);
//    }
}

