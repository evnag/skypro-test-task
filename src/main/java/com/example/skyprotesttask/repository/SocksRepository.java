package com.example.skyprotesttask.repository;

import com.example.skyprotesttask.entity.Socks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Socks repository.
 */
@Repository
public interface SocksRepository extends JpaRepository<Socks, Long> {

    Socks findByColorAndCottonPart(String color, Integer cottonPart);
}
