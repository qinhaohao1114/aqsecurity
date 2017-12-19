package com.aq.school.service.impl;

import com.aq.school.config.LoanProperties;
import com.aq.school.config.OrderProcessor;
import com.aq.school.config.SchoolChannels;
import com.aq.school.mapper.TeacherMapper;
import com.aq.school.model.Teacher;
import com.aq.school.service.BaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService extends BaseService<Teacher>{

    private final static Logger logger = LoggerFactory.getLogger(TeacherService.class);


    private final SchoolChannels channels;

    private  final LoanProperties loanProperties;

    public TeacherService(SchoolChannels channels,LoanProperties loanProperties) {
        this.channels = channels;
        this.loanProperties = loanProperties;
    }

    public void sendMessageToChannel(Teacher teacher){
        channels.teacher_output().send(MessageBuilder.withPayload(teacher).build());
    }
    public void sendMessageToQueue(Teacher teacher){
        channels.teacher_output().send(MessageBuilder.withPayload(teacher).setReplyChannelName(loanProperties.getReplyQueueName()).build());
    }

    @StreamListener(SchoolChannels.TEACHER_INPUT)
    public void listenTeacher(Teacher t)  {
        logger.info("收到消息："+t);
    }
}
