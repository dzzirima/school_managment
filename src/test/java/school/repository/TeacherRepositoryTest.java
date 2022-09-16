package school.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import school.entity.Course;
import school.entity.Teacher;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public  void saveTeacher(){

        Course course = Course.builder()
                .title("Introduction to monetory value")
                .credit(7)
                .build();
        Course java = Course.builder()
                .title("Java")
                .credit(85)
                .build();




        Teacher teacher = Teacher.builder()
                .firstName("Teacher Mbamire")
                .lastName("Teacher sirname")
                .courses(List.of(course, java))
                .build();

        teacherRepository.save(teacher);
    }

}