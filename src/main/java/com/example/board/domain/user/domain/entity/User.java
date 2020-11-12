package com.example.board.domain.user.domain.entity;

import com.example.board.domain.user.domain.value.PrivateInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "user")
public class User {

    protected User() {}

    @Id
    @Column(length = 20)
    private String username;

    @Column(length = 30)
    private String password;

    @Embedded
    private PrivateInfo privateInfo;

    @ElementCollection
    @CollectionTable(name = "board", joinColumns = @JoinColumn(name = "username"))
    @Column(name = "board_id")
    private List<Long> boardIds;

    public boolean isCorrectPassword(String inputPassword) {
        return password.equals(inputPassword);
    }
}
