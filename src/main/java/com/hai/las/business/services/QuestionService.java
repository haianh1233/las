/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hai.las.business.services;

import com.hai.las.data.entity.Question;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author hai
 */
@Service
public interface QuestionService {
    
    public List<Question> findAll();
    
    public Question findById(Integer id);
    
    public List<Question> createQuestions(List<Question> questions);
    
    public List<Question> updateQuestions(List<Question> questions);
    
    public void deleteQuestion(List<Integer> ids);
    
}
