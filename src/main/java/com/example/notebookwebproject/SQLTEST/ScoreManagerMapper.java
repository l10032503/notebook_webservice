package com.example.notebookwebproject.SQLTEST;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ScoreManagerMapper {

    @Select("SELECT * FROM notebookdata WHERE ID = #{ID}")
    public ScoreManager find_dataID(@Param("ID") int ID);

}
