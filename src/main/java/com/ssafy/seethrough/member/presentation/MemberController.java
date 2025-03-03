package com.ssafy.seethrough.member.presentation;

import com.ssafy.seethrough.common.pagination.SliceResponseDto;
import com.ssafy.seethrough.member.application.service.MemberService;
import com.ssafy.seethrough.member.presentation.dto.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/family")
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<SliceResponseDto<MemberResponse>> getMemberList(
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size,
        @RequestParam(defaultValue = "createdAt") String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDirection
    ) {
        SliceResponseDto<MemberResponse> responseList = memberService.getMemberList(page, size, sortBy, sortDirection);

        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResponse> getMemberDetail(@PathVariable String memberId) {
        MemberResponse response = memberService.getMemberDetail(memberId);

        return ResponseEntity.ok(response);
    }
}
