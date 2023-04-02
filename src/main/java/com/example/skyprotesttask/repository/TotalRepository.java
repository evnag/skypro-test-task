package com.example.skyprotesttask.repository;

import com.example.skyprotesttask.entity.Total;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Total repository.
 */
@Repository
public interface TotalRepository extends JpaRepository<Total, Long> {

    @Query(value = "select * from total as t " +
            "left join socks as s " +
            "on t.socks_id = s.id " +
            "where s.cotton_part > :cottonPart " +
            "and s.color = :color "
            , nativeQuery = true)
    List<Total> getTotalByColorAndCottonPartMoreThan(@Param("color") String color, @Param("cottonPart") Integer cottonPart);

    @Query(value = "select * from total as t " +
            "left join socks as s " +
            "on t.socks_id = s.id " +
            "where s.cotton_part < :cottonPart " +
            "and s.color = :color "
            , nativeQuery = true)
    List<Total> getTotalByColorAndCottonPartLessThan(@Param("color") String color, @Param("cottonPart") Integer cottonPart);

    @Query(value = "select * from total as t " +
            "left join socks as s " +
            "on t.socks_id = s.id " +
            "where s.cotton_part = :cottonPart " +
            "and s.color = :color "
            , nativeQuery = true)
    List<Total> getTotalByColorAndCottonPartEqualTo(@Param("color") String color, @Param("cottonPart") Integer cottonPart);

}
