package com.stubee.reviewpersistence.adapters;

import com.stubee.reviewapplication.usecases.query.response.ReviewStatusResponse;
import com.stubee.rollingdomains.common.dtos.request.PageRequest;
import com.stubee.persistencecommons.annotations.Adapter;
import com.stubee.reviewapplication.outports.query.QueryReviewPort;
import com.stubee.reviewpersistence.mapper.ReviewMapper;
import com.stubee.reviewpersistence.repository.QueryReviewRepository;
import com.stubee.rollingdomains.domain.review.model.Review;
import com.stubee.reviewapplication.usecases.query.response.ReviewInfoResponse;
import com.stubee.reviewapplication.usecases.query.response.ReviewQueryResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Adapter
@RequiredArgsConstructor
public class QueryReviewAdapter implements QueryReviewPort {

    private final QueryReviewRepository queryReviewRepository;
    private final ReviewMapper reviewMapper;

    @Override
    public Optional<Review> findById(final UUID reviewId) {
        return Optional.ofNullable(reviewMapper.toDomain(queryReviewRepository.findById(reviewId)));
    }

    @Override
    public Optional<ReviewInfoResponse> findInfoById(final UUID reviewId) {
        return Optional.ofNullable(queryReviewRepository.findInfoById(reviewId));
    }

    @Override
    public List<ReviewQueryResponse> findByMemberId(final UUID memberId, PageRequest pageRequest) {
        return queryReviewRepository.findByMemberId(memberId, pageRequest);
    }

    @Override
    public List<ReviewInfoResponse> findByCompanyId(final UUID companyId, PageRequest pageRequest) {
        return queryReviewRepository.findByCompanyId(companyId, pageRequest);
    }

    @Override
    public ReviewStatusResponse findByMemberId(final UUID memberId) {
        return queryReviewRepository.findByMemberId(memberId);
    }

}