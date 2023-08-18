package com.stubee.employmentpersistence.adapters;

import com.stubee.employmentapplication.outports.QueryEmploymentPort;
import com.stubee.employmentpersistence.repository.QueryEmploymentRepository;
import com.stubee.persistencecommons.commons.annotations.Adapter;
import com.stubee.rollingdomains.domain.employment.response.EmploymentQueryResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;


@Adapter
@RequiredArgsConstructor
public class QueryEmploymentAdapter implements QueryEmploymentPort {

    private final QueryEmploymentRepository queryEmploymentRepository;

    @Override
    public List<EmploymentQueryResponse> findInfoByEmployeeId(final UUID employeeId) {
        return queryEmploymentRepository.findInfoByEmployeeId(employeeId);
    }

}