package com.colak.springrestclienttutorial.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/quote")
public class QuoteController {

    // http://localhost:8080/api/v1/quote/get
    @GetMapping("/getquote")
    public String getQuote() {
        return "quote";
    }

    // http://localhost:8080/api/v1/quote/newgetquote
    @GetMapping("/newgetquote")
    public String getNewQuote() {
        return "new quote";
    }

    // http://localhost:8080/api/v1/quote/redirect
    @GetMapping(value = "/redirect")
    public ResponseEntity<Void> redirect() {
        return ResponseEntity
                .status(HttpStatus.TEMPORARY_REDIRECT)
                .header("Location", "/api/v1/quote/newgetquote")
                .body(null);

    }
}
