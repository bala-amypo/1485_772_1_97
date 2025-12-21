package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.entity.*;
import com.example.demo.repository.*;

@Service
public class CertificateServiceImpl implements CertificateService {

    private final CertificateRepository certificateRepository;
    private final StudentRepository studentRepository;
    private final CertificateTemplateRepository templateRepository;

    public CertificateServiceImpl(CertificateRepository certificateRepository,
                                  StudentRepository studentRepository,
                                  CertificateTemplateRepository templateRepository) {
        this.certificateRepository = certificateRepository;
        this.studentRepository = studentRepository;
        this.templateRepository = templateRepository;
    }

    @Override
    public Certificate generateCertificate(Long studentId, Long templateId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        CertificateTemplate template = templateRepository.findById(templateId).orElse(null);

        Certificate certificate = new Certificate(
                student,
                template,
                LocalDate.now(),
                UUID.randomUUID().toString(),
                "QR_CODE_URL"
        );
        return certificateRepository.save(certificate);
    }

    @Override
    public Certificate getCertificate(Long id) {
        return certificateRepository.findById(id).orElse(null);
    }

    @Override
    public Certificate getByVerificationCode(String code) {
        return certificateRepository.findByVerificationCode(code);
    }

    @Override
    public List<Certificate> getCertificatesByStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        return certificateRepository.findByStudent(student);
    }
}
