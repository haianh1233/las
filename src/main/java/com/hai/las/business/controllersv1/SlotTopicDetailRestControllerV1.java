/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hai.las.business.controllersv1;

import com.hai.las.business.controllers.SlotTopicDetailOperations;
import com.hai.las.business.services.SlotTopicDetailService;
import com.hai.las.data.entity.SlotTopicDetail;
import com.hai.las.data.entity.key.SlotTopicDetailKey;
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
@RequestMapping("/api/v1/slot-topic-details")
public class SlotTopicDetailRestControllerV1 implements SlotTopicDetailOperations {

    private final SlotTopicDetailService service;

    @Autowired
    public SlotTopicDetailRestControllerV1(@Qualifier("SlotTopicDetailServiceImplV1") SlotTopicDetailService service) {
        this.service = service;
    }

    @Override
    public List<SlotTopicDetail> findAll() {
        return service.findAll();
    }

    @Override
    public SlotTopicDetail findById(SlotTopicDetailKey id) {
        return service.findById(id);
    }

    @Override
    public List<SlotTopicDetail> createSlotTopicDetails(List<SlotTopicDetail> details) {
        return service.createSlotTopicDetails(details);
    }

    @Override
    public List<SlotTopicDetail> updateSlotTopicDetails(List<SlotTopicDetail> details) {
        return service.updateSlotTopicDetails(details);
    }

    @Override
    public void deleteSlotTopicDetails(List<SlotTopicDetailKey> ids) {
        service.deleteSlotTopicDetails(ids);
    }

}
