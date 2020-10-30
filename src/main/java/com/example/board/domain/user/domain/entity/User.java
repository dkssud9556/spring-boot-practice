package com.example.board.domain.user.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @Column(length = 20)
    private String username;

    @Column(length = 30)
    private String password;

    @Column(length = 10)
    private String name;

    @Column
    private int age;

    public boolean isCorrectPassword(String inputPassword) {
        return password.equals(inputPassword);
    }
}
