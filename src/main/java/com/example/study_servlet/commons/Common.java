package com.example.study_servlet.commons;

import java.util.UUID;

public class Common {
    // 1-1 ※ UUID 특정 키를 생성한다는 말.

    public static String generateUUID() {
        return UUID.randomUUID().toString();
        
    }


}