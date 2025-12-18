package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Certificate;

public interface CertificateService {
    Certificate generateCertificate(Certificate certificate);
    List<Certificate> getAllCertificates();
    Certificate verifyCertificate(String verificationCode);
}