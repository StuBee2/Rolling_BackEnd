package com.stubee.companyapplication.services;

import com.stubee.applicationcommons.annotations.QueryService;
import com.stubee.applicationcommons.ports.member.LoadCurrentMemberPort;
import com.stubee.companyapplication.outports.QueryCompanyPort;
import com.stubee.companyapplication.usecases.query.QueryCompanyListByMemberUseCase;
import com.stubee.applicationcommons.dtos.request.PageRequest;
import com.stubee.applicationcommons.dtos.response.PageDataResponse;
import com.stubee.rollingdomains.domain.company.model.Company;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@QueryService
@RequiredArgsConstructor
public class QueryCompanyByMemberService implements QueryCompanyListByMemberUseCase {

    private final LoadCurrentMemberPort memberSecurityPort;
    private final QueryCompanyPort queryCompanyPort;

    @Override
    public PageDataResponse<List<Company>> getMy(PageRequest pageRequest) {
        return getByMemberId(memberSecurityPort.getCurrentMemberId().getId(), pageRequest);
    }

    @Override
    public PageDataResponse<List<Company>> getByMemberId(final UUID memberId, PageRequest pageRequest) {
        return PageDataResponse.create(queryCompanyPort.findByRegistrantId(memberId, pageRequest));
    }

}