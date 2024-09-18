package com.kellytbn.msstudenttest.services;


import com.kellytbn.msstudenttest.entities.StudentTest;
import com.kellytbn.msstudenttest.repositories.StudentTestRepository;
import com.kellytbn.msstudenttest.utils.MessageResponse;
import com.kellytbn.msstudenttest.utils.handlers.exceptions.DataNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class StudentTestService {
    private final StudentTestRepository repository;

    public StudentTestService(StudentTestRepository repository) {
        this.repository = repository;
    }

    public StudentTest save(StudentTest studentTest) {
        studentTest.setCreateDate(LocalDateTime.now());
        studentTest.setLastUpdate(LocalDateTime.now());
        return repository.save(studentTest);
    }

    public StudentTest update(StudentTest studentTest) {
        studentTest.setLastUpdate(LocalDateTime.now());
        return repository.save(studentTest);
    }

    public void delete(Long idStudentTest) {
        repository.deleteById(idStudentTest);
    }

    public StudentTest findByEid(Integer eid) {
        return repository.findByEid(eid).orElseThrow(() ->
                new DataNotFoundException(MessageResponse.STUDENT_NOT_FOUND_EXCEPTION));
    }

    public List<StudentTest> findAll() {
        return repository.findAll();
    }
}