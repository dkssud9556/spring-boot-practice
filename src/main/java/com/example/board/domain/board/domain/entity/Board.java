package com.example.board.domain.board.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "board_id")
    private Long boardId;

    @Column(length = 50)
    private String title;

    @Column(length = 200)
    private String content;

    @Column(length = 20)
    private String username;
}
