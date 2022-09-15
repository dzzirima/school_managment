package school.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import school.entity.Course;
import school.entity.CourseMaterial;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    private CourseRepositoryTest courseRepositoryTest;

    //we want to create a course with a course material
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){

        Course course = Course.builder()
                .title("Introduction to Maths")
                .credit(7)
                .build();
        CourseMaterial courseMaterial = CourseMaterial
                .builder()
                .url("www.google.com")
                .course(course)
                .build();

    courseMaterialRepository.save(courseMaterial);


    }

    @Test
     public  void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println("Course Materials = :" + courseMaterials);
    }


}