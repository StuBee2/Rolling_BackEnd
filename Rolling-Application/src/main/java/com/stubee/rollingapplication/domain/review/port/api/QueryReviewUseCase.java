package com.stubee.rollingapplication.domain.review.port.api;

import com.stubee.rollingcore.common.dto.PageDto;
import com.stubee.rollingcore.domain.review.dto.response.ReviewInfoResponse;
import com.stubee.rollingcore.domain.review.dto.response.ReviewQueryResponse;

import java.util.List;
import java.util.UUID;

public interface QueryReviewUseCase {

    ReviewInfoResponse getInfo(UUID reviewId);

    List<ReviewQueryResponse> getMy(PageDto pageDto);

    List<ReviewQueryResponse> getByMemberId(UUID memberId, PageDto pageDto);

    List<ReviewInfoResponse> getByCompanyId(UUID companyId, PageDto pageDto);

}