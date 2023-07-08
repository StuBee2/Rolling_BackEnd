package com.stubee.rollingapplication.domain.company.service;

import com.stubee.rollingapplication.common.annotation.CommandService;
import com.stubee.rollingapplication.domain.company.port.api.CommandCompanyUseCase;
import com.stubee.rollingapplication.domain.company.port.spi.CommandCompanyPort;
import com.stubee.rollingapplication.domain.member.port.spi.MemberSecurityPort;
 import com.stubee.rollingcore.domain.company.command.RegisterCompanyCommand;
import com.stubee.rollingcore.domain.company.model.Company;
import com.stubee.rollingcore.domain.company.model.CompanyId;
import com.stubee.rollingcore.domain.member.model.MemberId;
import lombok.RequiredArgsConstructor;

@CommandService
@RequiredArgsConstructor
public class CommandCompanyService implements CommandCompanyUseCase {

    private final MemberSecurityPort memberSecurityPort;
    private final CommandCompanyPort commandCompanyPort;

    @Override
    public Company register(RegisterCompanyCommand command) {
        return commandCompanyPort.create(createExceptCompanyId(command, memberSecurityPort.getCurrentMemberId()));
    }

    @Override
    public void update(Company company) {
        commandCompanyPort.update(company);
    }

    @Override
    public void delete(CompanyId companyId) {
        commandCompanyPort.deleteById(companyId);
    }

    private Company createExceptCompanyId(RegisterCompanyCommand command, MemberId memberId) {
        return Company.create(
                command.name(), command.address(), command.description(), command.imgUrl(), memberId);
    }

}