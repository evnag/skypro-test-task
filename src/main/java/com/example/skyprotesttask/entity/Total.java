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
public class Total {
    @Id
    @Column(name = "socks_id")
    private Long id;
    @Column(name = "total_quantity")
    private Integer totalQuantity;
    @Column(name = "date_total")
    private Date date;
    @OneToOne
    @MapsId
    @JoinColumn(name = "socks_id")
    private Socks socks;
}
