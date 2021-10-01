/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hai.las.data.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.hai.las.data.entity.key.SlotTopicDetailKey;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

/**
 *
 * @author hai
 */
@Entity
@Table(name = "slottopicdetail")
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id", scope = SlotTopicDetail.class)
public class SlotTopicDetail implements Serializable {
    
    @JsonIgnore
    @EmbeddedId
    private SlotTopicDetailKey id = new SlotTopicDetailKey();
    
    @ManyToOne(targetEntity = Slot.class, fetch = FetchType.LAZY)
    @MapsId("slotId")
    @JoinColumn(name = "slotid")
    private Slot slot;

    @ManyToOne(targetEntity = Topic.class, fetch = FetchType.LAZY)
    @MapsId("topicId")
    @JoinColumn(name = "topicid")
    private Topic topic;

    @Builder
    public SlotTopicDetail(Slot slot, Topic topic) {
        this.slot = slot;
        this.topic = topic;
    }
    
}
