package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.example.demo.entity.Certificate;
import com.example.demo.repository.CertificateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificateServiceImpl implements CertificateService {

    @Autowired
    private CertificateRepository certificateRepo;

    @Override
    public Certificate generateCertificate(Certificate c) {

        String verificationCode = UUID.randomUUID().toString();

        c.setVerificationCode(verificationCode);
        c.setIssuedDate(LocalDate.now());
        c.setQrCodeUrl("http://localhost:8080/verify/" + verificationCode);

        return certificateRepo.save(c);
    }

    @Override
    public List<Certificate> getAllCertificates() {
        return certificateRepo.findAll();
    }

    @Override
    public Certificate verifyCertificate(String verificationCode) {
        return certificateRepo.findByVerificationCode(verificationCode);
    }
}