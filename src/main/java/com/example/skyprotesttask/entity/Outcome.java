package com.example.skyprotesttask.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
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
    private LocalDateTime date;
    @OneToOne
    @JsonIgnore
    @JoinColumn(name="socks_id")
    private Socks socks;
}
