create table category_store
(
    Id       int         not null primary key auto_increment,
    category varchar(10) not null comment '업종'
);
comment on table category_store is '가게 업종 카테고리 정보';

INSERT INTO category_store (category)
VALUES ('일식');
INSERT INTO category_store (category)
VALUES ('한식');
INSERT INTO category_store (category)
VALUES ('중식');
INSERT INTO category_store (category)
VALUES ('양식');
INSERT INTO category_store (category)
VALUES ('퓨전');
INSERT INTO category_store (category)
VALUES ('디저트');
INSERT INTO category_store (category)
VALUES ('베트남');
INSERT INTO category_store (category)
VALUES ('태국');
INSERT INTO category_store (category)
VALUES ('인도');
INSERT INTO category_store (category)
VALUES ('프랑스');
INSERT INTO category_store (category)
VALUES ('이탈리아');

create table store
(
    id              int             not null primary key auto_increment,
    name            varchar(50)     not null comment '가게명',
    img             varchar(500)    not null comment '가게이미지',
    lat             decimal(18, 10) not null comment '위도',
    lng             decimal(18, 10) not null comment '경도',
    tel             varchar(15)     null comment '전화번호',
    post            varchar(6)      not null comment '우편번호',
    addr1           varchar(255)    not null comment '기본주소',
    addr2           varchar(255)    null comment '상세주소',
    category        int             not null comment '음식점종류',
    signature_menu  varchar(255)    null comment '대표메뉴',
    is_closed_store tinyint         not null comment '폐업여부 | 0: 정상, 1: 폐업',
    created_at      datetime        not null,
    updated_at      datetime        not null,
    constraint store_category_store_Id_fk
        foreign key (category) references category_store (Id),
    constraint STORE_DETAIL_IS_CLOSED_STORE_CHECK
        check (is_closed_store >= 0)
);
comment on table STORE is '가게 기본 정보';

insert into STORE (NAME, IMG, LAT, LNG, TEL, POST, ADDR1, ADDR2, CATEGORY, SIGNATURE_MENU, IS_CLOSED_STORE, CREATED_AT, UPDATED_AT)
values  ('우미노미', 'https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDA3MTBfMzAw%2FMDAxNTk0MzQwNjMyOTUx.-M-qdSIMdEZmmer_xvd9ZQRQWvz4OVgqZaWf80b4fAEg.-Z-itc7EBgCsQEPkJN2NYa5lS41kcWi3r1fl7IzcST4g.JPEG.hogr1203%2FIMG_9331.JPG', 37.5303057771, 126.8992801172, '070-4367-7116', '07216', '서울 영등포구 당산로 180', '신우빌딩 1층 12호', 1, '카이센동, 네기도로, 스키야키, 우니도로, 우니마구로, 사케동', 0, '2021-09-18 22:47:53.582105', '2021-09-18 22:47:53.582105'),
        ('자성당쫄면 영등포구청역점', 'https://cdn.imweb.me/thumbnail/20210827/8c64fc4754736.png', 37.5250497075, 126.8965910696, '02-6013-2685', '07259', '서울특별시 영등포구 당산동3가 314', ' ', 5, '온쫄면, 냉쫄면, 비빔쫄면, 갈비만두, 비빔만두, 유부초밥', 0, '2021-09-18 22:55:03.000000', '2021-09-18 22:55:11.000000');

create table STORE_DETAIL
(
    ID                 INT auto_increment,
    STORE_ID           INT      not null comment 'store 테이블 id',
    open_day           varchar(50) comment '영업일',
    open_at            varchar(50) comment '영업시간',
    off_day            varchar(50) comment '휴업일',
    website            varchar(255) comment '가게 홈페이지 주소',
    personal_table_cnt int comment '혼밥 가능 식사 테이블 수',
    is_self_side_dish  tinyint comment '반찬 셀프 여부 | 0: 쥔장 서빙, 1: 셀프',
    is_self_water      tinyint comment '물 셀프 여부 | 0: 쥔장 서빙, 1: 셀프',
    is_self_payment    tinyint comment '계산 셀프 여부 | 0: 쥔장 계산, 1: 셀프',
    created_at         datetime null,
    updated_at         datetime null,
    constraint STORE_DETAIL_PK
        primary key (ID),
    constraint STORE_DETAIL_PERSONAL_TABLE_CNT_CHECK
        check (personal_table_cnt >= 0),
    constraint STORE_DETAIL_IS_SELF_SIDE_DISH_CHECK
        check (is_self_side_dish >= 0),
    constraint STORE_DETAIL_IS_SELF_WATER_CHECK
        check (is_self_water >= 0),
    constraint STORE_DETAIL_IS_SELF_PAYMENT_CHECK
        check (is_self_payment >= 0)
);

comment on table STORE_DETAIL is '가게 상세 정보';

create unique index STORE_DETAIL_STORE_ID_UINDEX
    on STORE_DETAIL (STORE_ID);

insert into store_detail(store_id, open_day, open_at, off_day, website, personal_table_cnt, is_self_side_dish, is_self_water, is_self_payment, created_at, updated_at)
values (1, '매일', '09:00~18:00', '매주 목요일', 'http://www.store.com', 5, 0, 0, 0, now(), now());

create table MENU
(
    ID           INT auto_increment,
    STORE_ID     INT      not null comment 'store 테이블 id',
    menu         varchar(100) comment '메뉴명',
    price        int comment '가격',
    is_signature tinyint comment '대표메뉴여부 | 0: 기본메뉴, 1: 대표메뉴',
    created_at   datetime null,
    updated_at   datetime null,
    constraint MENU_PK
        primary key (ID),
    constraint MENU_PRICE_CHECK
        check (price >= 0),
    constraint STORE_IS_SIGNATURE_CHECK
        check (is_signature in (0, 1))
);

comment on table MENU is '가게 메뉴 정보';

insert into menu(store_id, menu, price, is_signature, created_at, updated_at) values (1, '카이센동', 15000, 1, now(), now());
insert into menu(store_id, menu, price, is_signature, created_at, updated_at) values (1, '스키야키정식', 15000, 1, now(), now());
insert into menu(store_id, menu, price, is_signature, created_at, updated_at) values (1, '카이센동 모듬', 30000, 0, now(), now());
insert into menu(store_id, menu, price, is_signature, created_at, updated_at) values (1, '우니도로', 28000, 0, now(), now());
insert into menu(store_id, menu, price, is_signature, created_at, updated_at) values (1, '우니마구로', 25000, 0, now(), now());

create table REPORT
(
    ID             INT auto_increment,
    report_content varchar(4000) comment '제보내용',
    served_content varchar(4000) comment '후속조치내용',
    created_at     datetime null,
    constraint REPORT_PK
        primary key (ID)
);

comment on table STORE_DETAIL is '개선 사항 혹은 틀린정보 신고';

create table review
(
    id         int auto_increment,
    store_id   int not null comment 'store 테이블 id',
    reviewer   varchar(100) comment '리뷰작성자',
    sense_rate tinyint comment '센스 평점',
    time_rate  tinyint comment '시간 평점',
    taste_rate tinyint comment '맛 평점',
    review     varchar(4000) comment '기타 리뷰',
    is_delete  tinyint comment '삭제여부 | 0: 정상, 1: 삭제',
    created_at datetime,
    updated_at datetime,
    constraint REVIEW_PK
        primary key (id),
    constraint REVIEW_IS_DELETE_CHECK
        check (is_delete in (0, 1))
);

comment on table review is '사용자 리뷰 테이블';

create unique index REVIEW_ID_UINDEX
    on review (id);

insert into review(store_id, reviewer, sense_rate, time_rate, taste_rate, review, is_delete, created_at, updated_at)
values (1, '혼밥러#1', 3, 4, 5, 'A', 0, now(), now());
insert into review(store_id, reviewer, sense_rate, time_rate, taste_rate, review, is_delete, created_at, updated_at)
values (1, '혼밥러#2', 1, 2, 3, 'B', 0, now(), now());
insert into review(store_id, reviewer, sense_rate, time_rate, taste_rate, review, is_delete, created_at, updated_at)
values (1, '혼밥러#3', 4, 3, 5, 'C', 0, now(), now());
insert into review(store_id, reviewer, sense_rate, time_rate, taste_rate, review, is_delete, created_at, updated_at)
values (2, '혼밥러#4', 4, 3, 5, 'D', 0, now(), now());
