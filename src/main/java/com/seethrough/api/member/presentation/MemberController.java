package com.seethrough.api.member.presentation;

import com.seethrough.api.common.pagination.SliceResponseDto;
import com.seethrough.api.member.application.service.MemberService;
import com.seethrough.api.member.presentation.dto.response.MemberLogResponse;
import com.seethrough.api.member.presentation.dto.response.MemberResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "구성원 관리", description = "구성원 정보를 관리하는 API")
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    @Operation(
        summary = "구성원 목록 조회",
        description = "시스템에 등록된 모든 사용자의 목록을 페이지네이션을 적용하여 반환합니다."
    )
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
    @Operation(
        summary = "특정 구성원 조회",
        description = "UUID로 작성된 구성원의 키를 활용해 시스템에 등록된 특정 사용자를 반환합니다."
    )
    public ResponseEntity<MemberResponse> getMemberDetail(@PathVariable String memberId) {
        MemberResponse response = memberService.getMemberDetail(memberId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/log")
    @Operation(
        summary = "구성원 로그 목록 조회",
        description = "시스템에 등록된 모든 사용자의 로그 목록을 페이지네이션을 적용하여 반환합니다."
    )
    public ResponseEntity<SliceResponseDto<MemberLogResponse>> getMemberLogList(
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size,
        @RequestParam(defaultValue = "createdAt") String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDirection
    ) {
        SliceResponseDto<MemberLogResponse> response = memberService.getMemberLogList(page, size, sortBy, sortDirection);

        return ResponseEntity.ok(response);
    }
}
