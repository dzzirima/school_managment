package school.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import school.entity.Student;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String name);

    //function to get the embeeded document
    List<Student> findByGuardianName(String guardian);


    //Native Queries
    @Query(
            value = "SELECT *  FROM tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    public Student getStudentByEmailAddressNative(String emailId);



    //Native Named Params
    @Query(
            value = "SELECT *  FROM tbl_student s where s.email_address = :emailId",
            nativeQuery = true
    )
    public Student getStudentByEmailAddressNativeNamedParam(
            @Param("emailId") String emailId
    );


    /************************Updating queries ***************************/
    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address= ?2",
            nativeQuery = true
    )
    public  int updateStudentNameByEmailID(String firstName, String emailId);

}
