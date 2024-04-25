# 인터페이스와 정적 메서드
자바8과 9에서 주요 인터페이스 변화 

- 기본메서드와 정적 메서드를 가질 수 있다. 
- 기본 메서드 
  - 인터페이스에서 메서드 선언 뿐 아니라, 기본적인 구현체까지 제공할 수 있다. (default 접근제어자 사용 혹은 static으로 선언)
  - 기존의 인터페이스를 구현하는 클래스에 새로운 기능을 추가할 수 있다. 

- 정적 메서드 
  - 자바 9부터 private static 메서드도 가질 수 있다. 
    - public static 메서드의 공통적인 작업 분리를 위해 사용
  - 단 private 필드는 선언 불가 

# 질문 
1. 내림차순으로 정렬하는 Comparator를 만들고 List<Integer>를 정렬

```java
public class ComparatorTest {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3);

        Comparator<Integer> desc = (o1, o2) -> o2 - o1;
        Collections.sort(list, desc);

        System.out.println(list);
    }
}

```
2. 질문 1에서 만든 Comparator를 사용해서 오름차순으로 정렬 
```java
public class ComparatorTest {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3);

        Comparator<Integer> desc = (o1, o2) -> o2 - o1;
        Collections.sort(list, desc.reversed());

        System.out.println(list);
    }
}

```