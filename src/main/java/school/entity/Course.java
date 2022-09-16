package school.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
}
