package com.aq.school.controller;

import com.aq.common.beans.ResultBean;
import com.aq.school.Repository.TeacherInfoRedisRepository;
import com.aq.school.model.Teacher;
import com.aq.school.service.impl.TeacherService;
import com.aq.school.vo.TeacherVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/teacher")
@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherInfoRedisRepository teacherInfoRedisRepository;
    @RequestMapping("/getAll")
    @ResponseBody
    public ResultBean<List<Teacher>> getTeacherListAll(){

        try {
            List<Teacher> teachers = teacherService.queryAll();
            teacherService.sendMessageToChannel(teachers.get(0));
            //teacherService.sendMessageToQueue(teachers.get(0));

            TeacherVo teacherVo = new TeacherVo();
            teacherVo.setId(2);
            teacherVo.setName("daye");
            teacherVo.setAge(13);
            teacherInfoRedisRepository.save(teacherVo);
            teacherInfoRedisRepository.findOne(teacherVo.getId().toString());
            return new ResultBean<List<Teacher>>(teachers, HttpStatus.OK);
        }catch (Exception e){
            return new ResultBean<List<Teacher>>(e);
        }
    }

}
