package com.stubee.memberapplication.services;

import com.stubee.applicationcommons.annotations.AsyncEventListener;
import com.stubee.applicationcommons.annotations.DomainService;
import com.stubee.memberapplication.outports.CheckNicknameDuplicationPort;
import com.stubee.memberapplication.outports.CommandMemberPort;
import com.stubee.memberapplication.outports.QueryMemberPort;
import com.stubee.rollingdomains.domain.member.events.MemberCertifiedEvent;
import com.stubee.rollingdomains.domain.member.exception.DuplicatedNicknameException;
import com.stubee.rollingdomains.domain.member.exception.MemberNotFoundException;
import com.stubee.rollingdomains.domain.member.model.Member;
import com.stubee.applicationcommons.ports.GetCurrentMemberPort;
import com.stubee.rollingdomains.domain.member.services.ChangeNicknameService;
import com.stubee.rollingdomains.domain.member.services.ElevateMemberRoleService;
import com.stubee.rollingdomains.domain.member.services.GetMemberByIdService;
import com.stubee.rollingdomains.domain.member.services.commands.ChangeNicknameCommand;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@DomainService
@RequiredArgsConstructor
public class MemberDomainService implements ChangeNicknameService, ElevateMemberRoleService, GetMemberByIdService {

    private final CommandMemberPort commandMemberPort;
    private final QueryMemberPort queryMemberPort;
    private final CheckNicknameDuplicationPort checkNicknameDuplicationPort;
    private final GetCurrentMemberPort getCurrentMemberPort;

    @Override
    public Member getById(final UUID id) {
        return queryMemberPort.findById(id)
                .orElseThrow(() -> MemberNotFoundException.EXCEPTION);
    }

    @Override
    public void change(final ChangeNicknameCommand command) {
        this.checkByNickname(command.nickname());

        commandMemberPort.saveWithId(this.getMember().changeNickname(command.nickname()));
    }

    private void checkByNickname(final String nickname) {
        if(checkNicknameDuplicationPort.check(nickname)) {
            throw DuplicatedNicknameException.EXCEPTION;
        }
    }

    @Override
    @AsyncEventListener
    public void elevate(final MemberCertifiedEvent event) {
        commandMemberPort.saveWithId(this.getMember().elevateToMember());
    }

    private Member getMember() {
        return getCurrentMemberPort.getMember();
    }

}