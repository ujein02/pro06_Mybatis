create table sample(id varchar2(50), pw varchar2(500));

select * from sample;

insert into sample values ('sample','1234');

commit;

 
select * from board;

create table boardA (
    id varchar2(100) not null sequence,
    title varchar2(100) not null comment '제목',
    content text not null comment '내용',
    writer varchar2(20) not null comment '작성자',
    hits int not null comment '조회 수',
    delete_yn enum('Y', 'N') not null comment '삭제 여부',
    created_date sysdate not null comment '생성일',
    modified_date sysdate comment '수정일',
    primary key (id)
) comment '게시판';

-- 공지사항
CREATE table boardN(bno number primary key, 
title varchar2(100) not null, 
content varchar2(1000) not null, 
writer varchar2(20), 
regdate date default sysdate, 
visited number default 0);

create sequence nseq;

select * from boardA;

commit;

insert into boardN values(nseq.nextval, '테스트 제목1', '테스트  내용1', '관리자', sysdate, 0);


-- 회원
CREATE table TB_USER(
userNo number primary key, 
userId varchar2(20) not null, 
userPw varchar2(500) not null, 
userName varchar2(20),
userAuth varchar2(20),
appendDate date default sysdate,
updateDate date default sysdate
);

create sequence mseq;

insert into TB_USER(userNo, userId, userPw, userName, appendDate) values('1', 'admin','1234','관리자',sysdate);

-- 사용x
create table TB_USER(userId varchar2(20) primary key,
userPw varchar2(300) not null,
userName varchar2(50),
email varchar2(100) not null,
tel varchar2(20) not null,
addr1 varchar2(200),
addr2 varchar2(100),
postcode varchar2(10),
regdate date default sysdate,
birth date,
pt int default 0,
visited int default 0
);

select * from TB_USER;

UPDATE TB_USER SET userAuth='ADMIN' WHERE userNo=3;

drop table TB_USER;

insert into TB_USER(userId, userPw, userName, email, tel) values('admin','1234','관리자','admin@email.com','010-0000-0000');

commit;

-- 파일 첨부가 가능한 자유 게시판
create table free(bno int primary key,  -- 글번호
title varchar2(100) not null,   -- 글제목
content varchar2(1500) not null,    -- 글내용
regdate date,   -- 작성일
visited int,    -- 조회수
id varchar2(20),    -- 작성자
rec int -- 추천수
);

commit;

drop table free;

select * from free;

create table member(id varchar2(20) primary key,
pw varchar2(300) not null,
name varchar2(50),
email varchar2(100) not null,
tel varchar2(20) not null,
addr1 varchar2(200),
addr2 varchar2(100),
postcode varchar2(10),
regdate date default sysdate,
birth date,
pt int default 100,
visited int default 0
);

-- 자료실(자료번호, 자료제목, 자료내용, 자료이미지, 자료파일, 자료출력모드, 자료등록일)
create table databank (
    datano number primary key,
    dtitle varchar2(255) not null,
    dcontent varchar2(1000),
    dposter varchar2(255),
    dfilename varchar2(255),
    dview char(1) default 'Y',
    regdate date default sysdate
);

-- 묻고 답하기_qna(글번호, 작성자, 글제목, 글내용, 작성일, 읽어본 횟수, 글그룹번호, 답변수준, 글깊이)
create table qna(
    qno number primary key,
    qauthor varchar2(100) not null,
    qtitle varchar2(255) not null,
    qcontent varchar2(1000) not null,
    regdate date default sysdate,
    qhit number default 0,
    qgroup number,
    qstep number,
    qindent number
);

CREATE TABLE qna(
    qno         NUMBER PRIMARY KEY,
    qtitle       VARCHAR2(300) NOT NULL,
    qcontent     VARCHAR2(4000) NOT NULL,
    qwriter      VARCHAR2(20) NOT NULL,
    qwritedate   DATE DEFAULT SYSDATE,
    qreadcnt     NUMBER DEFAULT 0,
    qroot        NUMBER,
    qstep        NUMBER default 0,
    qindent      NUMBER default 0 
);

-- 접속자 정보 저장 테이블
CREATE TABLE db_info (
  no number primary key,
  request_uri varchar(100),
  query_string varchar(200),
  remote_address varchar(30),
  server_name varchar(60),
  server_port varchar(10),
  locale varchar(20),
  browser varchar(200),
  referer varchar(255),
  session_id varchar(80),
  user_id varchar(20),
  response_time number,
  reg_date date default sysdate
);

commit;

-- drop table db_access;

select * from db_access;

create table useafter(uno number primary key,
gno number,
userid varchar2(20),
subject varchar2(100),
content varchar2(800),
regdate date default sysdate,
visited number default 0);


delete from member where id='admin';

select * from member;

commit;

select * from free;


select * from TB_USER where userid='admin';

update TB_USER set userPw='1234' where userId='admin';

$2a$10$iy7afS7qwI.53ycEuq5a2O96WGbY/bDMX8hHC/mnO4hWn9CUJaHn.


-- 회원
CREATE table TB_USER(
userNo number primary key, 
userId varchar2(20) not null, 
userPw varchar2(500) not null, 
userName varchar2(20),
email varchar2(20),
regdate date default sysdate
);

create sequence mseq;

drop sequence mseq;

insert into TB_USER values(mseq.nextval, 'admin','1234','관리자','admin@email.com',sysdate);

commit;

select * from tb_user;
