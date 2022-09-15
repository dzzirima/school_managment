package school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.entity.CourseMaterial;


@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long> {
}
