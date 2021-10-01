/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hai.las.business.services;

import com.hai.las.data.entity.FavoriteLecturer;
import com.hai.las.data.entity.key.FavoriteLecturerKey;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author hai
 */
@Service
public interface FavoriteLecturerService {
    
    public List<FavoriteLecturer> findAllLecturerAndStudentInFavoriteLecturer();
    
    public List<FavoriteLecturer> addFavoriteLecturers(List<FavoriteLecturer> favoriteLecturers);

    public void deleteFavoriteLecturers(List<FavoriteLecturerKey> ids);
    
}
