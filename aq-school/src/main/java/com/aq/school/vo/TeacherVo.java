package com.aq.school.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

 @Data
 @Log4j
 @NoArgsConstructor
 @AllArgsConstructor
public class TeacherVo {
    private int id;
    private String name;
    private int age;
    private String sex;
    private String education;
    private String educationSchool;
    private String honor;
}
