package com.oaes.entity;

import javax.persistence.Entity;

@Entity
public class Coordinator extends User{
    public Coordinator() {
    }

    public Coordinator(long uuid, long userID, String password, String email) {
        super(uuid, userID, password, email);
    }
}
