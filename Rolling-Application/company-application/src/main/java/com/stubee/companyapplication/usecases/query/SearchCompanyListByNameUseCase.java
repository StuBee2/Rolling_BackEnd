package com.stubee.companyapplication.usecases.query;

import com.stubee.rollingdomains.common.model.dtos.request.PageRequest;
import com.stubee.applicationcommons.model.response.PageDataResponse;

import java.util.List;

public interface SearchCompanyListByNameUseCase {

    PageDataResponse<List<CompanyResponse>> get(String companyName, PageRequest pageRequest);

}