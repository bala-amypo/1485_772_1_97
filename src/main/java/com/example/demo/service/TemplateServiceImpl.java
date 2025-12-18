package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.CertificateTemplate;
import com.example.demo.repository.CertificateTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private CertificateTemplateRepository templateRepo;

    @Override
    public CertificateTemplate addTemplate(CertificateTemplate template) {
        return templateRepo.save(template);
    }

    @Override
    public List<CertificateTemplate> getAllTemplates() {
        return templateRepo.findAll();
    }
}