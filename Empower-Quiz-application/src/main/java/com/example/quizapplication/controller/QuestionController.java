package com.example.quizapplication.controller;


import com.example.quizapplication.Question;
import com.example.quizapplication.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("AllQuestions")
    public List<Question> getAllQuestions(){

        return questionService.getallQuesions();
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category){
         return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public String addQuestion( @RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @DeleteMapping("delete/{id}")
    public String deleteQuestion( @PathVariable  Integer id){
        return questionService.deleteQuestion(id);
    }

    @
}
