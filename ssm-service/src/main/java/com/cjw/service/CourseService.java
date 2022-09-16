package com.cjw.service;


import com.cjw.domain.Course;
import com.cjw.domain.CourseVO;

import java.util.List;

public interface CourseService {
    /**
     * 多条件课程列表查询
     */
    List<Course> findCourseByCondition(CourseVO courseVO);

}
