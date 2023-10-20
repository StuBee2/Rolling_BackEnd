package com.stubee.reviewapplication.usecases.query;

import com.stubee.applicationcommons.dtos.response.PageDataResponse;
import com.stubee.reviewapplication.usecases.query.response.StoryQueryByCompanyResponse;
import com.stubee.rollingdomains.common.dtos.request.PageRequest;

import java.util.List;

public interface QueryStoryInfoListByCompanyUseCase {

    PageDataResponse<List<StoryQueryByCompanyResponse>> get(Long companyId, PageRequest pageRequest);

}