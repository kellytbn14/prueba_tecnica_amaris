package com.kellytbn.msstudenttest.controllers;

import com.kellytbn.msstudenttest.dtos.CreateStudentTestRequest;
import com.kellytbn.msstudenttest.dtos.StudentTestDto;
import com.kellytbn.msstudenttest.facades.StudentTestFacade;
import com.kellytbn.msstudenttest.utils.StandardResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-test")
public class StudentTestController {

    private final StudentTestFacade facade;

    public StudentTestController(StudentTestFacade facade) {
        this.facade = facade;
    }

    @GetMapping("")
    @Operation(summary = "Search students")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data found successfully"),
            @ApiResponse(responseCode = "400", description = "The request is invalid"),
            @ApiResponse(responseCode = "500", description = "Internal error processing response"),
    })
    public ResponseEntity<StandardResponse<List<StudentTestDto>>> findAllStudents() {
        var result = facade.findAllStudents();
        return ResponseEntity.ok(new StandardResponse<>(result));
    }

    @PostMapping("/create-student")
    @Operation(summary = "Create a student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data inserted successfully"),
            @ApiResponse(responseCode = "400", description = "The request is invalid"),
            @ApiResponse(responseCode = "500", description = "Internal error processing response"),
    })
    public ResponseEntity<StandardResponse<StudentTestDto>> createStudent(@RequestBody CreateStudentTestRequest request) {
        var result = facade.createStudent(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new StandardResponse<>(result));
    }

    @PutMapping("/update-student")
    @Operation(summary = "Update a student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data updated successfully"),
            @ApiResponse(responseCode = "400", description = "The request is invalid"),
            @ApiResponse(responseCode = "500", description = "Internal error processing response"),
    })
    public ResponseEntity<StandardResponse<StudentTestDto>> updateStudent(@RequestBody CreateStudentTestRequest request) {
        var result = facade.updateStudent(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new StandardResponse<>(result));
    }

    @DeleteMapping("/delete-student/{eid}")
    @Operation(summary = "Delete a student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data removed successfully"),
            @ApiResponse(responseCode = "400", description = "The request is invalid"),
            @ApiResponse(responseCode = "500", description = "Internal error processing response"),
    })
    public ResponseEntity<StandardResponse<Void>> deleteStudent(@PathVariable Integer eid) {
        facade.deleteStudent(eid);
        return ResponseEntity.ok(new StandardResponse<>(null));
    }
}