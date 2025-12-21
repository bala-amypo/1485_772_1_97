package com.example.demo.service;

import com.example.demo.entity.Certificate;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CertificateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificateServiceImpl implements CertificateService {

    @Autowired
    private CertificateRepository certificateRepository;

    @Override
    public Certificate getCertificateById(Long id) {
        return certificateRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Certificate not found with id " + id
                        )
                );
    }
}
