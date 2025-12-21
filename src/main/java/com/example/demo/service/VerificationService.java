package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.VerificationLog;

public interface VerificationService {
    VerificationLog verify(String code, String ip);
    List<VerificationLog> getLogs(Long certificateId);
}
