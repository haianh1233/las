/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hai.las.business.services;

import java.util.List;

import com.hai.las.data.entity.LecturerTopicDetail;
import com.hai.las.data.entity.key.LecturerTopicDetailKey;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public interface LecturerTopicDetailService {

    public List<LecturerTopicDetail> findAllLecturerAndTopicInLecturerTopicDetail();

    public LecturerTopicDetail findById(LecturerTopicDetailKey id);

    public List<LecturerTopicDetail> createLecturerTopicDetails(List<LecturerTopicDetail> details);

    public List<LecturerTopicDetail> updateLecturerTopicDetails(List<LecturerTopicDetail> details);

    public void deleteLecturerTopicDetails(List<LecturerTopicDetailKey> key);
}
