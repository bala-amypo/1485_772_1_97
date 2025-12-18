package com.example.demo.controller;

import java.util.List;
import com.example.demo.entity.Certificate;
import com.example.demo.service.CertificateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    @PostMapping("/certificates")
    public Certificate generateCertificate(@RequestBody Certificate certificate) {
        return certificateService.generateCertificate(certificate);
    }

    @GetMapping("/certificates")
    public List<Certificate> getCertificates() {
        return certificateService.getAllCertificates();
    }

    @GetMapping("/verify/{verificationCode}")
    public Certificate verifyCertificate(@PathVariable String verificationCode) {
        return certificateService.verifyCertificate(verificationCode);
    }
}