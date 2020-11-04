package com.example.board.domain.user.domain.value;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Builder
@AllArgsConstructor
@Embeddable
public class PrivateInfo {

    protected PrivateInfo() {}

    @Column(length = 10)
    private String name;
    private int age;
}
