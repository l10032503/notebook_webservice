package com.example.notebookwebproject.game;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GameMapper {
    @Select("SELECT * FROM game WHERE gameid = #{gameid}")
    public Game findgameID(@Param("gameid") int gameid);
}
