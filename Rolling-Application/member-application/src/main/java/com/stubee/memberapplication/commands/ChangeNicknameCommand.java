package com.stubee.memberapplication.commands;

public record ChangeNicknameCommand(
        String nickName) {
    public static ChangeNicknameCommand create(final String nickName) {
        return new ChangeNicknameCommand(nickName);
    }
}