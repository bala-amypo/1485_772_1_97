package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.VerificationLog;
import com.example.demo.service.VerificationService;

@RestController
@RequestMapping("/verify")
public class VerificationController {

    private final VerificationService verificationService;

    public VerificationController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    @PostMapping("/{code}")
    public VerificationLog verify(@PathVariable String code,
                                  @RequestHeader("X-FORWARDED-FOR") String ip) {
        return verificationService.verify(code, ip);
    }

    @GetMapping("/logs/{certificateId}")
    public List<VerificationLog> logs(@PathVariable Long certificateId) {
        return verificationService.getLogs(certificateId);
    }
}
