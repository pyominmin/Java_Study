*Oracle SQL Developer

-- 주석처리

-- 문자 데이터타입
-- chcar(n) : 고정길이 문자
-- varchar2(n) : 가변길이 문자
-- ex) char(3), varchar2(3) : 3바이트까지 저장할 수 있는 문자열
-- 가변길이의 경우, 지정 size보다 짧은 (혹은 작은) 데이터가 입력되더라도,
-- 저장공간을 낭비하지 않는다는 특징이 있다.

--nchar(n) : 고정길이 유니코드 문자
-- nvarchar2(n) : 가변길이 유니코드 문자
-- ex) nchar(3), naverchar2(3) : 3글자까지 저장할 수 있는 문자열

--N의 유무차이
--National 약자 > 유니코드 지원.//한글
--N이 붙은 자료형 : 모든 문자를 2바이트로 저장.

-- 숫자 데이터 타입
-- number(p, s) : +-38자릿수의 숫자를 저장할 수 있다.
-- number(3) : 최대 3자리까지 표현 가능한 숫자
-- number(4, 2) : 최대 4자리, 소수이하자리 포함(-99.99 ~ 99.99)

-- LoB 데이터 타입
-- CLOB : 문자형 대용량 타입(최대 4GB)
-- NCLOB : 유니코드를 포함한 문자형 대용량 타입(최대 4GB)

-- 날짜형 데이터 타입
-- DATE : 날짜형식의 자료형으로서 시, 분 초까지 표현가능
-- TIMESTAMP : 밀리초까지 표현 가능


-- 테이블 생성하기
-- create table [테이블명] ([컬럼명] [데이터타입] [조건 - 생략가능], ......);

-- SQL : 데이터베이스 질의 언어
-- select : 검색
-- where : 조건
-- * : 모든 것
-- insert : 데이터 추가
-- update : 데이터 수정
-- delete : 데이터 삭제
-- commit : 최종적용
-- rollback : 되돌리기

*키(KEY) 
수많은 데이터를 구별할 수 있는 유일한 값이라는 뜻.종류별로 데이터를 구별하거나 테이블 간의 연관 관계를 표현할 때 키로 지정한 열을 사용한다.

*기본키(Primary Key)
기본키는 여러 키 중에서 가장 중요한 키로서 한 테이블 내에서 중복되지 않는 값만 가질 수 있는 키다.
1. 테이블에 저장된 행을 식별할 수 있는 유일한 값이어야 한다.
2. 값의 중복이 없어야 한다.
3. Null값을 가질 수 없다.
ex) 아이디, 학번 등

//-----------------------------------------------------------------------------------------------------------------------------ORACLE//


CREATE TABLE MEMBER2(

    ID VARCHAR2(50) PRIMARY KEY,--무결성 제약조건(유일한 키)
    PW VARCHAR2(50) NOT NULL,
    NAME NVARCHAR2(50) NOT NULL,
    AGE NUMBER(3),
    EMAIL VARCHAR(100) --기본 디폴트값 NULL

);

-- 해당하는 제이터 상의 모든 테이블 목록 출력
SELECT * FROM TAB;

--데이터 저장하기
-- INSERT INTO [테이블명] (컬럼명1, 컬럼명2,...) VALUES (데이터1, 데이터2, ...);
-- 오라클 데이터베이스의 문자컬럼의 값은 작은 따옴표이다.
INSERT INTO member2(ID, PW, NAME, AGE, EMAIL)VALUES('HONG', '1234', '홍길동', '22', 'HHHH@GMAIL.COM');
INSERT INTO member2(ID, PW, NAME, AGE, EMAIL)VALUES('PARK', '1111', '박길동', '20', 'PPPP@GMAIL.COM');
INSERT INTO member2(ID, PW, NAME, AGE, EMAIL)VALUES('KIM', '1222', '김길동', '21', 'KKKK@GMAIL.COM');
INSERT INTO member2(ID, PW, NAME, AGE, EMAIL)VALUES('LEE', '3333', '이길동', '24', 'LLLL@GMAIL.COM');

ROLLBACK;
COMMIT; --최종적용

--데이터 전체 조회하기
SELECT * FROM MEMBER2;

--조건에 맞게 조회하기
-- SELECT [컬럼명1, 컬럼명2, ...] FROM [테이블명] WHERE [조건]

SELECT ID, PW FROM MEMBER2 WHERE NAME = '홍길동';

--데이터 수정하기
-- UPDATE [테이블명] SET [수정할컬럼] = [수정할 값] WHERE [조건]

UPDATE member2 SET PW = '5678' WHERE ID = 'KIM';

ROLLBACK;--커밋 전에 해야 함
COMMIT;

--데이터 전체 조회하기
SELECT * FROM MEMBER2;

--데이터 삭제하기
--DELETE FROM [테이블명] WHERE [조건]

DELETE FROM MEMBER2 WHERE NAME = '홍길동';

COMMIT;

--데이터 전체 조회하기
SELECT * FROM MEMBER2;

--DROP : 테이블 객체를 삭제
--DROP TABLE [테이블명]

DROP TABLE MEMBER;
