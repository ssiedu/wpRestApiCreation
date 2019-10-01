package com.ssi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssi.dao.CourseDAO;
import com.ssi.entity.Course;


@RestController
@RequestMapping("course")
public class CourseController {
	
	@Autowired
	private CourseDAO courseDAO;


	@DeleteMapping(value="{id}", produces="application/json")
	public Course removeCourse(@PathVariable("id") String code){
		return courseDAO.removeCourse(code);
	}
	
	@PutMapping(produces="application/json",consumes="application/json")
	public Course modifyCourse(@RequestBody Course course){
		return courseDAO.addOrModifyCourse(course);
	}
	
	@PostMapping(produces="application/json",consumes="application/json")
	public Course addNewCourse(@RequestBody Course course){
		return courseDAO.addOrModifyCourse(course);
	}
	
	@GetMapping(value="json/{low}/{high}", produces="application/json")
	public List<Course> getAllCoursesInPriceRange(@PathVariable("low") int min, @PathVariable("high") int max){
		return courseDAO.getAllCoursesForPriceRange(min, max);
	}
	
	@GetMapping(value="xml/all", produces="application/xml")
	public List<Course> getAllCoursesInXmlForm(){
		return courseDAO.getAllCourses();
		
	}
	@GetMapping(value="json/all", produces="application/json")
	public List<Course> getAllCoursesInJsonForm(){
		return courseDAO.getAllCourses();
	}
	@GetMapping(value="json/{id}",produces="application/json")
	public Course getSingleCourseAsJSON(@PathVariable("id") String code){
		Course course=courseDAO.getCourseById(code);
		return course;
	}
	
	@GetMapping(value="xml",produces="application/xml")
	public Course getSingleCourseAsXml(){
		Course course=courseDAO.getCourseById("c111");
		return course;
	}
	@GetMapping
	public String getSingleCourse(){
		System.out.println("Retrieving Single Course @@@@@@@@@@@@@@==>");
		Course course=courseDAO.getCourseById("c111");
		return course.toString();
	}
	
	@PostMapping
	public String addCourse(){
		return null;
	}
	@RequestMapping("check")
	public void show(){
		System.out.println("hello user=====================>");
	}
}
