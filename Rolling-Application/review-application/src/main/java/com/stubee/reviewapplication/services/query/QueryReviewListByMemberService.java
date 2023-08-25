package com.stubee.reviewapplication.services.query;

import com.stubee.applicationcommons.annotations.QueryService;
import com.stubee.reviewapplication.outports.QueryReviewPort;
import com.stubee.reviewapplication.usecases.query.QueryReviewListByMemberUseCase;
import com.stubee.applicationcommons.dtos.request.PageRequest;
import com.stubee.applicationcommons.dtos.response.PageDataResponse;
import com.stubee.reviewapplication.services.query.response.ReviewQueryResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@QueryService
@RequiredArgsConstructor
public class QueryReviewListByMemberService implements QueryReviewListByMemberUseCase {

    private final QueryReviewPort queryReviewPort;

    @Override
    public PageDataResponse<List<ReviewQueryResponse>> get(final UUID memberId, PageRequest pageRequest) {
        return PageDataResponse.create(queryReviewPort.findByMemberId(memberId, pageRequest));
    }

}