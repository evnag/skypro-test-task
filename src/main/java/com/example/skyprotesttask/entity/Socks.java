package com.example.skyprotesttask.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
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
}
