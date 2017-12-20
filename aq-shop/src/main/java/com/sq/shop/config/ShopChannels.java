package com.sq.shop.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface ShopChannels{

    String TEACHER_INPUT = "teacherInput";
    String TEACHER_OUTPUT = "teacherOutput";
    String STUDENT_INPUT = "studentInput";
    String STUDENT_OUTPUT = "studentOutput";

    @Input(TEACHER_INPUT)
    SubscribableChannel teacher_input();

    @Output(TEACHER_OUTPUT)
    MessageChannel teacher_output();

    @Input(STUDENT_INPUT)
    SubscribableChannel student_input();

    @Output(STUDENT_OUTPUT)
    MessageChannel student_output();
}
