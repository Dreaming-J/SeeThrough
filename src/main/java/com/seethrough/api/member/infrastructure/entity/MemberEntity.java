package com.seethrough.api.member.infrastructure.entity;

import com.seethrough.api.member.infrastructure.converter.JsonArrayConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "members")
public class MemberEntity {
    @Id
    @Column(name = "id", length = 36, nullable = false)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_identified")
    private Boolean isIdentified;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "recognition_times")
    private Integer recognitionTimes;

    @Column(name = "significants", columnDefinition = "JSON")
    @Convert(converter = JsonArrayConverter.class)
    private List<String> significants;
}
