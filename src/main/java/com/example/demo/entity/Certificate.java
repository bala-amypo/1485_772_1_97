package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "certificates",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = "verificationCode")
       })
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String verificationCode;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String qrCodeUrl;

    // Many certificates → One student
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    // Many certificates → One template
    @ManyToOne
    @JoinColumn(name = "template_id", nullable = false)
    private CertificateTemplate template;

    // -------- Constructors --------
    public Certificate() {}

    public Certificate(Long id, String verificationCode, String qrCodeUrl,
                       Student student, CertificateTemplate template) {
        this.id = id;
        this.verificationCode = verificationCode;
        this.qrCodeUrl = qrCodeUrl;
        this.student = student;
        this.template = template;
    }

    // -------- Getters & Setters --------
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getVerificationCode() { return verificationCode; }
    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getQrCodeUrl() { return qrCodeUrl; }
    public void setQrCodeUrl(String qrCodeUrl) { this.qrCodeUrl = qrCodeUrl; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public CertificateTemplate getTemplate() { return template; }
    public void setTemplate(CertificateTemplate template) {
        this.template = template;
    }
}
