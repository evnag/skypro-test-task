package com.example.skyprotesttask.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Socks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "color")
    private String color;
    @Column(name = "cotton_part")
    private Integer cottonPart;

    @OneToOne(mappedBy = "socks", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Total total;
    @OneToMany(mappedBy = "socks")
    private Set<Income> incomes;
    @OneToMany(mappedBy = "socks")
    private Set<Outcome> outcomes;
}
