/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hai.las.business.servicesv1;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.hai.las.business.services.MajorService;
import com.hai.las.data.entity.Major;
import com.hai.las.data.repository.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hai
 */
@Component
@Qualifier("MajorServiceImplV1")
public class MajorServiceImplV1 implements MajorService {

    private final MajorRepository majorRepository;

    @Autowired
    public MajorServiceImplV1(MajorRepository majorRepository) {
        this.majorRepository = majorRepository;
    }

    @Override
    public List<Major> findAll() {
        return majorRepository.findAll();
    }

    @Override
    public Major findById(String id) {
        return majorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Major> createMajors(List<Major> majors) {
        return majorRepository.saveAll(majors);
    }

    @Override
    @Transactional
    public List<Major> updateMajors(List<Major> majors) {
        
        Set updateId = majors
                .stream()
                .filter(t -> t.getDescription() != null
                            || t.getName() != null)
                .map(Major::getId)
                .collect(Collectors.toSet());

        List<Major> majorList = (List<Major>) majorRepository
                .findAllById(updateId)
                .stream()
                .collect(Collectors.toList());

        majorList.forEach((major -> {
            Major updateMajor = majors
                    .stream()
                    .filter(t-> t.getId().equals(major.getId()))
                    .findAny()
                    .get();
            
            if(updateMajor.getDescription() != null) 
                major.setDescription(updateMajor.getDescription());
            
            if(updateMajor.getName() != null)
                major.setName(updateMajor.getName());
            
        }));

        return majorRepository.saveAll(majorList);
    }

    @Override
    public void deleteMajors(List<String> ids) {
        majorRepository.deleteAllById(ids);
    }
    
}
