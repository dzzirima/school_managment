package school.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"

    )
    private Long courseId;
    private String title;
    private Integer credit;


    @OneToOne(
            fetch = FetchType.EAGER,
            mappedBy = "course"

    )
    private  CourseMaterial courseMaterial;
    /**
     * the mapped is used when the relationship is already defined
     * in another table
     * */

    @ManyToOne(
            cascade= CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private  Teacher teacher;


    /**
     * many to many relationship
     * we define the table  name where we are joining the 2 tables
     * define the 2 rows where the joining is going to happen
     * */

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_course_map",
            joinColumns = @JoinColumn(
                    ///this is for db
                    name = "course_id",
                    //this is the field of class you have already defined
                    referencedColumnName = "courseId"
            ),

            /// this will be for the student
            inverseJoinColumns =  @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
                    )
    )

    private List<Student>  students;

    public void addStudents(Student student){
        if(students == null) students = new ArrayList<>();
        students.add(student);
    }
}
