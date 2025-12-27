package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "certificate_templates")
public class CertificateTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String templateName;

    @Column(nullable = false)
    private String backgroundUrl;

    // -------- Constructors --------
    public CertificateTemplate() {}

    public CertificateTemplate(Long id, String templateName, String backgroundUrl) {
        this.id = id;
        this.templateName = templateName;
        this.backgroundUrl = backgroundUrl;
    }

    // -------- Getters & Setters --------
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTemplateName() { return templateName; }
    public void setTemplateName(String templateName) { this.templateName = templateName; }

    public String getBackgroundUrl() { return backgroundUrl; }
    public void setBackgroundUrl(String backgroundUrl) { this.backgroundUrl = backgroundUrl; }
}
