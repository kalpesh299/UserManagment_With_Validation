package com.example.UserManagementValidation.dao;

import com.example.UserManagementValidation.model.User;

import org.springframework.data.jpa.repository.JpaRepository;


import javax.swing.*;


public interface userRepository extends JpaRepository<User,Integer> {
}
