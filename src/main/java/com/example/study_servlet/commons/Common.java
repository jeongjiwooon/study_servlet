package com.example.study_servlet.commons;

import java.util.UUID;

public class Common
{
    public String generateUUID()
    {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
}