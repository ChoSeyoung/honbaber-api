# honbaber-api
우리는 불멸의 혼밥러

### 데이터베이스 시딩
서비스 동작시 database/init.sql 파일로 시딩 합니다.

### API 요청 리스트
Reqeust URL | Description | Complete | return
----|----|----|----
/api/v1/store | 주변 가게 검색 | ok | 가게명, 주소, 전화번호, 총평점
/api/v1/store/detail/${id} | 가게 상세 정보 조회 | ok | 주변 가게 검색 정보 + 상세평점, OPEN.CLOSE 정보, 웹사이트
