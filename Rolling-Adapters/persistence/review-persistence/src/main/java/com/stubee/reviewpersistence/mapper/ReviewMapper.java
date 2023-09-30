package com.stubee.reviewpersistence.mapper;

import com.stubee.persistencecommons.annotations.DomainObjectMapper;
import com.stubee.persistencecommons.entity.ReviewEntity;
import com.stubee.rollingdomains.common.model.Grades;
import com.stubee.rollingdomains.domain.company.model.CompanyId;
import com.stubee.rollingdomains.domain.review.model.AuthorId;
import com.stubee.rollingdomains.domain.review.model.Review;
import com.stubee.rollingdomains.domain.review.model.ReviewDetails;
import com.stubee.rollingdomains.domain.review.model.ReviewId;

@DomainObjectMapper
public class ReviewMapper implements com.stubee.persistencecommons.mapper.DomainObjectMapper<ReviewEntity, Review> {

    @Override
    public ReviewEntity toEntity(final Review domain) {
        return ReviewEntity.builder()
                .content(domain.reviewDetails().content())
                .position(domain.reviewDetails().position())
                .careerPath(domain.reviewDetails().careerPath())
                .totalGrade(domain.reviewGrades().totalGrade())
                .salaryAndBenefits(domain.reviewGrades().salaryAndBenefits())
                .workLifeBalance(domain.reviewGrades().workLifeBalance())
                .organizationalCulture(domain.reviewGrades().organizationalCulture())
                .careerAdvancement(domain.reviewGrades().careerAdvancement())
                .memberId(domain.authorId().getId())
                .companyId(domain.companyId().getId())
                .build();
    }

    @Override
    public Review toDomain(final ReviewEntity entity) {
        if(entity==null) {
            return null;
        }

        return Review.WithIdBuilder()
                .reviewId(ReviewId.of(entity.getId()))
                .reviewDetails(reviewDetails(entity))
                .reviewGrades(reviewGrades(entity))
                .authorId(AuthorId.of(entity.getMemberId()))
                .companyId(CompanyId.of(entity.getCompanyId()))
                .build();
    }

    private ReviewDetails reviewDetails(final ReviewEntity entity) {
        return ReviewDetails.WithDateBuilder()
                .content(entity.getContent())
                .position(entity.getPosition())
                .careerPath(entity.getCareerPath())
                .createdAt(entity.getCreatedAt())
                .modifiedAt(entity.getModifiedAt())
                .build();
    }

    private Grades reviewGrades(final ReviewEntity entity) {
        return Grades.WithTotalBuilder()
                .totalGrade(entity.getTotalGrade())
                .salaryAndBenefits(entity.getSalaryAndBenefits())
                .workLifeBalance(entity.getWorkLifeBalance())
                .organizationalCulture(entity.getOrganizationalCulture())
                .careerAdvancement(entity.getCareerAdvancement())
                .build();
    }

}