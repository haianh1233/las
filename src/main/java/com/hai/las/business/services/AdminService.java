/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hai.las.business.services;

import com.hai.las.data.entity.Lecturer;
import com.hai.las.data.entity.Student;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */

@Service
public interface AdminService {

    public List<Student> listAllStudent();

    public List<Lecturer> listAllLecturer();

    public Student findStudentById(Integer id);

    public Lecturer findLecturerById(Integer id);

    public void deleteStudents(List<Integer> ids);

    public void deleteLecturers(List<Integer> ids);
}
