/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hai.las.business.controllers;

import com.hai.las.data.entity.Lecturer;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author hai
 */
@RequestMapping("/default")
public interface LecturerOperations {
    
    @GetMapping
    public List<Lecturer> findAll();
    
    @GetMapping("/{id}")
    public Lecturer findByLecturerId(@PathVariable("id") Integer id);
    
    @PostMapping
    public Lecturer createLecturer(@RequestBody Lecturer lecturer);
    
    @PutMapping
    public Lecturer updateLecturer(@RequestBody Lecturer lecturer);
    
    @DeleteMapping
    public void deleteLecturers(List<Integer> ids);
    
}
