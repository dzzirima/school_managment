package school.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import school.entity.Guardian;
import school.entity.Student;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private  StudentRepository studentRepository;
    @Test
    public void  saveStudent(){
        Student student =  Student.builder()
                .emailId("davidtzirima a@gmail.com ")
                .firstName("David")
                .lastName("Zirima")
//                .guardianName("Zirirma")
//                .getGuardianEmail("chiddi")
//                .getGuardianMobile("676y76767")
                .build();
        studentRepository.save(student);

    }

    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder().build();

        Student student = Student.builder()
                .firstName("firstName")
                .lastName("Gafa")
                .emailId("gafa@email.com")
                .guardian(guardian )
                .build();

        studentRepository.save(student);


    }


  @Test  /* function to test  creation of  a  student**/
public void getStudentByName() {
      List<Student> students = studentRepository.findByFirstName("David");
      System.out.println("Students :" +  students);

}

    @Test  /* function to get the stident name containing**/
    public void getStudentByNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("id");
        System.out.println("Students :" +  students);

    }

    @Test
    public void printStudentBasedOnGuardian(){
        List<Student> students = studentRepository.findByGuardianName("");

    }

    //testing the native Query
    @Test
    public  void printgetstudentByEmaiNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("davidtzirima@gmail.com");
        System.out.println(student);

    }
/**********************************upDating tests **************************/
@Test
public void updateStudentNameByEmailIdTest(){
    studentRepository.updateStudentNameByEmailID(
            "newName",
            "davidtzirima@gmail.com"
    );

}






}