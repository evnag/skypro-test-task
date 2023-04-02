package com.example.skyprotesttask.repository;

import com.example.skyprotesttask.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * The interface Income repository.
 */
@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {

    @Query(value = "select * from income order by date_income DESC"
            , nativeQuery = true)
    List<Income> findAllAndSortDateTime();

    @Query(value = "select * from income where date(date_income) =:date"
            , nativeQuery = true)
    List<Income> findByDate(LocalDate date);
}
