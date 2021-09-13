create table category_store
(
    Id       int         not null
        primary key,
    category varchar(10) null
);
create table store
(
    id             int             not null
        primary key,
    name           varchar(50)     not null comment '가게명',
    lat            decimal(18, 10) not null comment '위도',
    lng            decimal(18, 10) not null comment '경도',
    tel            varchar(15)     null comment '전화번호',
    post           varchar(6)      not null comment '우편번호',
    addr1          varchar(255)    not null comment '기본주소',
    addr2          varchar(255)    not null comment '상세주소',
    category       int             null comment '음식점종류',
    rate           tinyint         null comment '평점',
    rate_cnt       int             null comment '총 평가수',
    signature_menu varchar(255)    null comment '대표메뉴',
    constraint store_category_store_Id_fk
        foreign key (category) references category_store (Id)
);

INSERT INTO category_store (Id, category) VALUES (1, '일식');
INSERT INTO store (id, name, lat, lng, tel, post, addr1, addr2, category, rate, rate_cnt, signature_menu) VALUES (1, '우미노미', 37.5303057771, 126.8992801172, '070-4367-7116', '07216', '서울 영등포구 당산로 180', '신우빌딩 1층 12호', 1, 0, 0, '카이센동, 네기도로, 스키야키, 우니도로, 우니마구로, 사케동');