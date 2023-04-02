package com.example.skyprotesttask.service;

import com.example.skyprotesttask.entity.Total;
import com.example.skyprotesttask.repository.TotalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Provides methods for processing Total
 */
@Service
@RequiredArgsConstructor
public class SocksService {

    private final TotalRepository totalRepository;

    /**
     * Gets socks total by criteria.
     *
     * @param color      the color
     * @param operation  the operation
     * @param cottonPart the cotton part
     * @return list of socks total by criteria
     */
    public List<Total> getSocksTotalByCriteria(String color, String operation, Integer cottonPart) {
        List<Total> total;
        switch (operation) {
            case "moreThan":
                total = totalRepository.getTotalByColorAndCottonPartMoreThan(color, cottonPart);
                break;
            case "lessThan":
                total = totalRepository.getTotalByColorAndCottonPartLessThan(color, cottonPart);
                break;
            case "equal":
                total = totalRepository.getTotalByColorAndCottonPartEqualTo(color, cottonPart);
                break;
            default:
                throw new IllegalArgumentException("Incorrect parameter \"operation\". Try options: \"moreThan\", \"lessThan\",\"equal\"");
        }
        return total;
    }
}
