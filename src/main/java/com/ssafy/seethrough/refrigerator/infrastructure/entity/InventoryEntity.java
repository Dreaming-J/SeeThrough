package com.ssafy.seethrough.refrigerator.infrastructure.entity;

import com.ssafy.seethrough.member.infrastructure.entity.MemberEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
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
@Table(name = "refrigerator_inventory")
public class InventoryEntity {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "member_id")
    private String memberId;

    // TODO: 구성원 이름만 가져오기
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", insertable = false, updatable = false)
    private MemberEntity member;

    @Column(name = "food_category_id")
    private Integer foodCategoryId;

    // TODO: 식품명만 가져오기
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_category_id", insertable = false, updatable = false)
    private FoodCategoryEntity foodCategory;

    @Column(name = "inbound_at")
    private LocalDateTime inboundAt;

    @Column(name = "expiration_at")
    private LocalDateTime expirationAt;
}
