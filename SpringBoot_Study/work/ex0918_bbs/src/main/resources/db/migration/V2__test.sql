-- 두번째 테이블 생성 테스트 스크립트
-- 작성일: 2025-09-24

-- 테스트 테이블 생성
CREATE TABLE test (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- 테스트 테이블 인덱스 생성
CREATE INDEX idx_test_name ON test(name);