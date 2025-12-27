package com.example.demo.service.impl;

import com.example.demo.entity.Certificate;
import com.example.demo.entity.CertificateTemplate;
import com.example.demo.entity.Student;
import com.example.demo.repository.CertificateRepository;
import com.example.demo.repository.CertificateTemplateRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.CertificateService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CertificateServiceImpl implements CertificateService {

    private final CertificateRepository certificateRepository;
    private final StudentRepository studentRepository;
    private final CertificateTemplateRepository templateRepository;

    public CertificateServiceImpl(
            CertificateRepository certificateRepository,
            StudentRepository studentRepository,
            CertificateTemplateRepository templateRepository) {

        this.certificateRepository = certificateRepository;
        this.studentRepository = studentRepository;
        this.templateRepository = templateRepository;
    }

    // ---------------- GENERATE CERTIFICATE ----------------
    @Override
    public Certificate generateCertificate(Long studentId, Long templateId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        CertificateTemplate template = templateRepository.findById(templateId)
                .orElseThrow(() -> new RuntimeException("Template not found"));

        String verificationCode = "VC-" + UUID.randomUUID();
        String qrCodeUrl = "data:image/png;base64,DUMMY_QR_CODE";

        Certificate certificate = new Certificate();
        certificate.setStudent(student);
        certificate.setTemplate(template);
        certificate.setVerificationCode(verificationCode);
        certificate.setQrCodeUrl(qrCodeUrl);

        return certificateRepository.save(certificate);
    }

    // ---------------- GET CERTIFICATE ----------------
    @Override
    public Certificate getCertificate(Long id) {
        return certificateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Certificate not found"));
    }

    // ---------------- FIND BY VERIFICATION CODE ----------------
    @Override
    public Certificate findByVerificationCode(String code) {
        return certificateRepository.findByVerificationCode(code)
                .orElseThrow(() -> new RuntimeException("Certificate not found"));
    }

    // ---------------- FIND BY STUDENT ----------------
    @Override
    public List<Certificate> findByStudentId(Long studentId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return certificateRepository.findByStudent(student);
    }
}
