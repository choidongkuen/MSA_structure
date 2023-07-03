# MSA_structure

작가는 웹소설을 편당 금액과 함께 등록할 수 있으며
독자는 돈을 지불하여 이를 감상할 수 있다. <br>
관련하여 기본적인 도서에 대한 관리가 필요하고, 결제를 위한 내용이 필요하다 by monolithic & msa structure <br>

독자는 소설을 전부 즉기 결제로만 이용가능하다.(캐시 기능 x)

### 웹 소설<br>

- [x] 1화,2화(챕터)

### 작가<br>

- [x] 작가 등록 <br>
- [x] 웹 소설 등록 <br>
- [x] 웹 소설의 한 챕터를 등록한다( 금액과 함께 )
- [x] 작가의 출금 ( 결제에 대한 )

### 독자

- [x] 회원 가입
- [x] 웹 소설의 챕터를 결제한다.
- [x] 웹 소설의 목록을 볼 수 있다.
- [x] 내가 결제한 목록을 볼 수 있다.

<hr>

| 이름 | 포트 |
| --- | --- |
| 유저(User) | 8091 |
| 웹 소설(WebBook) | 8092 |
| 결제(Payment) | 8090 |
