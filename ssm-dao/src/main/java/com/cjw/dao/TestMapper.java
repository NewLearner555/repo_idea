package com.cjw.dao;

import com.cjw.domain.Test;

import java.util.List;

public interface TestMapper {
    /*
        对 test表进行 查询所有的操作
     */
    List<Test> findAllTest();
    
    List<Test> findAllTest2();

}
