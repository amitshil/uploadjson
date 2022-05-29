package com.example.uploadjson.dao;

import com.example.uploadjson.entity.Customer;
import com.example.uploadjson.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDetailsDAO {

    @Autowired
    CustomerRepository customerRepository;

    public void saveCustomerDetails(List<Customer> data){
        customerRepository.saveAll(data);
    }

    public List<Customer> getAllCustomerDetails(){
        List<Customer> customersList = (List<Customer>) customerRepository.findAll();
        return customersList;
    }
}
