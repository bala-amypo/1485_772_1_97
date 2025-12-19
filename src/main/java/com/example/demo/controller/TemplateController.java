package com.example.demo.controller;

import java.util.List;
import com.example.demo.entity.CertificateTemplate;
import com.example.demo.service.TemplateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @PostMapping("/templates")
    public CertificateTemplate addTemplate(@RequestBody CertificateTemplate template) {
        return templateService.addTemplate(template);
    }

    @GetMapping("/templates")
    public List<CertificateTemplate> getTemplates() {
        return templateService.getAllTemplates();
    }
}