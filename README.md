# java.project

# 프로젝트 소개

스레드를 활용한 벽돌 깨기 게임

게임을 시작하면 공이 날아가게 되면서 블럭을 맞추는 게임이다. 스테이지는 3개로 나뉘어져 있고 공이 다 떨어지면 게임 오버, 블럭을 다 맞추게 되면 게임 클리어를 한다.





## 기능

* 시작화면, 게임시작
* 스테이지 3개 중 하나 선택
* 공속도 랜덤, 블럭 생성
* 화살표(좌,우)나 a,d키를 누르면 바가 이동
* 바가 창밖으로 나가지 않도록 설정
* 블럭의 색깔에 따라 점수 차별화
* 게임 끝나면 게임 종료, 스테이지 다시선택하기







# 개발 환경

JDK 11.0.10

JDE: Eclipse



​	







## 시연영상





























## 어려웠던 점들

* static을 쓰지 않으면 버그가 일어났고, static 없이 실행시키려고 다른 코드를 수정해 봤지만 실행이 안됐다.
* 공이 블럭과 충돌할 때 튕겨 나가야 하는데 가끔씩 일직선으로 블럭의 반사를 무시하고 뻗어나가는 경우가 있어 그 버그를 없앨려고 충돌 여부 코드의 조건을 수정해 나가는 것이 힘들었다.

* 블럭과, 볼의 스레드를 추가하는 과정에서 모르는 버그들이 많이 일어나서 스레드 내의 조건을 수정하거나 프레임 에서의 타이머와 볼,블럭 스레드를 수정하는 등 조율하는 시간이 필요했다.
* 스테이지 1,2,3 코드를 다 짰지만 중복되는 코드가 많아 중복되는 코드를 하나로 합치고 3개의 스테이지내의 차이점을 뽑아내서 따로 추가할려고 했지만 잦은 충돌이 일어나서 그대로 냅뒀다.

* 게임이 끝나고 스테이지를 다시 선택한 후 게임을 실행하게 되면

공들이 블럭과 충돌했을시 점수가 배로 늘어나 interrupt()를 쓰려고 했지만 적용되지 않아 헤메고 결국엔  if문과 break문을 써서 해결하게 됐다.





## 개선해야될 점들

* 메인 메뉴에는 DB를 사용해 로그인, 회원가입을 추가해 로그인을 안하면 게임 시작이 안된다거나, 회원가입을 해야 게임 시작이 가능하도록  하는 기능들을 추가할 것이다.

* 스테이지 선택창에 점수 기록표를 추가해 게임이 끝날때마다 점수 기록이 되게끔 만들 것이다.

* 공과 블럭이 충돌할 시 공이 일직선으로 나가는 잔버그가 있어 점차 수정해 나갈 것이다.
* 게임이 끝나고 뜨는 finishGUI에 다시 시작 기능을 추가할 것이다.

