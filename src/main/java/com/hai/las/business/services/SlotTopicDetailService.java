/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hai.las.business.services;

import com.hai.las.data.entity.SlotTopicDetail;
import com.hai.las.data.entity.key.SlotTopicDetailKey;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author hai
 */
@Service
public interface SlotTopicDetailService {
    
    public List<SlotTopicDetail> findAll();
    
    public SlotTopicDetail findById(SlotTopicDetailKey id);
    
    public List<SlotTopicDetail> createSlotTopicDetails(List<SlotTopicDetail> details);
    
    public List<SlotTopicDetail> updateSlotTopicDetails(List<SlotTopicDetail> details);
    
    public void deleteSlotTopicDetails(List<SlotTopicDetailKey> ids);
    
}
