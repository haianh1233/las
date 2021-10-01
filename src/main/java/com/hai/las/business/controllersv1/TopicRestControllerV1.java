/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hai.las.business.controllersv1;

import com.hai.las.business.controllers.TopicOperations;
import com.hai.las.business.services.TopicService;
import com.hai.las.data.entity.Topic;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api/v1/topics")
public class TopicRestControllerV1 implements TopicOperations {
    
    private final TopicService service;
    
    @Autowired
    
    public TopicRestControllerV1(@Qualifier("TopicServiceImplV1") TopicService service) {
        this.service = service;
    }
    
    @Override
    public List<Topic> findAll() {
        return service.findAll();
    }
     
    @Override
    public List<Topic> createTopics(List<Topic> topics) {
        return service.createTopics(topics);
    }
    
    @Override
    public List<Topic> updateTopics(List<Topic> topics) {
        return service.updateTopics(topics);
    }

    @Override
    public Topic findById(Integer id) {
        return service.findById(id);
    }

    @Override
    public void deleteTopics(List<Integer> ids) {
        service.deleteTopics(ids);
    }

    
    
    
   
}
