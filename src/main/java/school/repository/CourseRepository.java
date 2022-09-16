package school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.entity.Course;

@Repository
public interface CourseRepository  extends JpaRepository<Course,Long> {

}
