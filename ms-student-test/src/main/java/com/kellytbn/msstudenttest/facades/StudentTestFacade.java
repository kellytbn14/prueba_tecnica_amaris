package com.kellytbn.msstudenttest.facades;


import com.kellytbn.msstudenttest.dtos.CreateStudentTestRequest;
import com.kellytbn.msstudenttest.dtos.StudentTestDto;
import com.kellytbn.msstudenttest.services.StudentTestService;
import com.kellytbn.msstudenttest.utils.CustomUtils;
import com.kellytbn.msstudenttest.utils.mappers.StudentTestMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class StudentTestFacade {
    private final Logger log = LoggerFactory.getLogger(StudentTestFacade.class);
    private final StudentTestMapper mapper;
    private final StudentTestService service;

    public StudentTestFacade(StudentTestMapper mapper, StudentTestService service) {
        this.mapper = mapper;
        this.service = service;
    }

    public List<StudentTestDto> findAllStudents() {
        return mapper.toDto(service.findAll());
    }

    public StudentTestDto createStudent(CreateStudentTestRequest request) {
        CustomUtils.ValidateRequired(request.getEid());
        CustomUtils.ValidateRequired(request.getName());
        CustomUtils.ValidateRequired(request.getSpecialty());
        CustomUtils.ValidateRequired(request.getGrade());

        var student = StudentTestDto.builder()
                .eid(request.getEid())
                .name(request.getName())
                .specialty(request.getSpecialty())
                .grade(request.getGrade())
                .build();

        var studentSaved = service.save(mapper.toEntity(student));
        return mapper.toDto(studentSaved);
    }

    public StudentTestDto updateStudent(CreateStudentTestRequest request) {
        CustomUtils.ValidateRequired(request.getEid());

        var student = service.findByEid(request.getEid());

        student.setName(request.getName());
        student.setSpecialty(request.getSpecialty());
        student.setGrade(request.getGrade());

        var studentSaved = service.update(student);
        return mapper.toDto(studentSaved);
    }

    public void deleteStudent(Integer eid) {
        CustomUtils.ValidateRequired(eid);
        var student = service.findByEid(eid);
        service.delete(student.getId());
    }
}
