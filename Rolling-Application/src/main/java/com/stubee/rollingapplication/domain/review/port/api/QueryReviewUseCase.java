package com.stubee.rollingapplication.domain.review.port.api;

import com.stubee.rollingcore.common.dto.response.PageDataResponse;
import com.stubee.rollingcore.common.dto.request.PageRequest;
import com.stubee.rollingcore.domain.review.dto.response.ReviewInfoResponse;
import com.stubee.rollingcore.domain.review.dto.response.ReviewQueryResponse;

import java.util.List;
import java.util.UUID;

public interface QueryReviewUseCase {

    ReviewInfoResponse getInfo(UUID reviewId);

    PageDataResponse<List<ReviewQueryResponse>> getMy(PageRequest pageRequest);

    PageDataResponse<List<ReviewQueryResponse>> getByMemberId(UUID memberId, PageRequest pageRequest);

    PageDataResponse<List<ReviewInfoResponse>> getByCompanyId(UUID companyId, PageRequest pageRequest);

}