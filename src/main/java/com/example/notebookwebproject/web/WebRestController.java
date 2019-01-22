package com.example.notebookwebproject.web;

import com.example.notebookwebproject.SQLTEST.notebookdataTEST;
import com.example.notebookwebproject.SQLTEST.notebookdataTESTMapper;
import com.example.notebookwebproject.SQLTEST.sqlTEST;
import com.example.notebookwebproject.SQLTEST.sqlTESTMapper;
import com.example.notebookwebproject.domain.posts.PostsRepository;
import com.example.notebookwebproject.domain.posts.dto.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;
    private Environment env;
    private sqlTESTMapper sqlTestMapper;
    private notebookdataTESTMapper notebookdataTestMapper;

    @GetMapping("/hello")
    public String hello(){
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        postsRepository.save(dto.toEntity());
    }

    @GetMapping("/profile")
    public String getProfile () {
        return Arrays.stream(env.getActiveProfiles())
                .findFirst()
                .orElse("");
    }



    @RequestMapping("/notebooktest/{ID}")
    public String notebookdatahello(@PathVariable int ID){
        notebookdataTEST notebookdataTest = notebookdataTestMapper.findnotebookdataID(ID);
        return "Hello, " + notebookdataTest.getID() + ": " + notebookdataTest.getModel();
    }

}
