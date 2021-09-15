# honbaber-api
우리는 불멸의 혼밥러
>혼밥러에 오신걸환영합니다. <br/>도심속 정글에 외로고 배고픈 당신이여 사냥을 시작하시죠.
<br/>
# 혼밥러 Frond-End
https://github.com/visualkhh/honbaber
<br/><br/>
# 데이터베이스 시딩
서비스 동작시 database/init.sql 파일로 시딩 합니다.
<br/><br/>
# API 요청 리스트
Method | Reqeust URL | Description | Complete
----|----|----|----
GET | /api/v1/store | 주변 가게 검색 | ok
GET | /api/v1/store/detail/${id} | 가게 상세 정보 조회 | ok
PUT | /api/v1/store/close/${id} | 가게 폐업 처리 | ok 
GET | /api/v1/review/${id} | 리뷰조회 | ok
POST | /api/v1/review | 리뷰등록 | ok
PUT | /api/v1/review | 리뷰수정 | ok
DELETE | /api/v1/review/${id} | 리뷰삭제 | ok
GET | /api/v1/store/${id}/menu | 메뉴조회 | Not yet
POST | /api/v1/store/${id}/menu/${id} | 메뉴등록 | Not yet
PUT | /api/v1/store/${id}/menu/${id} | 메뉴수정 | Not yet
DELETE | /api/v1/store/${id}/menu/${id} | 메뉴삭제 | Not yet
