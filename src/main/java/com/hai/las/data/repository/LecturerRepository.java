/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hai.las.data.repository;

import java.util.Optional;

import com.hai.las.data.entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hai
 */
@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {

    public Optional<Lecturer> findByName(String name);

    public Optional<Lecturer> findLecturerByEmail(String email);
}
