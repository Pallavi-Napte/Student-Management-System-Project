package com.cjc.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjc.main.model.Student;

public interface AdminRepository extends JpaRepository<Student, Integer>{

	public List<Student> findAllByBatchNumber(String batchNumber);

}
