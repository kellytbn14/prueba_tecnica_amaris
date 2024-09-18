package com.kellytbn.msstudenttest.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class CreateStudentTestRequest {
    private Integer eid;
    private String name;
    private String specialty;
    private String grade;
}
