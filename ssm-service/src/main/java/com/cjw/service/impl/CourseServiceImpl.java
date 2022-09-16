package com.cjw.service.impl;

import com.cjw.dao.CourseMapper;
import com.cjw.domain.Course;
import com.cjw.domain.CourseVO;
import com.cjw.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findCourseByCondition(CourseVO courseVO) {

        List<Course> courseByCondition = courseMapper.findCourseByCondition(courseVO);

        return courseByCondition;
    }
}
