package com.stubee.employmentapplication.outports;

import com.stubee.employmentapplication.usecases.query.response.EmploymentQueryResponse;

import java.util.List;
import java.util.UUID;

public interface QueryEmploymentByIdPort {

    List<EmploymentQueryResponse> findInfoByEmployeeId(UUID employeeId);

}