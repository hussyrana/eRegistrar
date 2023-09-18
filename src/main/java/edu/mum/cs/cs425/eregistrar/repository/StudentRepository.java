package edu.mum.cs.cs425.eregistrar.repository;

import edu.mum.cs.cs425.eregistrar.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query("SELECT s FROM Student s WHERE " +
            "CAST(s.studentId AS string) LIKE :search or s.studentNumber LIKE :search or " +
            "s.firstName LIKE CONCAT('%', :search, '%') or s.middleName LIKE CONCAT('%', :search, '%') or s.lastName LIKE CONCAT('%', :search, '%') or " +
            "CONCAT(s.firstName, ' ', s.middleName, ' ',s.lastName) LIKE CONCAT('%', :search, '%') or " +
            "CONCAT(s.firstName, ' ',s.lastName) LIKE CONCAT('%', :search, '%') or " +
            "CAST(s.cgpa AS string) LIKE :search or s.enrollmentDate LIKE CONCAT('%', :search, '%') or s.isInternational LIKE :search")
    Collection<Student> findAllBySearchString(@Param("search") String search);
}
