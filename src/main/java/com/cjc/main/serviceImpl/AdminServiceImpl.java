package com.cjc.main.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.ServiceI.AdminServiceI;
import com.cjc.main.model.Student;
import com.cjc.main.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminServiceI{

	
	@Autowired
    AdminRepository ar;
	
	
	@Override
	public void saveStudent(Student student) {
		ar.save(student);
	}
	
	
	@Override
	public List<Student> getAllStudents(){
		
		return ar.findAll();
	}


	@Override
	public List<Student> searchStudentsByBatch(String batchNumber) {
		
		List<Student> batchStudents = ar.findAllByBatchNumber(batchNumber);
		return batchStudents;
	}


	@Override
	public Student getSingleStudent(int id) {
		Optional<Student> opStudent = ar.findById(id);
		return opStudent.get();
	}


	@Override
	public void updateStudentFees(int studentid, float amount) {
		Optional<Student> opStudent = ar.findById(studentid);
		Student st = opStudent.get();
		st.setFeesPaid(st.getFeesPaid()+amount);
		ar.save(st);
	}


	@Override
	public void deleteData(Student s) {
		ar.delete(s);
		
	}


	@Override
	public void updateStudentBatch(int studentid, String batch) {
		Optional<Student> opStudent = ar.findById(studentid);
		Student st = opStudent.get();
		st.setBatchNumber(st.getBatchNumber()+batch);
		ar.save(st);;
	}
	 

}
