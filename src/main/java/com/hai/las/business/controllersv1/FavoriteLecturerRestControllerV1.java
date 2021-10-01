/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hai.las.business.controllersv1;

import com.hai.las.business.controllers.FavoriteLecturerOperations;
import com.hai.las.business.services.FavoriteLecturerService;
import com.hai.las.data.entity.FavoriteLecturer;
import com.hai.las.data.entity.key.FavoriteLecturerKey;
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
@RequestMapping("api/v1/favorite-lecturers")
public class FavoriteLecturerRestControllerV1 implements FavoriteLecturerOperations {

    private final FavoriteLecturerService favoriteLecturerService;

    @Autowired
    public FavoriteLecturerRestControllerV1(@Qualifier("FavoriteLecturerServiceImplV1") FavoriteLecturerService favoriteLecturerService) {
        this.favoriteLecturerService = favoriteLecturerService;
    }

    @Override
    public List<FavoriteLecturer> createFavoriteLecturer(List<FavoriteLecturer> favoriteLecturers) {
        return favoriteLecturerService.addFavoriteLecturers(favoriteLecturers);
    }

    @Override
    public void deleteFavoriteLecturers(List<FavoriteLecturerKey> ids) {
        favoriteLecturerService.deleteFavoriteLecturers(ids);
    }

    @Override
    public List<FavoriteLecturer> findAll() {
        return favoriteLecturerService.findAllLecturerAndStudentInFavoriteLecturer();
    }
    
}
