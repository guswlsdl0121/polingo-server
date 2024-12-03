# ElasticSearch 구성 방법 및 변경로그

## 1. 사전 데이터 셋 구성
### 1. 기초 인덱스 생성
```http
PUT /polingo_words
{
  "settings": {
    "number_of_shards": 1,
    "number_of_replicas": 0
  },
  "mappings": {
    "properties": {
      "english_word": { "type": "keyword" },
      "japanese_word": { "type": "keyword" },
      "description": { "type": "text" }
    }
  }
}
```

### 2. 인덱스 생성 확인
```shell
GET /_cat/indices/polingo_words?v
```

### 3. polingo_words_data.json 압축 해제

### 4. elasticdump 설치
```shell
npm install -g elasticdump
```

### 5. 매핑 복원
```shell
elasticdump \
--input=polingo_words_mapping.json \
--output=http://localhost:9200/polingo_words \
--type=mapping
```

### 6. 데이터 복원
```shell
elasticdump \
--input=polingo_words_data.json \
--output=http://localhost:9200/polingo_words \
--type=data
```