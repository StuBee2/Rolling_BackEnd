package com.stubee.employmentapplication.usecases.query;

import com.stubee.employmentapplication.services.query.response.EmploymentQueryResponse;

import java.util.List;

public interface QueryMyEmploymentInfoListUseCase {

    List<EmploymentQueryResponse> get();

}