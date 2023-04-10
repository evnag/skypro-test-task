package com.example.skyprotesttask.controller;

import com.example.skyprotesttask.entity.Total;
import com.example.skyprotesttask.service.SocksService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/socks")
public class SocksController {

    private final SocksService socksService;

    public SocksController(SocksService socksService) {
        this.socksService = socksService;
    }

    @Operation(
            summary = "getSocksTotal",
            description = "Returns a list of total socks for specified parameters.",
            tags = {"Socks"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "OK",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Total.class))),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request"),
            @ApiResponse(responseCode = "404",
                    description = "Not Found"),
            @ApiResponse(responseCode = "500",
                    description = "Internal Server Error")})
    @GetMapping
    public List<Total> getSocksTotal(@RequestParam String color,
                                     @RequestParam String operation,
                                     @RequestParam Integer cottonPart) {
        return socksService.getSocksTotalByCriteria(color, operation, cottonPart);
    }
}
