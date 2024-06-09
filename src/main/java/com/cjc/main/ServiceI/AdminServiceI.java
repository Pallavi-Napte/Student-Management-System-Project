package com.cjc.main.ServiceI;

import java.util.List;

import com.cjc.main.model.Student;

public interface AdminServiceI {

	public void saveStudent(Student student);

	public List<Student> getAllStudents();
	public List<Student> searchStudentsByBatch(String batchNumber);

	public Student getSingleStudent(int id);

	public void updateStudentFees(int studentid, float amount);

	public void deleteData(Student s);

	public void updateStudentBatch(int studentid, String batch);

}
