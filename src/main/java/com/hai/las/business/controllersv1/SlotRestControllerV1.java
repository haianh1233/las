/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hai.las.business.controllersv1;

import java.util.List;

import com.hai.las.business.controllers.SlotOperations;
import com.hai.las.business.services.SlotService;
import com.hai.las.data.entity.Slot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api/v1/slots")
public class SlotRestControllerV1 implements SlotOperations {

    private final SlotService service;

    @Autowired
    public SlotRestControllerV1(@Qualifier("SlotServiceImplV1") SlotService service) {
        this.service = service;
    }

    @Override
    public List<Slot> findAll() {
        return service.findAll();
    }

    @Override
    public Slot findById(Integer id) {
        return service.findById(id);
    }

    @Override
    public List<Slot> createSlots(List<Slot> slots) {
        return service.createSlots(slots);
    }

    @Override
    public List<Slot> updateSlots(List<Slot> slots) {
        return service.updateSlots(slots);
    }

    @Override
    public void deleteSlots(List<Integer> ids) {
        service.deleteSlots(ids);
    }

}
