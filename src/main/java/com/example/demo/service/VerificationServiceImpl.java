package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.*;
import com.example.demo.repository.*;

@Service
public class VerificationServiceImpl implements VerificationService {

    private final CertificateRepository certificateRepository;
    private final VerificationLogRepository logRepository;

    public VerificationServiceImpl(CertificateRepository certificateRepository,
                                   VerificationLogRepository logRepository) {
        this.certificateRepository = certificateRepository;
        this.logRepository = logRepository;
    }

    @Override
    public VerificationLog verify(String code, String ip) {
        Certificate certificate = certificateRepository.findByVerificationCode(code);

        VerificationLog log = new VerificationLog(
                certificate,
                LocalDateTime.now(),
                certificate != null ? "SUCCESS" : "FAILED",
                ip
        );
        return logRepository.save(log);
    }

    @Override
    public List<VerificationLog> getLogs(Long certificateId) {
        Certificate cert = certificateRepository.findById(certificateId).orElse(null);
        return logRepository.findByCertificate(cert);
    }
}
