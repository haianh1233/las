/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hai.las.business.controllersv1;

import com.hai.las.business.controllers.QuestionOperations;
import com.hai.las.business.services.QuestionService;
import com.hai.las.data.entity.Question;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wifil
 */
@RestController
@RequestMapping("/api/v1/questions")
public class QuestionRestControllerV1 implements QuestionOperations {
    
    private final QuestionService service;
    
    @Autowired
    public QuestionRestControllerV1(@Qualifier("QuestionServiceImplV1") QuestionService service) {
        this.service = service;
    }
    
    @Override
    public List<Question> getAllQuestions() {
        return service.findAll();
    }
    
    @Override
    public Question getQuestionById(@PathVariable Integer id) {
        return service.findById(id);
    }
    
    @Override
    public List<Question> createQuestions(@RequestBody List<Question> questions) {
        return service.createQuestions(questions);
    }
    
    @Override
    public List<Question> updateQuestions(@RequestBody List<Question> questions) {
        return service.updateQuestions(questions);
    }
    
    @Override
    public void deleteQuestions(@RequestBody List<Integer> ids) {
        service.deleteQuestion(ids);
    }
    
}
