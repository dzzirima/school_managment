package school.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import school.entity.Course;
import school.entity.Teacher;

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

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher
                .builder()
                .firstName("new teacher")
                .lastName("Last teacher")
                .build();


        Course course = Course
                .builder()
                .title("Python")
                .credit(5)
                .teacher(teacher)
                .build();

        courseRepository.save(course);

    }

    @Test
    public void findAllPagination(){

        /***
         * first we need to create a pageable object
         */

        Pageable firstPageWithThreeRecords  = PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords  = PageRequest.of(1,2);

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords)
                .getContent();


        Long totalElements  = courseRepository.findAll(secondPageWithTwoRecords)
                        .getTotalElements();


        System.out.println("Total elements :"+ totalElements);
//
//        System.out.println("Courses  :" + courses.toString());

    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(0,2, Sort.by("title"));

        Pageable sortByCreditDesc = PageRequest.of(
                0,
                2,
                Sort.by("credit")
                        .descending()
        );
        List<Course> courses = courseRepository.findAll(sortByCreditDesc).getContent();

        System.out.println("Courses  +" + courses);
    }

}