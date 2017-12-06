package com.aq.school.controller;

import com.aq.school.service.ITeacherService;
import com.aq.school.vo.TeacherVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/teacher")
@Controller
public class TeacherController {

    @Autowired
    private ITeacherService teacherService;

    @RequestMapping("/getAll")
    @ResponseBody
    public List<TeacherVo> getTeacherListAll(){
        TeacherVo teacherVo = new TeacherVo();

        return teacherService.getTeacherListAll();
    }
}
