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