/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hai.las.data.repository;

import com.hai.las.data.entity.SlotTopicDetail;
import com.hai.las.data.entity.key.SlotTopicDetailKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hai
 */
@Repository
public interface SlotTopicDetailRepository extends JpaRepository<SlotTopicDetail, SlotTopicDetailKey>{
    
}
