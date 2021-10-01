/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hai.las.business.controllersv1;

import com.hai.las.business.controllers.LecturerOperations;
import com.hai.las.business.services.LecturerService;
import com.hai.las.data.entity.Lecturer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hai
 */
@RestController
@RequestMapping("api/v1/lecturers")
public class LecturerRestControllerV1 implements LecturerOperations {
    
    private final LecturerService lecturerService;

    @Autowired
    public LecturerRestControllerV1(@Qualifier("LecturerServiceImplV1") LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @Override
    public List<Lecturer> findAll() {
        return lecturerService.findAllLecturer();
    }

    @Override
    public Lecturer findByLecturerId(Integer id) {
        return lecturerService.findLecturerById(id);
    }

    @Override
    public Lecturer createLecturer(Lecturer lecturer) {
        return lecturerService.createLecturer(lecturer);
    }

    @Override
    public Lecturer updateLecturer(Lecturer lecturer) {
        return lecturerService.updateLecturer(lecturer);
    }

    @Override
    public void deleteLecturers(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
