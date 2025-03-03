USE db;

DROP TABLE IF EXISTS refrigerator_logs;
DROP TABLE IF EXISTS refrigerator_inventory;
DROP TABLE IF EXISTS food_categories;
DROP TABLE IF EXISTS recognition_logs;
DROP TABLE IF EXISTS member_images;
DROP TABLE IF EXISTS member;


-- 사용자 정보 테이블
CREATE TABLE member (
    id VARCHAR(36) NOT NULL COMMENT 'UUID',
    name VARCHAR(100) NULL DEFAULT 'Undefined' COMMENT '랜덤 닉네임',
    is_identified TINYINT(1) NOT NULL DEFAULT FALSE COMMENT '구성원 등록 여부',
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    recognition_times INTEGER NOT NULL DEFAULT 0,
    significant JSON NULL COMMENT '특이사항을 JSON배열 형식으로 저장',

    PRIMARY KEY (id)
);

-- 얼굴 이미지 테이블
CREATE TABLE member_images (
    id VARCHAR(36) NOT NULL COMMENT 'UUID',
    member_id VARCHAR(36) NOT NULL COMMENT 'UUID',
    image_url TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY (id),
    FOREIGN KEY (member_id) REFERENCES member(id)
);

-- 얼굴 인식 로그 테이블
CREATE TABLE recognition_logs (
    id INTEGER NOT NULL AUTO_INCREMENT,
    member_id VARCHAR(36) NOT NULL COMMENT 'UUID',
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY (id),
    FOREIGN KEY (member_id) REFERENCES member(id)
);

-- 식품 카테고리 테이블
CREATE TABLE food_categories (
    id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,

    PRIMARY KEY (id)
);

-- 냉장고 재고 테이블
CREATE TABLE refrigerator_inventory (
    id VARCHAR(36) NOT NULL COMMENT 'UUID',
    member_id VARCHAR(36) NOT NULL COMMENT 'UUID',
    food_categories_id INTEGER NOT NULL,
    inbound_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    expiration_at TIMESTAMP NULL COMMENT '소비 기한',

    PRIMARY KEY (id),
    FOREIGN KEY (member_id) REFERENCES member (id),
    FOREIGN KEY (food_categories_id) REFERENCES food_categories (id)
);

-- 냉장고 입출고 로그 테이블
CREATE TABLE refrigerator_logs (
    id INTEGER NOT NULL AUTO_INCREMENT COMMENT 'AUTO_INCREMENT',
    refrigerator_inventory_id VARCHAR(36) NOT NULL COMMENT 'UUID',
    member_id VARCHAR(36) NOT NULL COMMENT 'UUID',
    movement_type ENUM('INBOUND', 'OUTBOUND') NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY (id),
    FOREIGN KEY (refrigerator_inventory_id) REFERENCES refrigerator_inventory(id),
    FOREIGN KEY (member_id) REFERENCES member(id)
);