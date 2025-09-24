-- test테이블에 컬럼추가
ALTER TABLE test ADD COLUMN age INT;

-- test테이블에 인덱스추가
CREATE INDEX idx_test_age ON test(age);