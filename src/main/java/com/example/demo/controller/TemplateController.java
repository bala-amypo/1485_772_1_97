package com.example.demo.controller;

import com.example.demo.entity.CertificateTemplate;
import com.example.demo.service.TemplateService;

import java.util.List;

public class TemplateController {

    private final TemplateService templateService;

    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    public CertificateTemplate add(CertificateTemplate template) {
        return templateService.addTemplate(template);
    }

    public List<CertificateTemplate> list() {
        return templateService.getAllTemplates();
    }
}
