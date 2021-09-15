# honbaber-api
우리는 불멸의 혼밥러
<br/><br/>
# 혼밥러 Frond-End
https://github.com/visualkhh/honbaber
<br/><br/>
# 데이터베이스 시딩
서비스 동작시 database/init.sql 파일로 시딩 합니다.
<br/><br/>
# API 요청 리스트
Method | Reqeust URL | Description | Complete | return
----|----|----|----|----
GET | /api/v1/store | 주변 가게 검색 | ok | 가게명, 주소, 전화번호, 총평점
GET | /api/v1/store/detail/${id} | 가게 상세 정보 조회 | ok | 주변 가게 검색 정보 + 상세평점, OPEN.CLOSE 정보, 웹사이트
PUT | /api/v1/store/close/${id} | 가게 폐업 처리 | ok | 
GET | /api/v1/review/${id} | 리뷰조회 | ok | 사용자 작성한 익명닉네임, 시간, 센스, 맛 평점 
POST | /api/v1/review | 리뷰등록 | ok |
PUT | /api/v1/review | 리뷰수정 | ok |
DELETE | /api/v1/review/${id} | 리뷰삭제 | ok |
