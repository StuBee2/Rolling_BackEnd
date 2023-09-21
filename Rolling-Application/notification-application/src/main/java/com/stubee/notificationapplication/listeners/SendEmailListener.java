package com.stubee.notificationapplication.listeners;

import com.stubee.applicationcommons.annotations.AsyncTransactionalListener;
import com.stubee.applicationcommons.annotations.Listener;
import com.stubee.notificationapplication.outports.SendEmailPort;
import com.stubee.rollingdomains.domain.member.events.MemberRegisteredEvent;
import lombok.RequiredArgsConstructor;

@Listener
@RequiredArgsConstructor
public class SendEmailListener {

    private final SendEmailPort sendEmailPort;

    @AsyncTransactionalListener
    public void sendWelcomeEmail(final MemberRegisteredEvent event) {
        sendEmailPort.sendWelcome(event.receiverEmail());
    }

}