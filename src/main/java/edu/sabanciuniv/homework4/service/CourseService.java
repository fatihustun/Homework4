package edu.sabanciuniv.homework4.service;


import edu.sabanciuniv.homework4.model.Course;
import edu.sabanciuniv.homework4.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public Course addNewCourse(Course course){
        return courseRepository.save(course);
    }



    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Course updateCourse(Course course){
        return courseRepository.save(course);
    }

    public void deleteCourse(Course course){
        courseRepository.delete(course);
    }

    public void deleteAllCourse(){
        courseRepository.deleteAll();
    }

    public Optional<Course> findById(Integer id){
        return courseRepository.findById(id);
    }

}
