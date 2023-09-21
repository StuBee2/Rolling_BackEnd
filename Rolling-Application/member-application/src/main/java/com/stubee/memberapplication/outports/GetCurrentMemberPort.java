package com.stubee.memberapplication.outports;

import com.stubee.rollingdomains.domain.member.model.Member;
import com.stubee.rollingdomains.domain.member.model.MemberId;

public interface GetCurrentMemberPort {

    Member getMember();

    MemberId getMemberId();

}