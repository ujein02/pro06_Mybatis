create table sample(id varchar2(50), pw varchar2(500));

select * from sample;

insert into sample values ('sample','1234');

commit;

 select * from sample
 
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
appendDate varchar(50),
updateDate varchar2(50)
);


select * from TB_USER;

