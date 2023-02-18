package com.example.UserManagementValidation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="tble_user")
public class User {

@Id
@Column(name="userid")
 private Integer userId;

 @Column(name="username")
 private String userName;
 @Column(name="dateofbirth")
 private String dateOfBirth;

 @Column(name="email")
 private String email;

 @Column(name="phoneno")
 private String phoneNumber;

 @Column(name="date")
 private String date;
 @Column(name="time")
 private String time;

}
