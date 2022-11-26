package com.oaes.service;

import com.oaes.AuthenticationManager;
import com.oaes.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class TestService {
    private boolean testStarted;
    private List<Student> subscribers;
    private static TestService instance;

    private TestService(){
        this.testStarted = false;
        this.subscribers = new ArrayList<>();
    }

    public static TestService getInstance(){
        if (instance == null){
            synchronized(TestService.class){
                if (instance == null) instance = new TestService();
            }
        }
        return instance;
    }

    public void subscribe(Student student){
        this.subscribers.add(student);
    }

    public void unsubscribe(Student student){
        for(Student s: subscribers){
            if(s.getUuid()==student.getUuid()){
                subscribers.remove(s);
                break;
            }
        }
    }

    public void notifySubscribers(){
        for(Student s: subscribers) s.setTestStatus();
    }

    public void startTest(){
        this.testStarted = true;
        notifySubscribers();
    }

    public boolean isTestStarted() {
        return testStarted;
    }
}
