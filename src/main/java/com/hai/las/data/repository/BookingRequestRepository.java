/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hai.las.data.repository;

import java.util.List;
import java.util.Optional;

import com.hai.las.data.entity.BookingRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hai
 */
@Repository
public interface BookingRequestRepository extends JpaRepository<BookingRequest, Integer> {

    @Query("FROM BookingRequest b JOIN FETCH b.questions WHERE b.id = :id")
    public Optional<BookingRequest> findByIdAndGetQuestions(Integer id);
    
    @Transactional
    public void deleteByIdIn(List<Integer> id);
    
}
