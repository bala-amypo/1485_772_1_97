package com.example.demo.controller;

import com.example.demo.entity.Certificate;
import com.example.demo.service.CertificateService;

public class CertificateController {

    private final CertificateService certificateService;

    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    public Certificate generate(Long studentId, Long templateId) {
        return certificateService.generateCertificate(studentId, templateId);
    }

    public Certificate get(Long id) {
        return certificateService.getCertificate(id);
    }
}
