package com.stubee.memberapplication.services.query;

import com.stubee.applicationcommons.annotations.QueryService;
import com.stubee.memberapplication.usecases.QueryMyInfoUseCase;
import com.stubee.rollingdomains.domain.member.model.Member;
import com.stubee.rollingdomains.domain.member.ports.LoadCurrentMemberPort;
import lombok.RequiredArgsConstructor;

@QueryService
@RequiredArgsConstructor
public class QueryMyInfoService implements QueryMyInfoUseCase {

    private final LoadCurrentMemberPort loadCurrentMemberPort;

    @Override
    public Member get() {
        return loadCurrentMemberPort.getMember();
    }

}