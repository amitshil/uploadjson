package com.example.uploadjson.controller;

import com.example.uploadjson.entity.Customer;
import com.example.uploadjson.entity.CustomersInfo;
import com.example.uploadjson.service.UploadJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class JobSubmissionController {
    @Autowired
    private UploadJobService jobService;

    @CrossOrigin
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String uploadJSONFile(@RequestPart("clientId") String clientId, @RequestPart("file") MultipartFile file) {
        jobService.submitUploadJob(clientId,file);
        return "Job Submitted";
    }

    @CrossOrigin
    @GetMapping(value = "/showCustomersInfo", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomersInfo> showCustomersInfo(){
        List<Customer> customerList = jobService.getCustomersInfo();
        CustomersInfo customersInfo = new CustomersInfo();
        customersInfo.setCustomerList(customerList);
        customersInfo.setNoOfRecords(customerList.size());
        return new ResponseEntity<>(customersInfo,HttpStatus.OK);
    }


}
