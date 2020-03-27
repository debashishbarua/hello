package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.model.Student;
import com.cognizant.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("display");

		List<Student> list = studentService.findAll();

		mv.addObject("list", list);

		return mv;

	}

}
