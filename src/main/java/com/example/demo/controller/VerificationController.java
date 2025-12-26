package com.example.demo.controller;

import com.example.demo.entity.Certificate;
import com.example.demo.service.VerificationService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/verify")
public class VerificationController {

    private final VerificationService verificationService;

    public VerificationController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    @GetMapping("/{code}")
    public Certificate verifyByGet(
            @PathVariable String code,
            @RequestHeader(value = "X-FORWARDED-FOR", required = false) String ip) {

        if (ip == null) {
            ip = "127.0.0.1";
        }
        return verificationService.verify(code, ip);
    }

    @PostMapping
    public Certificate verifyByPost(
            @RequestParam String code,
            @RequestHeader(value = "X-FORWARDED-FOR", required = false) String ip) {

        if (ip == null) {
            ip = "127.0.0.1";
        }
        return verificationService.verify(code, ip);
    }
}
