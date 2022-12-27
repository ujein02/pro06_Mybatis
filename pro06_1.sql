create table sample(id varchar2(50), pw varchar2(500));

select * from sample;

insert into sample values ('sample','1234');

commit;


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
email varchar2(20),
regdate date default sysdate
);

create sequence mseq;

drop sequence mseq;

insert into TB_USER values(mseq.nextval, 'admin','1234','관리자','admin@email.com',sysdate);

commit;


select * from TB_USER;

UPDATE TB_USER SET userAuth='ADMIN' WHERE userNo=3;

drop table TB_USER;

insert into TB_USER(userId, userPw, userName, email, tel) values('admin','1234','관리자','admin@email.com','010-0000-0000');

commit;



-- 묻고 답하기_qna(글번호, 작성자, 글제목, 글내용, 작성일, 읽어본 횟수, 글그룹번호, 답변수준, 글깊이)
create table qna(
    qno number primary key,
    qauthor varchar2(100) not null,
    qtitle varchar2(255) not null,
    qcontent varchar2(1000) not null,
    regdate date default sysdate,
    hit number default 0,
    lev number,
    parno number,
    sec varchar2(10)
);

create SEQUENCE qnseq;

drop table qna;

delete from member where id='admin';


commit;

select * from qna;


select * from TB_USER where userid='admin';

update TB_USER set userPw='EjirwAY9zs5/2VfMRE9fyA==' where userId='admin';



