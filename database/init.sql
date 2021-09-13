create table category_store
(
    Id       int         not null primary key auto_increment,
    category varchar(10) null
);
comment on table category_store is '가게 업종 카테고리 정보';

INSERT INTO category_store (category) VALUES ('일식');

create table store
(
    id             int             not null primary key auto_increment,
    name           varchar(50)     not null comment '가게명',
    lat            decimal(18, 10) not null comment '위도',
    lng            decimal(18, 10) not null comment '경도',
    tel            varchar(15)     null comment '전화번호',
    post           varchar(6)      not null comment '우편번호',
    addr1          varchar(255)    not null comment '기본주소',
    addr2          varchar(255)    not null comment '상세주소',
    category       int             null comment '음식점종류',
    signature_menu varchar(255)    null comment '대표메뉴',
    created_at     datetime        null,
    updated_at     datetime        null,
    constraint store_category_store_Id_fk
        foreign key (category) references category_store (Id)
);
comment on table STORE is '가게 기본 정보';

INSERT INTO store (name, lat, lng, tel, post, addr1, addr2, category, signature_menu, created_at, updated_at) 
VALUES ('우미노미', 37.5303057771, 126.8992801172, '070-4367-7116', '07216', '서울 영등포구 당산로 180', '신우빌딩 1층 12호', 1, '카이센동, 네기도로, 스키야키, 우니도로, 우니마구로, 사케동', now(), now());

create table STORE_DETAIL
(
    ID             INT      auto_increment,
    STORE_ID       INT      not null,
    open_day       varchar(50),
    open_at        varchar(50),
    off_day        varchar(50),
    website        varchar(255),
    created_at     datetime null,
    updated_at     datetime null,
    constraint STORE_DETAIL_PK
        primary key (ID)
);

comment on table STORE_DETAIL is '가게 상세 정보';

create unique index STORE_DETAIL_STORE_ID_UINDEX
    on STORE_DETAIL (STORE_ID);

insert into store_detail(store_id, open_day, open_at, off_day, website, created_at, updated_at) 
values(1, '매일', '09:00~18:00', '매주 목요일', 'http://www.store.com', now(), now());

create table REPORT
(
    ID              INT auto_increment,
    report_content  varchar(4000),
    served_content  varchar(4000),
    created_at      datetime null,
    constraint REPORT_PK
        primary key (ID)
);

comment on table STORE_DETAIL is '개선 사항 혹은 틀린정보 신고';

create table review
(
	id int auto_increment,
	store_id int not null,
  reviewer varchar(100),
  sense_rate     tinyint,
  time_rate      tinyint,
  taste_rate     tinyint,
  review varchar(4000),
	created_at datetime,
	updated_at datetime,
	constraint REVIEW_PK
		primary key (id)
);

comment on table review is '사용자 리뷰 테이블';

create unique index REVIEW_ID_UINDEX
	on review (id);

insert into review(store_id, reviewer, sense_rate, time_rate, taste_rate, review, created_at, updated_at) values(1, '혼밥러#1', 3, 4, 5, 'A', now(), now());
insert into review(store_id, reviewer, sense_rate, time_rate, taste_rate, review, created_at, updated_at) values(1, '혼밥러#2', 1, 2, 3, 'B', now(), now());
insert into review(store_id, reviewer, sense_rate, time_rate, taste_rate, review, created_at, updated_at) values(1, '혼밥러#3', 4, 3, 5, 'C', now(), now());
insert into review(store_id, reviewer, sense_rate, time_rate, taste_rate, review, created_at, updated_at) values(2, '혼밥러#4', 4, 3, 5, 'D', now(), now());
