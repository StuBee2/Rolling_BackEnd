package com.stubee.rollingdomains.domain.company.model;

import com.stubee.rollingdomains.common.error.Assert;
import com.stubee.rollingdomains.domain.company.consts.CompanyStatus;
import lombok.Builder;

import java.time.LocalDateTime;

public record CompanyDetails(
        RegistrantId registrantId,
        String name,
        String description,
        Address companyAddress,
        CompanyLogo companyLogo,
        CompanyStatus companyStatus,
        LocalDateTime createdAt,
        LocalDateTime modifiedAt) {
    @Builder(builderClassName = "ExceptDateBuilder", builderMethodName = "ExceptDateBuilder")
    public CompanyDetails(RegistrantId registrantId, String name, Address companyAddress, String description, CompanyLogo companyLogo) {
        this(registrantId, name, description, companyAddress, companyLogo, CompanyStatus.ACCEPTED, null, null);
    }

    @Builder(builderClassName = "WithDateBuilder", builderMethodName = "WithDateBuilder")
    public CompanyDetails {
        Assert.notNull(registrantId, "RegistrantId must not be null");
        Assert.notNull(name, "CompanyName must not be null");
        Assert.notNull(companyAddress, "CompanyAddress must not be null");
        Assert.notNull(description, "Description must not be null");
        Assert.notNull(companyStatus, "CompanyStatus must not be null");
    }

    CompanyDetails cover(final CompanyDetails companyDetails) {
        Assert.notNull(companyDetails.name, "Name must not be null");
        Assert.notNull(companyDetails.companyAddress, "CompanyAddress must not be null");
        Assert.notNull(companyDetails.description, "Description must not be null");

        return new CompanyDetails(registrantId, companyDetails.name, companyDetails.description, companyDetails.companyAddress,
                companyDetails.companyLogo, companyStatus, createdAt, modifiedAt);
    }

    CompanyDetails update(final CompanyStatus companyStatus) {
        return new CompanyDetails(registrantId, name, description, companyAddress, companyLogo, companyStatus, createdAt, modifiedAt);
    }

}