package com.stubee.rollingapi.domain.company.request;

import com.stubee.companyapplication.usecases.command.RegisterCompanyCommand;
import jakarta.validation.constraints.NotBlank;

public record RegisterCompanyRequest(
        @NotBlank String name,
        @NotBlank String address,
        String addressEtc,
        @NotBlank String description,
        String imgUrl,
        Integer rgb) {
    public RegisterCompanyCommand toCommand() {
        return RegisterCompanyCommand.create(name, address, addressEtc, description, imgUrl, rgb);
    }
}