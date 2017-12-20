package com.aq.stream;

import com.aq.school.Repository.TeacherInfoRedisRepository;
import com.aq.school.SchoolApplication;
import com.aq.school.vo.TeacherVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SchoolApplication.class)
public class TestRedis {
    @Autowired
    private TeacherInfoRedisRepository teacherInfoRedisRepository;

    @Test
    public void testRedis1(){
        TeacherVo one = teacherInfoRedisRepository.findOne("1");
        List<TeacherVo> all = (List)teacherInfoRedisRepository.findAll();
        System.out.println(all.size());
        System.out.println(one);
    }

}
