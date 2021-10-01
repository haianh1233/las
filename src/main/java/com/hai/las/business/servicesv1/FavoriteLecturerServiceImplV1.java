/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hai.las.business.servicesv1;

import com.hai.las.business.services.FavoriteLecturerService;
import com.hai.las.data.entity.FavoriteLecturer;
import com.hai.las.data.entity.key.FavoriteLecturerKey;
import com.hai.las.data.repository.FavoriteLecturerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author hai
 */
@Component
@Qualifier("FavoriteLecturerServiceImplV1")
public class FavoriteLecturerServiceImplV1 implements FavoriteLecturerService {
    
    private final FavoriteLecturerRepository favoriteLecturerRepo;

    @Autowired
    public FavoriteLecturerServiceImplV1(FavoriteLecturerRepository favoriteLecturerRepo) {
        this.favoriteLecturerRepo = favoriteLecturerRepo;
    }

    @Override
    public List<FavoriteLecturer> findAllLecturerAndStudentInFavoriteLecturer() {
        return favoriteLecturerRepo.findAllLecturerAndStudentInFavoriteLecturer();
    }

    @Override
    public void deleteFavoriteLecturers(List<FavoriteLecturerKey> ids) {
        favoriteLecturerRepo.deleteAllById(ids);
    }

    @Override
    public List<FavoriteLecturer> addFavoriteLecturers(List<FavoriteLecturer> favoriteLecturers) {
        return favoriteLecturerRepo.saveAll(favoriteLecturers);
    }

}
