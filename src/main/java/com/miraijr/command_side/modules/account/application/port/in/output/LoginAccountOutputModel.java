package com.miraijr.command_side.modules.account.application.port.in.output;

public record LoginAccountOutputModel(
    String accessToken,
    String refreshToken) {
}
