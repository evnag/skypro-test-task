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
public class Total {
    @Id
    @Column(name = "socks_id")
    private Long id;
    @Column(name = "total_quantity")
    private Integer totalQuantity;
    @Column(name = "date_total")
    private LocalDateTime date;
    @OneToOne
    @MapsId
    @JsonIgnore
    @JoinColumn(name = "socks_id")
    private Socks socks;
}
