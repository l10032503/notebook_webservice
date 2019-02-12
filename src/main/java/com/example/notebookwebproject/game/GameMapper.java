package com.example.notebookwebproject.game;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface GameMapper {
    @Select("SELECT * FROM game WHERE ID = #{ID}")
    public Game findgameID(@Param("ID") int ID);
}
