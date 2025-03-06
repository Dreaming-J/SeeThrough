package com.seethrough.api.member.application.service;

import com.seethrough.api.common.pagination.SliceRequestDto;
import com.seethrough.api.common.pagination.SliceResponseDto;
import com.seethrough.api.member.application.mapper.MemberDtoMapper;
import com.seethrough.api.member.domain.Member;
import com.seethrough.api.member.domain.MemberLog;
import com.seethrough.api.member.domain.MemberRepository;
import com.seethrough.api.common.value.UUID;
import com.seethrough.api.member.exception.MemberNotFoundException;
import com.seethrough.api.member.presentation.dto.response.MemberLogResponse;
import com.seethrough.api.member.presentation.dto.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberDtoMapper memberDtoMapper;

    /**
     * 페이지네이션에 맞게 구성원의 리스트 반환합니다.
     *
     * 최대 10명의 구성원을 반환하며 Slice 형식으로 다음 값이 있는지를 SliceInfo에 함께 반환
     * @param page
     * @param size
     * @param sortBy
     * @param sortDirection
     * @return
     */
    public SliceResponseDto<MemberResponse> getMemberList(
        Integer page, Integer size, String sortBy, String sortDirection
    ) {
        // Slice 값 생성
        SliceRequestDto sliceRequestDto = SliceRequestDto.builder()
            .page(page)
            .size(size)
            .sortBy(sortBy)
            .sortDirection(sortDirection)
            .build();

        // Slice의 조건에 맞는 구성원을 가져옵니다.
        Slice<Member> members = memberRepository.findMembers(sliceRequestDto.toPageable());

        // 페이지네이션 메타 데이터와 함께 반환합니다.
        return SliceResponseDto.of(members.map(memberDtoMapper::toResponse));
    }

    /**
     * 구성원의 Detail 정보 반환
     *
     * @param memberId
     * @return
     */
    public MemberResponse getMemberDetail(String memberId) {
        UUID memberIdObj = new UUID(memberId);



        Member member = memberRepository.findByMemberId(memberIdObj)
            .orElseThrow(() ->
                new MemberNotFoundException("구성원을 찾을 수 없습니다.")
            );

        return memberDtoMapper.toResponse(member);
    }

    /**
     * 페이지네이션에 맞게 구성원 로그의 리스트 반환합니다.
     *
     * 최대 10개의 로그를 반환하며 Slice 형식으로 다음 값이 있는지를 SliceInfo에 함께 반환
     * @param page
     * @param size
     * @param sortBy
     * @param sortDirection
     * @return
     */
    public SliceResponseDto<MemberLogResponse> getMemberLogList(
        Integer page, Integer size, String sortBy, String sortDirection
    ) {
        // Slice 값 생성
        SliceRequestDto sliceRequestDto = SliceRequestDto.builder()
            .page(page)
            .size(size)
            .sortBy(sortBy)
            .sortDirection(sortDirection)
            .build();

        // Slice의 조건에 맞는 구성원을 가져옵니다.
        Slice<MemberLog> memberLogs = memberRepository.findMemberLogs(sliceRequestDto.toPageable());

        // 페이지네이션 메타 데이터와 함께 반환합니다.
        return SliceResponseDto.of(memberLogs.map(memberDtoMapper::toResponse));
    }
}
