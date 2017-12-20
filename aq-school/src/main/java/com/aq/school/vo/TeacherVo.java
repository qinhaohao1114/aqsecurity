package com.aq.school.vo;

import com.aq.school.model.BasePojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

 @Data
 @Log4j
 @NoArgsConstructor
 @AllArgsConstructor
 @RedisHash("teacher")
public class TeacherVo{
    @Id
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private String education;
    private String educationSchool;
    private String honor;
}
