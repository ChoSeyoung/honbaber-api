# honbaber-api
혼밥러에 오신걸환영합니다. 도심속 정글에 외로고 배고픈 당신이여 사냥을 시작하시죠.
<br/><br/>
# 혼밥러 Frond-End
https://github.com/visualkhh/honbaber
<br/><br/>
# 데이터베이스 시딩
서비스 동작시 database/init.sql 파일로 시딩 합니다.
<br/><br/>
# API 요청 리스트 (prefix := /api/v1)
Method | Reqeust URL | Description | Complete
----|----|----|----
GET | ${prefix}/store | 주변 가게 조회 | ok
GET | ${prefix}/store/${storeId} | 가게조회 | ok
POST | ${prefix}/store | 가게등록 | ok
PUT | ${prefix}/store/${storeId} | 가게수정 | ok
DELETE | ${prefix}/store/${storeId} | 가게삭제 | ok 
GET | ${prefix}/store/detail/${storeId} | 가게 상세정보 조회 | ok
POST | ${prefix}/store/detail/${storeId} | 가게 상세정보 등록 | Not yet
PUT | ${prefix}/store/detail/${storeId} | 가게 상세정보 수정 | ok
GET | ${prefix}/review/${id} | 리뷰조회 | ok
POST | ${prefix}/review/${id} | 리뷰등록 | ok
PUT | ${prefix}/review/${id} | 리뷰수정 | ok
DELETE | ${prefix}/review/${id} | 리뷰삭제 | ok
GET | ${prefix}/store/${storeId}/menu | 메뉴조회 | ok
POST | ${prefix}/store/${storeId}/menu | 메뉴등록 | ok
PUT | ${prefix}/store/${storeId}/menu | 메뉴수정 | ok
DELETE | ${prefix}/store/${storeId}/menu/${menuId} | 메뉴삭제 | ok
GET | ${prefix}/report | 의견조회 | Not yet
POST | ${prefix}/report | 의견등록 | Not yet

# API 작성시 주의사항
1. DB SQL에서 사용하는 select, insert, update, delete 대신에 show, save, modify, remove 로 변경하여 메소드명 작성할 것.
2. 파라미터의 key는 카멜케이스 적용하여 사용할 것.
