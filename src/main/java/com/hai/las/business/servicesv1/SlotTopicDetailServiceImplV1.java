/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hai.las.business.servicesv1;

import com.hai.las.business.services.SlotTopicDetailService;
import com.hai.las.data.entity.SlotTopicDetail;
import com.hai.las.data.entity.key.SlotTopicDetailKey;
import com.hai.las.data.repository.SlotTopicDetailRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author hai
 */
@Component
@Qualifier("SlotTopicDetailServiceImplV1")
public class SlotTopicDetailServiceImplV1 implements SlotTopicDetailService {

    private final SlotTopicDetailRepository detailRepository;

    @Autowired
    public SlotTopicDetailServiceImplV1(SlotTopicDetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    @Override
    public List<SlotTopicDetail> findAll() {
        return detailRepository.findAll();
    }

    @Override
    public SlotTopicDetail findById(SlotTopicDetailKey id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SlotTopicDetail> createSlotTopicDetails(List<SlotTopicDetail> details) {
        return detailRepository.saveAll(details);
    }

    @Override
    public List<SlotTopicDetail> updateSlotTopicDetails(List<SlotTopicDetail> details) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteSlotTopicDetails(List<SlotTopicDetailKey> ids) {
        detailRepository.deleteAllById(ids);
    }
    
}
