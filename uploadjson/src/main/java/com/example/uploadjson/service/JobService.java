package com.example.uploadjson.service;

import com.example.uploadjson.entity.Job;

public interface JobService {
    default void submitJob(Job job){}
}
