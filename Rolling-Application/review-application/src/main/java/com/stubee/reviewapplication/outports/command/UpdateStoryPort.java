package com.stubee.reviewapplication.outports.command;

import com.stubee.rollingdomains.domain.story.model.Story;

public interface UpdateStoryPort {

    void update(Story story);

}