package com.ssafy.seethrough.member.domain.value;

import com.ssafy.seethrough.member.exception.InvalidMemberIdException;
import lombok.Value;

@Value
public class MemberId {
    String value;

    public MemberId(String value) {
        validateMemberId(value);
        this.value = value;
    }

    private void validateMemberId(String value) {
        if (value == null || value.isEmpty()) {
            throw new InvalidMemberIdException("멤버 ID가 존재하지 않습니다.");
        }
    }
}
