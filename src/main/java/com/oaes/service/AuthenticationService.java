package com.oaes.service;

import com.oaes.entity.Coordinator;
import com.oaes.entity.Student;
import com.oaes.entity.User;

public class AuthenticationService {
    private UserService userService;

    public AuthenticationService(){
        userService = new UserService();
    }

    public String authenticate(User user, String password) throws Exception {
        if(user instanceof Student) return authenticateStudent((Student) user, password);
        else return authenticateCoordinator((Coordinator) user, password);
    }

    public String authenticateStudent(Student student, String password){
        if(student.getLocked()==1){
            return "Exception: The student account is currently locked. Please contact your exam coordinator.";
        }
        if(!student.getPassword().equals(password)){
            if(student.getTriesLeft()==1){
                student.setLocked(1);
                student.setTriesLeft(0);
                try {
                    userService.updateUser(student);
                } catch(Exception e){
                    System.out.println(e);
                    return "Error";
                }
                return "Invalid password. Your account has been locked because of too many wrong attempts. Please contact exam coordinator";
            }
            student.setTriesLeft(student.getTriesLeft()-1);
            try {
                userService.updateUser(student);
            } catch(Exception e){
                System.out.println(e);
                return "Error";
            }
            return ("Password is not valid. Please try again. " + student.getTriesLeft() + " attempt(s) left!");
        }
        return "valid";
    }

    public String authenticateCoordinator(Coordinator coordinator, String password){
        if(coordinator.getPassword().equals(password)) return "valid";
        else return "Invalid details";
    }
}
