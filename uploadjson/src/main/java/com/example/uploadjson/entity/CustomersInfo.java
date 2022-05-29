package com.example.uploadjson.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomersInfo {
    private int noOfRecords;
    private List<Customer> customerList;
}
