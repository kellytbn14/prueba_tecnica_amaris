package com.kellytbn.msstudenttest.utils.mappers;


import com.kellytbn.msstudenttest.dtos.StudentTestDto;
import com.kellytbn.msstudenttest.entities.StudentTest;
import com.kellytbn.msstudenttest.utils.EntityMapper;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface StudentTestMapper extends EntityMapper<StudentTestDto, StudentTest> {

}
