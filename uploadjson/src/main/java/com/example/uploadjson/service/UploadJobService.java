package com.example.uploadjson.service;

import com.example.uploadjson.entity.Customer;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UploadJobService extends JobService{
    void submitUploadJob(String clientId, MultipartFile file);
    List<Customer> getCustomersInfo();
}
