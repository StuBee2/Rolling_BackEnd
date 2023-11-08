package com.stubee.memberapplication.usecases.command;

import com.stubee.applicationcommons.annotations.AsyncEventListener;
import com.stubee.applicationcommons.annotations.Listener;
import com.stubee.rollingdomains.domain.member.events.MemberCertifiedEvent;
import com.stubee.rollingdomains.domain.member.services.ElevateMemberRoleService;
import lombok.RequiredArgsConstructor;

@Listener
@RequiredArgsConstructor
public class ElevateMemberRoleListener {

    private final ElevateMemberRoleService elevateMemberRoleService;

    @AsyncEventListener
    public void elevate(final MemberCertifiedEvent event) {
        elevateMemberRoleService.elevate();
    }

}