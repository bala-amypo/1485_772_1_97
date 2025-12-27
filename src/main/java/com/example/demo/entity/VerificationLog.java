package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "verification_logs")
public class VerificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String verificationCode;

    private String ipAddress;

    private String status;

    private LocalDateTime verifiedAt;

    public VerificationLog() {}

    public VerificationLog(Long id, String verificationCode, String ipAddress,
                           String status, LocalDateTime verifiedAt) {
        this.id = id;
        this.verificationCode = verificationCode;
        this.ipAddress = ipAddress;
        this.status = status;
        this.verifiedAt = verifiedAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getVerificationCode() { return verificationCode; }
    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getVerifiedAt() { return verifiedAt; }
    public void setVerifiedAt(LocalDateTime verifiedAt) {
        this.verifiedAt = verifiedAt;
    }
}
