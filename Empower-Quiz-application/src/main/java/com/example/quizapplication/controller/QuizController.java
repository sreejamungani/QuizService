package com.example.quizapplication.controller;

import com.example.quizapplication.Service.QuizService;
import com.example.quizapplication.model.Question;
import com.example.quizapplication.model.QuestionWrapper;
import com.example.quizapplication.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam Integer numQ, @RequestParam String title){
        return quizService.createQuiz(category,numQ,title);
    }


    @GetMapping("getQuiz/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @GetMapping("submitQuiz/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> res){
        return quizService.getScore(id,res);
    }
}

