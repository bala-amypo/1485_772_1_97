package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Certificate;

public interface CertificateService {

    Certificate generateCertificate(Certificate certificate);

    List<Certificate> getAllCertificates();

    Optional<Certificate> verifyCertificate(String verificationCode);
}
