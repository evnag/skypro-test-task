package com.example.skyprotesttask.controller;

import com.example.skyprotesttask.dto.SocksDto;
import com.example.skyprotesttask.entity.Outcome;
import com.example.skyprotesttask.service.OutcomeService;
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
@RequestMapping(value = "/api/socks/outcome")
public class OutcomeController {

    private final OutcomeService outcomeService;

    public OutcomeController(OutcomeService outcomeService) {
        this.outcomeService = outcomeService;
    }

    @Operation(
            summary = "addOutcome",
            description = "Add new outcome. Returns the same outcome",
            tags = {"Outcome"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "OK",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Outcome.class))),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request"),
            @ApiResponse(responseCode = "404",
                    description = "Not Found"),
            @ApiResponse(responseCode = "500",
                    description = "Internal Server Error")})
    @PostMapping
    public Outcome addOutcome(@RequestBody SocksDto body) {
        return outcomeService.addOutcome(body);
    }

    @Operation(
            summary = "findAll",
            description = "Return all outcomes",
            tags = {"Outcome"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "OK",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Outcome.class)))})
    @GetMapping
    public List<Outcome> findAll() {
        return outcomeService.findAll();
    }

    @Operation(
            summary = "findAllByDate",
            description = "Returns a list of outcomes for the specified date.",
            tags = {"Outcome"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "OK",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Outcome.class))),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request"),
            @ApiResponse(responseCode = "404",
                    description = "Not Found"),
            @ApiResponse(responseCode = "500",
                    description = "Internal Server Error")})
    @GetMapping(value = "/by-date")
    public List<Outcome> findAllByDate(@Param("date")
                                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return outcomeService.findAllByDate(date);
    }
}
