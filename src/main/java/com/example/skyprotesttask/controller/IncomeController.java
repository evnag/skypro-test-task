package com.example.skyprotesttask.controller;

import com.example.skyprotesttask.dto.SocksDto;
import com.example.skyprotesttask.entity.Income;
import com.example.skyprotesttask.service.IncomeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/api/socks/income")
public class IncomeController {

    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @Operation(
            summary = "addIncome",
            description = "Add new income. Returns the same income",
            tags = {"Income"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "OK",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Income.class))),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request"),
            @ApiResponse(responseCode = "404",
                    description = "Not Found"),
            @ApiResponse(responseCode = "500",
                    description = "Internal Server Error")})
    @PostMapping
    public Income addIncome(@RequestBody SocksDto body) {
        return incomeService.addIncome(body);
    }

    @Operation(
            summary = "findAll",
            description = "Return all incomes",
            tags = {"Income"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "OK",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Income.class)))})
    @GetMapping
    public List<Income> findAll() {
        return incomeService.findAll();
    }

    @Operation(
            summary = "findAllByDate",
            description = "Returns a list of incomes for the specified date.",
            tags = {"Income"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "OK",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Income.class))),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request"),
            @ApiResponse(responseCode = "404",
                    description = "Not Found"),
            @ApiResponse(responseCode = "500",
                    description = "Internal Server Error")})
    @GetMapping(value = "/by-date")
    public List<Income> findAllByDate(@Param("date")
                                      @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return incomeService.findAllByDate(date);
    }
}
