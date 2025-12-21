package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.CertificateTemplate;
import com.example.demo.repository.CertificateTemplateRepository;

@Service
public class TemplateServiceImpl implements TemplateService {

    private final CertificateTemplateRepository templateRepository;

    public TemplateServiceImpl(CertificateTemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    @Override
    public CertificateTemplate addTemplate(CertificateTemplate template) {
        return templateRepository.save(template);
    }

    @Override
    public List<CertificateTemplate> getAllTemplates() {
        return templateRepository.findAll();
    }

    @Override
    public CertificateTemplate getTemplateById(Long id) {
        return templateRepository.findById(id).orElse(null);
    }
}
