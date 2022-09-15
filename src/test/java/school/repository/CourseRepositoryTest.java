package school.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import school.entity.Course;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;


    //Test to create a new course
    @Test
    public  void createCourseTest(){
        Course course = Course.builder()
                .title("CSggtgt63")
                .credit(7)
                .build();

        courseRepository.save(course);
    }

    @Test
    public  void printAllCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("course :" + courses);
    }



}