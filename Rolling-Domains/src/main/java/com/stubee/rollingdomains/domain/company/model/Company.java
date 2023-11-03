package com.stubee.rollingdomains.domain.company.model;

import com.stubee.rollingdomains.common.error.Assert;
import com.stubee.rollingdomains.common.model.BaseId;
import com.stubee.rollingdomains.domain.company.consts.CompanyStatus;
import lombok.Builder;

public record Company (
        CompanyId companyId,
        CompanyDetails companyDetails,
        CompanyGrades companyGrades) {
    @Builder(builderClassName = "ExceptIdBuilder", builderMethodName = "ExceptIdBuilder")
    public Company(CompanyDetails companyDetails, CompanyGrades companyGrades) {
        this(null, companyDetails, companyGrades);
    }

    @Builder(builderClassName = "WithIdBuilder", builderMethodName = "WithIdBuilder")
    public Company {
        Assert.notNull(companyDetails, "CompanyDetails must not be null");
        Assert.notNull(companyGrades, "CompanyGrades must not be null");
    }

    public void isAuthor(final BaseId memberId) {
        companyDetails.registrantId().isEqual(memberId);
    }

    public Company update(final CompanyDetails companyDetails) {
        return new Company(companyId, companyDetails.cover(companyDetails), companyGrades);
    }

    public Company update(final CompanyGrades companyGrades) {
        return new Company(companyId, companyDetails, companyGrades);
    }

    public Company update(final CompanyStatus status) {
        return new Company(companyId, companyDetails.update(status), companyGrades);
    }
}