/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hai.las.data.repository;

import java.util.List;

import com.hai.las.data.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hai
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{
    
    @Transactional
    public void deleteByIdIn(List<Integer> ids);
    
}
