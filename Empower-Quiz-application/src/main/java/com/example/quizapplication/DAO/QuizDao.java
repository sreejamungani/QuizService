package com.example.quizapplication.DAO;

import com.example.quizapplication.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {

}
