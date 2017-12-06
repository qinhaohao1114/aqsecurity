package com.aq.school.service.impl;

import com.aq.school.mapper.TeacherMapper;
import com.aq.school.service.ITeacherService;
import com.aq.school.vo.TeacherVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService implements ITeacherService{

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<TeacherVo> getTeacherListAll() {

        return teacherMapper.getTeacherListAll();
    }
}
