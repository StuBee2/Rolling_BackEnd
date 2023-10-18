package com.stubee.rollingdomains.domain.company.model;

import com.stubee.rollingdomains.common.error.Assert;
import com.stubee.rollingdomains.domain.company.consts.CompanyStatus;
import lombok.Builder;

public record Company (
        CompanyId companyId,
        CompanyDetails companyDetails,
        CompanyGrades companyGrades,
        RegistrantId registrantId) {
    @Builder(builderClassName = "ExceptIdBuilder", builderMethodName = "ExceptIdBuilder")
    public Company(CompanyDetails companyDetails, CompanyGrades companyGrades, RegistrantId registrantId) {
        this(null, companyDetails, companyGrades, registrantId);
    }

    @Builder(builderClassName = "WithIdBuilder", builderMethodName = "WithIdBuilder")
    public Company {
        Assert.notNull(companyDetails, "CompanyDetails must not be null");
        Assert.notNull(companyGrades, "CompanyGrades must not be null");
        Assert.notNull(registrantId, "RegistrantId must not be null");
    }

    public Company updateGrades(final CompanyGrades companyGrades) {
        return new Company(companyId, companyDetails, companyGrades, registrantId);
    }

    public Company updateStatus(final boolean isAccepted) {
        return new Company(companyId, companyDetails.updateStatus(CompanyStatus.from(isAccepted)), companyGrades, registrantId);
    }
}