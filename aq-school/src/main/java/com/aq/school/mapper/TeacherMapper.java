package com.aq.school.mapper;

import com.aq.school.SupperMapper;
import com.aq.school.model.Teacher;
import java.util.List;


public interface TeacherMapper extends SupperMapper<Teacher> {

    List<Teacher> getTeacherListAll();
}
