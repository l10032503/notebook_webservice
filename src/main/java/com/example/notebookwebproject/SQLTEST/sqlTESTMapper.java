package com.example.notebookwebproject.SQLTEST;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface sqlTESTMapper {

    @Select ("SELECT * FROM TEST WHERE testname = #{testname}")
    public sqlTEST findsqlTEST(@Param("testname") String testname);
}
