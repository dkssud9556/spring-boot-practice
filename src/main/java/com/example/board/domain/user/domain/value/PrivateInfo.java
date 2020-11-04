package com.example.board.domain.user.domain.value;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PrivateInfo {

    @Column(length = 10)
    private String name;

    @Column
    private int age;
}
