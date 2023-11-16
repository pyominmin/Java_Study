Collection Framework
  - 데이터를 저장, 검색, 조작 및 관리하기 위한 표준 인터페이스와 클래스의 모음을 말한다. 데이터 구조 및 알고리즘을 구현하는데 사용되며, 다양한 유형의 데이터를 효율적으로 다루기 위한 일반적인 방법을 제공

Collection Framework의 주요 특징
  -인터페이스(Interfaces) : 다양한 인터페이스를 정의하고 있다.
  - 클래스(Class) : 각 인터페이스를 구현한 클래스들을 포함하고 있다.
  - 알고리즘(Algorithms) : 다양한 알고리즘을 제공한다.
  - 동기화(SYnchronization) : 여러 스레드가 동시에 컬렉션을 수정하려는 경우 발생할 수 있는 문제를 방지한다.

Collection Framework
Collection 인터페이스 : 모든 컬렉션 클래스의 루트 인터페이스로, 기본적인 컬렉션 동작을 정의한다. Map 인터페이스는 Collection 인터페이스를 구현하지 않았다.
1. List 인터페이스 : 순서가 있는 데이터의 집합을 나타낸다. 중복을 허용한다.(ArrayList, LinkesList)
  ex) 대기자 명단
2. Set 인터페이스 : 순서가 없는 고유한 요소의 집합을 나타낸다. 중복을 허용하지 않는다.(HashSet)
  ex) 소수의 집합, 네발 동물의 집합, 두발 동물의 집합
3. Map 인터페이스 : key-value 쌍의 집합을 나타낸다. 키는 중복될 수 없으며, value는 중복될 수 있다.(LinkedHashMap, HashMap)
  ex) ID-PW, 지역번호, 우편번호 
4. Queue 인터페이스 : 큐 자료 구조를 나타내며, 선입선출(FIFO) 방식으로 요소를 삽입 삭제한다. LinkedList는 Queue 인터페이스를 구현하고 있다.(PriorityQueue)



