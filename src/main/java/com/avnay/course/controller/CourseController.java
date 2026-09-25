package com.avnay.course.controller;


import com.avnay.course.dto.Course;
import com.avnay.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

        @Autowired
        private CourseService courseService;

        @PostMapping("/add")
        public ResponseEntity<Course> addCourse(@RequestBody Course course){

        return new ResponseEntity<>(courseService.addCourse(course), HttpStatus.CREATED);
        //return ResponseEntity.ok(courseService.addCourse(course));
        // return ResponseEntity.created(URI.create("")).body(course);
        //return ResponseEntity.accepted().build();


    }

        @GetMapping("/get-all")
        public ResponseEntity<List<Course>> getAllCourses(){

        return ResponseEntity.ok(courseService.getAllCourses());

    }

        @GetMapping("/{id}")
        public ResponseEntity<Course> getCourseById(@PathVariable int id){

        return ResponseEntity.ok(courseService.getCourseById(id));

    }

        @PutMapping("/{id}")
        public ResponseEntity<?> updateCourseById(@PathVariable int id, @RequestBody Course course){

        boolean updated = courseService.updateCourse(id, course);

        if (updated){

            return ResponseEntity.ok(courseService.updateCourse(id, course));

        }else {
            return ResponseEntity.notFound().build();

        }



    }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteCourseById(@PathVariable int id){
        boolean deleted = courseService.deleteCourseById(id);

        if (deleted){

            return ResponseEntity.accepted().build();

        }else {
            return ResponseEntity.notFound().build();
        }

    }


}
