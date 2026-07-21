package com.example.quizapplication.Service;

import com.example.quizapplication.DAO.QuestionDao;
import com.example.quizapplication.DAO.QuizDao;
import com.example.quizapplication.model.Question;
import com.example.quizapplication.model.QuestionWrapper;
import com.example.quizapplication.model.Response;
import com.example.quizapplication.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, Integer numQ, String title) {

        List<Question> questions= questionDao.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz= new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }


    public ResponseEntity<Integer> getScore(Integer id, List<Response> res) {

        Quiz quiz= quizDao.findById(id).get();
        List<Question> questions= quiz.getQuestions();

        int right=0;
        int i=0;
        for(Response r:res){
            if (r.getResponse().equals(questions.get(i).getRightAnswer())){
                right++;
            }
            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz= quizDao.findById(id);
        List<Question> questionsFromDB= quiz.get().getQuestions();
        List<QuestionWrapper> questionsToUser= new ArrayList<>();
        for ( Question q:questionsFromDB) {
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionsToUser.add(qw);
        }
        return new ResponseEntity<>(questionsToUser,HttpStatus.OK);
    }
}
