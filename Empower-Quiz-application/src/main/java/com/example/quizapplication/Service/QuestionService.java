package com.example.quizapplication.Service;

import com.example.quizapplication.DAO.QuestionDao;
import com.example.quizapplication.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public List<Question> getallQuesions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
         return questionDao.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "Success";
    }

    public String deleteQuestion(Integer id) {
         questionDao.deleteById(id);
         return "deleted Successfully";
    }
}
