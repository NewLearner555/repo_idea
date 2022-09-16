package com.cjw.service.impl;

import com.cjw.dao.TestMapper;
import com.cjw.domain.Test;
import com.cjw.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    //注入 dao对象
    @Autowired
    //将代理对象 进行注入
    private TestMapper testMapper;

    @Override
    public List<Test> findAllTest() {

        List<Test> allTest = testMapper.findAllTest();

        return allTest;
    }
}
