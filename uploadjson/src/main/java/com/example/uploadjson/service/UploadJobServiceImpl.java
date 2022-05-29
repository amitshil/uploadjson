package com.example.uploadjson.service;

import com.example.uploadjson.dao.CustomerDetailsDAO;
import com.example.uploadjson.entity.Customer;
import com.example.uploadjson.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class UploadJobServiceImpl implements UploadJobService {

    @Autowired
    CustomerDetailsDAO customerDetailsDAO;

    @Override
    public void submitUploadJob(String clientId, MultipartFile file) {
        String fileName = file.getOriginalFilename();

        Job job = new Job();
        job.setJob_id(clientId);
        job.setJob_status("Submitted");
        job.setInputFileName(fileName);
        System.out.println("Request received : " + job);

        try {
            save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<Customer> getCustomersInfo(){
        List<Customer> data = customerDetailsDAO.getAllCustomerDetails();
        return data;
    }

    private void save(MultipartFile file) throws IOException {
        Gson gson = new Gson();
        Reader reader = new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8);
        List<Customer> data = gson.fromJson(reader, new TypeToken<List<Customer>>() {}.getType());
        customerDetailsDAO.saveCustomerDetails(data);
        displayCustomersInfo();

    }

    public void displayCustomersInfo() {
        List<Customer> data = customerDetailsDAO.getAllCustomerDetails();
        for (Customer customer : data) {
            System.out.println(customer.getId()+" "+customer.getTitle());
        }
    }

}
