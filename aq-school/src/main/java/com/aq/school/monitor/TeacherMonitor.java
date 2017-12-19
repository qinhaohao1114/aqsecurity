package com.aq.school.monitor;

import com.aq.school.config.OrderProcessor;
import com.aq.school.config.SchoolChannels;
import com.aq.school.model.Student;
import com.aq.school.model.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class TeacherMonitor {
    private final static Logger logger = LoggerFactory.getLogger(TeacherMonitor.class);


    @StreamListener(SchoolChannels.TEACHER_INPUT)
    public void listenTeacher(Teacher t)  {
        logger.info("收到消息："+t);
    }

    @StreamListener(SchoolChannels.STUDENT_INPUT)
    public void listenStudent(Student t)  {
        logger.info("收到消息："+t);
    }
}
