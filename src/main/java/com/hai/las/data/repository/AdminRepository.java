/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hai.las.data.repository;

import com.hai.las.data.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 *
 * @author Admin
 */
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    public Optional<Admin> findAdminByUsername(String username);

}
