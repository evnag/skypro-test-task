package com.example.skyprotesttask.repository;

import com.example.skyprotesttask.entity.Outcome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * The interface Outcome repository.
 */
@Repository
public interface OutcomeRepository extends JpaRepository<Outcome, Long> {

    @Query(value = "select * from outcome order by date_outcome DESC"
            , nativeQuery = true)
    List<Outcome> findAllAndSortDateTime();

    @Query(value = "select * from outcome where date(date_outcome) =:date"
            , nativeQuery = true)
    List<Outcome> findByDate(LocalDate date);
}
