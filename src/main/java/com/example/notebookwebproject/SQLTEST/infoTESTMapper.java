package com.example.notebookwebproject.SQLTEST;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface infoTESTMapper {

    @Select("SELECT * FROM notebookdata WHERE ID = #{ID}")
    public infoTEST findinfotestID(@Param("ID") int ID);

}
