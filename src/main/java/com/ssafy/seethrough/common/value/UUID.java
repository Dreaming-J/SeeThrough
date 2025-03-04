package com.ssafy.seethrough.common.value;

import com.ssafy.seethrough.member.exception.InvalidMemberIdException;

public record UUID(String value) {
    public UUID {
        validateMemberId(value);
    }

    private void validateMemberId(String value) {
        if (value == null || value.isEmpty()) {
            throw new InvalidMemberIdException("멤버 ID가 존재하지 않습니다.");
        }
    }

    public static UUID generateUUID() {
        return new UUID(java.util.UUID.randomUUID().toString());
    }
}
