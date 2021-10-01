/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hai.las.data.entity.key;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author hai
 */
@Embeddable
@NoArgsConstructor
@Data
public class LecturerTopicDetailKey implements Serializable {
    
    @Column(name = "lecturerid")
    private Integer lecturerId;
    
    @Column(name = "topicid")
    private Integer topicId;

    @Builder
    public LecturerTopicDetailKey(Integer lecturerId, Integer topicId) {
        this.lecturerId = lecturerId;
        this.topicId = topicId;
    }
    
}
