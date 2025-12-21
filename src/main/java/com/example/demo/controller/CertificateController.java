package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Certificate;
import com.example.demo.service.CertificateService;

@RestController
@RequestMapping("/certificates")
public class CertificateController {

    private final CertificateService certificateService;

    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    @PostMapping("/generate/{studentId}/{templateId}")
    public Certificate generate(@PathVariable Long studentId,
                                @PathVariable Long templateId) {
        return certificateService.generateCertificate(studentId, templateId);
    }

    @GetMapping("/{id}")
    public Certificate get(@PathVariable Long id) {
        return certificateService.getCertificate(id);
    }

    @GetMapping("/verify/code/{code}")
    public Certificate verify(@PathVariable String code) {
        return certificateService.getByVerificationCode(code);
    }
}
