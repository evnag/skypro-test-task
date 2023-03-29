package com.example.skyprotesttask.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Outcome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "outcome_quantity")
    private Integer outcomeQuantity;
    @Column(name = "date_outcome")
    private Date date;
    @ManyToOne
    @JoinColumn(name="socks_id", nullable=false)
    private Socks socks;
}
