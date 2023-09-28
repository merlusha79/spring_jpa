package com.spring.learning.jdbc;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="Player")
@Getter
@Setter
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @Column(name="nationality")
    private String nationality;
    private Date birthDate;
    private int titles;

    public Player(String name, String nationality, Date birthDate, int titles) {
        super();
        this.name = name;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.titles = titles;
    }
}
