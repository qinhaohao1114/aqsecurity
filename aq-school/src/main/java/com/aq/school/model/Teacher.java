package com.aq.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
 @Log4j
 @NoArgsConstructor
 @AllArgsConstructor
 @Table(name = "teacher")
public class Teacher extends BasePojo implements Serializable{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String sex;
    private String education;
    private String educationSchool;
    private String honor;
}
