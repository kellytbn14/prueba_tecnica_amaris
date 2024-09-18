package com.kellytbn.msstudenttest.repositories;

import com.kellytbn.msstudenttest.entities.StudentTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentTestRepository extends JpaRepository<StudentTest, Long> {

    Optional<StudentTest> findByEid(Integer eid);
}
