/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hai.las.business.services;

import com.hai.las.data.entity.Lecturer;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author hai
 */
@Service
public interface LecturerService {

    public List<Lecturer> findAllLecturer();

    public Lecturer createLecturer(Lecturer lecturer);

    public Lecturer findLecturerById(Integer id);

    public Lecturer updateLecturer(Lecturer lecturer);
    
}
