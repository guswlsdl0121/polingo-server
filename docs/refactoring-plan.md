# 프로젝트 리팩토링 계획

## 멀티 모듈 구조
```text
※ 구조는 변경될 수 있음
domain/
 ├─ wordset/
 │   ├─ entity/        # 단어장, 단어장-단어 관계 엔티티
 │   ├─ repository/    # 단어장 관련 리포지토리 인터페이스
 │   └─ service/       # 단어장 관련 비즈니스 로직
 ├─ word/
 │   ├─ repository/    # Elasticsearch 검색 인터페이스
 │   └─ service/       # 단어 검색 및 관리 로직
 ├─ user/
 │   ├─ entity/        # 사용자 엔티티
 │   ├─ repository/    # 사용자 관련 리포지토리 인터페이스
 │   └─ service/       # 사용자 인증/인가, 프로필 관리 로직
 ├─ situation/
 │   ├─ entity/        # 상황별 예문, 이미지 엔티티
 │   ├─ repository/    # 상황 관련 리포지토리 인터페이스
 │   └─ service/       # 상황별 예문 제공 로직
 ├─ news/
 │   ├─ entity/        # 뉴스, 뉴스 스크랩 엔티티
 │   ├─ repository/    # 뉴스 관련 리포지토리 인터페이스
 │   └─ service/       # 뉴스 제공 및 스크랩 로직
 ├─ quiz/
 │   ├─ entity/        # 퀴즈 관련 엔티티
 │   ├─ repository/    # 퀴즈 결과 저장 인터페이스
 │   └─ service/       # 퀴즈 생성 및 채점 로직
 └─ translate/
     ├─ service/       # 번역 서비스 인터페이스
     └─ vo/            # 번역 관련 값 객체

infrastructure/
 ├─ cache/
 │   ├─ holiday/       # 공휴일 정보 캐시
 │   ├─ weather/       # 날씨 정보 캐시
 │   ├─ quiz/          # 퀴즈 옵션 캐시
 │   └─ config/        # 캐시 설정
 ├─ external/
 │   ├─ deepl/         # DeepL 번역 API 통합
 │   ├─ google/        # Google Cloud(STT, OCR) 통합
 │   ├─ openweather/   # 날씨 정보 API 통합
 │   └─ kakao/         # 카카오 소셜 로그인 통합
 ├─ elasticsearch/
 │   ├─ config/        # ES 설정
 │   ├─ document/      # 단어 문서 정의
 │   ├─ index/         # 인덱스 설정
 │   └─ repository/    # ES 리포지토리 구현체
 ├─ persistence/
 │   ├─ config/        # JPA, DB 설정
 │   └─ repository/    # 리포지토리 구현체
 └─ security/
     ├─ jwt/           # JWT 토큰 처리
     ├─ oauth2/        # OAuth2 인증 처리
     └─ config/        # 보안 설정

api/
 ├─ wordset/
 │   ├─ controller/    # 단어장 API 엔드포인트
 │   └─ dto/
 ├─ word/
 ├─ user/
 ├─ situation/
 ├─ news/
 ├─ quiz/
 └─ translate/

admin/
 ├─ controller/        # 관리자 API 컨트롤러
 ├─ service/           # 관리자 전용 비즈니스 로직
 ├─ dto/
 │   ├─ request/       # 관리자 API 요청 DTO
 │   └─ response/      # 관리자 API 응답 DTO
 └─ security/          # 관리자 권한 설정

bootstrap/
 ├─ config/
 │   ├─ async/         # 비동기 처리 설정
 │   ├─ web/           # 웹 서버 설정
 │   └─ swagger/       # API 문서화 설정
 └─ properties/        # 환경별 설정 파일
```
- 프로젝트 특성 상 외부 의존성이 많고, 인프라 요소도 많이 포함되기에 멀티 모듈 구조로 개선 예정
- admin의 경우, 일반 비지니스 로직과 분리하여 별도의 모듈 내부에 layered archithecture로 구현 예정

<br>

## 리팩토링 계획
- [ ] 기존의 싱글 모듈 프로젝트를 위의 구조에 따라 멀티 모듈로 분리


- [ ] 각 모듈을 구성하는 과정에서 적절히 테스트 코드 작성 및 예외처리 진행


- [ ] 단어 검색 관련 비동기 처리, 외부 API 데이터에 대한 캐시 처리 성능 테스트 진행


- [ ] ElasticSearch, Mysql에 데이터의 특성에 맞게 적절한 인덱스 적용 


- [ ] 기존의 퀴즈 로직 재검토 및 단어 데이터를 elasticsearch에 의존하도록 변경 


- [ ] 기타 구현상 어색한 부분 변경