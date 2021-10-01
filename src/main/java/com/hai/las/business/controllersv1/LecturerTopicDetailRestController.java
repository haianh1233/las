/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hai.las.business.controllersv1;

import com.hai.las.business.controllers.LecturerTopicDetailOperations;
import com.hai.las.business.services.LecturerTopicDetailService;
import com.hai.las.data.entity.LecturerTopicDetail;
import com.hai.las.data.entity.key.LecturerTopicDetailKey;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hai
 */
@RestController
@RequestMapping("api/v1/lecturer-topic-details")
public class LecturerTopicDetailRestController implements LecturerTopicDetailOperations {
    
    private final LecturerTopicDetailService lecturerTopicDetailService;

    @Autowired
    public LecturerTopicDetailRestController(@Qualifier("LecturerTopicDetailImplV1") LecturerTopicDetailService lecturerTopicDetailService) {
        this.lecturerTopicDetailService = lecturerTopicDetailService;
    }

    @Override
    public List<LecturerTopicDetail> findAll() {
        return lecturerTopicDetailService.findAllLecturerAndTopicInLecturerTopicDetail();
    }

    @Override
    public List<LecturerTopicDetail> createLecturerTopicDetails(List<LecturerTopicDetail> lecturerTopicDetails) {
        return lecturerTopicDetailService.createLecturerTopicDetails(lecturerTopicDetails);
    }

    @Override
    public void deleteLecturerTopicDetails(List<LecturerTopicDetailKey> ids) {
        lecturerTopicDetailService.deleteLecturerTopicDetails(ids);
    }
    
    
}
