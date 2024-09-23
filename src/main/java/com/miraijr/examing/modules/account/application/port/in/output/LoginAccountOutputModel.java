package com.miraijr.examing.modules.account.application.port.in.output;

public record LoginAccountOutputModel(
    String accessToken,
    String refreshToken) {
}
