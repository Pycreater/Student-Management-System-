package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import controller.api.Student;
import controller.service.StudentService;

@Controller
public class StudentController {
	
//	@Autowired
//	private StudentDAO studentDAO;	

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public String showStudentList(Model model) {
		
		List<Student> studentList = studentService.loadStudents();
		
		
		
		model.addAttribute("students",studentList);
		
		return "student-list";
	}
	
	@GetMapping("/showAddStudentPage")
	public String addStudent(Model model) {
		
		Student student = new Student();
		
		model.addAttribute("student", student);
		
		return "add-student";
	}
	
	
	@PostMapping("/save-student")
	public String saveStudent(Student student) {
		
		System.out.println(student);
		
		if (student.getId() == 0) {
		
			studentService.saveStudent(student);
			//insert a new record
		}
		else {
			//do a upadate
			studentService.update(student);
		}
		
		
		
		
		return "redirect:/showStudent";
	}
	
//	@ResponseBody
//	@GetMapping("/thankyou")
//	public String thankyou() {
//		
//		return "Thank You.. Your Records has been added to the database";
//	}
	
	
	
	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("userId") int id,Model model) {
		Student student = new Student();
		model.addAttribute("student",student);
		
		System.out.println("Looking data for the student having id :"+ id);
		
		Student theStudent= studentService.getStudent(id);
		System.out.println(theStudent);
		
		
//		
//		student.setId(theStudent.getId());
//		student.setName(theStudent.getName());
//		student.setMobile(theStudent.getMobile());
//		student.setCountry(theStudent.getCountry());
//		
		model.addAttribute("student",theStudent);
		
		return "add-student";
	}
	
	
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("userId") int id) {
		
		//capture id of student whom ur trying to delete
		
		studentService.deleteStudent(id);
		
		return "redirect:/showStudent";
	}
	
	
}
