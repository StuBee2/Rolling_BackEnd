package com.stubee.rollingcore.domain.company.command;

import com.stubee.rollingcore.domain.company.model.CompanyId;
import lombok.Builder;

import java.util.UUID;

@Builder
public record DeleteCompanyCommand(
        CompanyId companyId
        ) {
    public static DeleteCompanyCommand toCommand(final UUID companyId) {
        return new DeleteCompanyCommand(CompanyId.create(companyId));
    }
}