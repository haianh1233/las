/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hai.las.data.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 *
 * @author hai
 */
@Entity
@Table(name = "bookingrequest")
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BookingRequest implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
      
    @Column(name = "studentid")
    private String studentId;
     
    @Column(name = "status")
    private Integer status;
    
    @OneToMany(targetEntity = Question.class, mappedBy = "bookingId")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Question> questions;

    @Column(name = "topicid")
    private String topicId;
    
    @Column(name = "slotid")
    private String slotId;

    @Builder
    public BookingRequest(Integer id, String studentId, Integer status, List<Question> questions, String topicId, String slotId) {
        this.id = id;
        this.studentId = studentId;
        this.status = status;
        this.questions = questions;
        this.topicId = topicId;
        this.slotId = slotId;
    }


}
