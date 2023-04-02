package com.example.skyprotesttask.service;

import com.example.skyprotesttask.dto.SocksDto;
import com.example.skyprotesttask.entity.Outcome;
import com.example.skyprotesttask.entity.Socks;
import com.example.skyprotesttask.entity.Total;
import com.example.skyprotesttask.exception.SocksNotFoundException;
import com.example.skyprotesttask.repository.OutcomeRepository;
import com.example.skyprotesttask.repository.SocksRepository;
import com.example.skyprotesttask.repository.TotalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Provides methods for processing outcomes
 */
@Service
@RequiredArgsConstructor
public class OutcomeService {

    private final OutcomeRepository outcomeRepository;
    private final TotalRepository totalRepository;
    private final SocksRepository socksRepository;

    /**
     * Create a new outcome and save it to db.
     * Decreases the value of total in the db.
     *
     * @param body the body
     * @return {@link Outcome}
     * @throws SocksNotFoundException if no matches found for socks with specified parameters
     */
    @Transactional
    public Outcome addOutcome(SocksDto body) {
        if (body == null) {
            throw new IllegalArgumentException();
        }
        Socks socks = socksRepository.findByColorAndCottonPart(body.getColor(), body.getCottonPart());
        if (socks == null) {
            throw new SocksNotFoundException("No matches found for socks with parameters: " + body.getColor() + ", " + body.getCottonPart());
        }
        Total total = socks.getTotal();
        total.setTotalQuantity(total.getTotalQuantity() - body.getQuantity());
        total.setDate(LocalDateTime.now());

        totalRepository.save(total);

        Outcome outcome = new Outcome();
        outcome.setOutcomeQuantity(body.getQuantity());
        outcome.setDate(LocalDateTime.now());
        outcome.setSocks(socks);
        outcomeRepository.save(outcome);

        return outcome;
    }

    /**
     * Find all outcomes.
     *
     * @return the list of outcomes
     */
    public List<Outcome> findAll() {
        return outcomeRepository.findAllAndSortDateTime();
    }

    /**
     * Find all outcomes by date.
     *
     * @param date the date
     * @return the list of outcomes
     */
    public List<Outcome> findAllByDate(LocalDate date) {
        return outcomeRepository.findByDate(date);
    }
}
