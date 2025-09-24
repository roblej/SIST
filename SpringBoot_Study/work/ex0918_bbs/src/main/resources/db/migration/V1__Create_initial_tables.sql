-- 초기 테이블 생성 스크립트
-- 작성일: 2024-01-01
-- 설명: Member와 Bbs 테이블을 생성하는 초기 마이그레이션

-- Member 테이블 생성
CREATE TABLE member (
    b_idx BIGINT AUTO_INCREMENT PRIMARY KEY,
    write_date VARCHAR(255),
    mid VARCHAR(255),
    mname VARCHAR(255),
    mpw VARCHAR(255),
    `access_token` VARCHAR(255),
    `refresh_token` VARCHAR(1024)
);

-- Bbs 테이블 생성
CREATE TABLE bbs (
    b_idx BIGINT AUTO_INCREMENT PRIMARY KEY,
    write_date VARCHAR(255),
    hit BIGINT DEFAULT 0,
    state BIGINT DEFAULT 0,
    title VARCHAR(255) NOT NULL,
    content VARCHAR(255) NOT NULL,
    writer VARCHAR(255) NOT NULL
);

-- 인덱스 생성 (성능 최적화)
CREATE INDEX idx_member_mid ON member(mid);
CREATE INDEX idx_bbs_writer ON bbs(writer);
CREATE INDEX idx_bbs_write_date ON bbs(write_date);
