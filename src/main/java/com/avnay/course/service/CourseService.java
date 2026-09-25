package com.avnay.course.service;


import com.avnay.course.dto.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class CourseService {

    private final List<Course> courseList = new ArrayList<>();

    public Course addCourse(Course course){

        courseList.add(course);
        return courseList.get(course.getId());


    }

    public List<Course> getAllCourses(){

        return courseList;

    }

    public Course getCourseById(int id){

        return courseList.stream()
                .filter(course -> course.getId() == id)
                .findFirst()
                .orElseThrow(()-> new RuntimeException("id not found!"));

    }

    public boolean updateCourse(int id, Course newCourse){

        Stream.ofNullable(getCourseById(id)).map(currentCourse-> {
            courseList.remove(currentCourse);
            courseList.add(newCourse);
            return true;
        });

        return false;
    }

    public boolean deleteCourseById(int id){

       /* Stream.ofNullable(getCourseById(id)).map(course -> {
            courseList.remove(course);
            return true;
        });*/

        return courseList.removeIf(course -> course.getId() == id);

        //return false;

    }

}

