package com.broadway.springDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.broadway.springDemo.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {

	Student FindByNameAndPassword(String nam, String pass);

	
}
