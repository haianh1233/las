/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hai.las.data.repository;

import java.util.List;

import com.hai.las.data.entity.FavoriteLecturer;
import com.hai.las.data.entity.key.FavoriteLecturerKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hai
 */
@Repository
public interface FavoriteLecturerRepository extends JpaRepository<FavoriteLecturer, FavoriteLecturerKey> {
    
    @Query("FROM FavoriteLecturer f JOIN FETCH f.lecturer JOIN FETCH f.student")
    public List<FavoriteLecturer> findAllLecturerAndStudentInFavoriteLecturer();
}
