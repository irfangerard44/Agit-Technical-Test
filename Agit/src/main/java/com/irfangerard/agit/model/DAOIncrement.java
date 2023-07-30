package com.irfangerard.agit.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "agit_increment")
@Data
public class DAOIncrement {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(length = 6)
    private int id;
}
