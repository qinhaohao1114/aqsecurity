package com.aq.school.Repository;

import com.aq.school.vo.TeacherVo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author WangJunJun
 */
@Repository
public interface TeacherInfoRedisRepository extends CrudRepository<TeacherVo, String>{

}
