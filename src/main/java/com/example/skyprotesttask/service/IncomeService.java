package com.example.skyprotesttask.service;

import com.example.skyprotesttask.dto.SocksDto;
import com.example.skyprotesttask.entity.Income;
import com.example.skyprotesttask.entity.Socks;
import com.example.skyprotesttask.entity.Total;
import com.example.skyprotesttask.repository.IncomeRepository;
import com.example.skyprotesttask.repository.SocksRepository;
import com.example.skyprotesttask.repository.TotalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


/**
 * Provides methods for processing incomes
 */
@Service
@RequiredArgsConstructor
public class IncomeService {

    private final IncomeRepository incomeRepository;
    private final TotalRepository totalRepository;
    private final SocksRepository socksRepository;

    /**
     * Create a new income and save it to db.
     * Increases the value of total in the db.
     * If there are no socks with the specified parameters in the db, creates a new socks
     *
     * @param body the body
     * @return {@link Income}
     */
    @Transactional
    public Income addIncome(SocksDto body) {
        if (body == null) {
            throw new IllegalArgumentException();
        }
        Socks socks = socksRepository.findByColorAndCottonPart(body.getColor(), body.getCottonPart());
        Total total;
        if (socks != null) {
            total = socks.getTotal();
            total.setTotalQuantity(total.getTotalQuantity() + body.getQuantity());
        } else {
            socks = new Socks();
            socks.setColor(body.getColor());
            socks.setCottonPart(body.getCottonPart());
            socksRepository.save(socks);
            total = new Total();
            total.setSocks(socks);
            total.setTotalQuantity(body.getQuantity());
        }
        total.setDate(LocalDateTime.now());
        totalRepository.save(total);

        Income income = new Income();
        income.setIncomeQuantity(body.getQuantity());
        income.setDate(LocalDateTime.now());
        income.setSocks(socks);
        incomeRepository.save(income);

        return income;
    }

    /**
     * Find all incomes.
     *
     * @return the list of incomes
     */
    public List<Income> findAll() {
        return incomeRepository.findAllAndSortDateTime();
    }

    /**
     * Find all incomes by date.
     *
     * @param date the date
     * @return the list of incomes
     */
    public List<Income> findAllByDate(LocalDate date) {
        return incomeRepository.findByDate(date);
    }
}
