# login-stats-api
SW 로그인 현황을 제공하는 REST API 서비스입니다.

## 1주차: 개발환경 구성  

### 환경 세팅  
- **JDK**: OpenJDK version 11  
- **IDE**: IntelliJ IDEA 2023.1 (Ultimate Edition)  
- **DB**: AWS RDS (MariaDB)  
  - **DB Tool**: DBeaver  

### 주요 진행 사항  
- 개인 Github에 새 repository 생성 및 initial commit 완료  

---

## 2주차: API 가이드 작성  

### 주요 진행 사항  
- API 가이드 초안 작성 완료  
  - [API 가이드](https://helix-dresser-0b7.notion.site/SW-API-15fcf67b16da8002a1abcf34758c690e?pvs=4)  
  - API 개요, 상세 기능 목록 작성 완료
  - Path, Request Parameters, Response Body 작성 완료
---
## 3주차: Springboot 개발환경 재구성  

### 환경 세팅  
- **JDK**: Amazon Corretto version 1.8.0_432 (**JAVA 8**)
- **SpringBoot**: 2.2.2.RELEASE
- **IDE**: IntelliJ IDEA 2023.1 (Ultimate Edition)  
- **DB**: MySQL (Local)  
  - **DB Tool**: DBeaver, MySQL Workbench

### 주요 진행 사항  
- 개인 Github에 새 repository 생성 및 initial commit 완료  
- Mybatis 설정 및 JSP 활용 API 테스트 완료
- API 구축을 위한 SQL 작성 완료
  - [3주차 SQL 작성](https://helix-dresser-0b7.notion.site/3-SQL-16fcf67b16da80e39c9df970349852d0?pvs=4)
---
## 4주차: SW 활용 현황 API 구현 및 API 가이드 문서 보완

### 환경 세팅  
- **JDK**: Oracle OpenJDK version 17.0.9 (**JAVA 17**)
- **SpringBoot**: 3.0.3
- **IDE**: IntelliJ IDEA 2023.1 (Ultimate Edition)  
- **DB**: MariaDB (AWS RDS)  
  - **DB Tool**: DBeaver, MySQL Workbench

### 주요 진행 사항  
- 로그인 통계 API 추가
  - 연간 접속자 수
  - 월간 접속자 수
  - 연간 월 평균 로그인 수
  - 월간 일 평균 로그인 수
  - 부서별 월별 로그인 수
- API 가이드 수정 완료
  - [API 가이드](https://helix-dresser-0b7.notion.site/SW-API-15fcf67b16da8002a1abcf34758c690e?pvs=4)

