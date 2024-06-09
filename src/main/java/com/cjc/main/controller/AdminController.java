package com.cjc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.main.ServiceI.AdminServiceI;
import com.cjc.main.model.Student;

@Controller
public class AdminController {
	
	@Autowired
	AdminServiceI as;

	@RequestMapping("/")
	public String prelogin() {
		return "login";
	}
	
	@RequestMapping("/login")
	public String onlogin(@RequestParam String username, @RequestParam String password,Model m) {
		if(username.equals("admin") && password.equals("admin123")) {
			List<Student> students = as.getAllStudents();
			m.addAttribute("data", students);
			return "adminscreen";
		}
		else {
			m.addAttribute("login_fail", "Enter valid login details.");
			return "login";
		}
	}
	
	@RequestMapping("/enroll student")
	public String saveStudent(@ModelAttribute Student student,Model m) {
		as.saveStudent(student);
		List<Student> students = as.getAllStudents();
		m.addAttribute("data", students);
		return "adminscreen";
	}
	
	
	@RequestMapping("/search")
	public String getBatchStudent(@RequestParam String batchNumber, Model m)
	{
		List<Student> result = as.searchStudentsByBatch(batchNumber);
		if(result.size()>0) {
			m.addAttribute("data", result);
			
		}else {
			List<Student> students = as.getAllStudents();
			m.addAttribute("data", students);
			m.addAttribute("message", "No records are available for the batch '"+batchNumber+"'....!");
		}
		
		return "adminscreen";
	}
	
	@RequestMapping("/fees")
	public String onFees(@RequestParam int id, Model m) {
		Student st = as.getSingleStudent(id);
		m.addAttribute("st", st);
		return "fees";
	}
	
	@RequestMapping("/payfees")
	public String payFees(@RequestParam int studentid, @RequestParam float amount,Model m) {
		as.updateStudentFees(studentid,amount);
		List<Student> students = as.getAllStudents();
		m.addAttribute("data", students);
		return "adminscreen";
	}
	
	
	@RequestMapping("/remove")
	public String deleteStudent(@ModelAttribute Student s,Model m) {
		as.deleteData(s);
		List<Student> students = as.getAllStudents();
		m.addAttribute("data", students);
		return "adminscreen";
	}
	
	
	@RequestMapping("/batch")
	public String onBatch(@RequestParam int id, Model m) {
		Student st = as.getSingleStudent(id);
		m.addAttribute("st", st);
		return "batch";
	}
	
	@RequestMapping("/shiftbatch")
	public String shiftBatch(@RequestParam int studentid, @RequestParam String batch,Model m) {
		as.updateStudentBatch(studentid,batch);
		List<Student> students = as.getAllStudents();
		m.addAttribute("data", students);
		return "adminscreen";
	}
	
}
