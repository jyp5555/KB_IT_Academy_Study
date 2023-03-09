package day04;

import java.util.ArrayList;

public class ExamPerson {

	public static void main(String[] args) {

		Person p1 = new Person("홍길동",30);
		Person p2 = new Person("김길동",32);
		
		System.out.println(p1);
		System.out.println(p2);
		
		Person[] persons = new Person[10];
		persons[0] = new Person("g",1);
		persons[1] = new Person("g",2);
		System.out.println(persons.hashCode());
		System.out.println(persons[0].hashCode());
		System.out.println(persons[1].hashCode());
		System.out.println(persons[0].equals(persons[1]));
		System.out.println(persons[0].equals(persons));
		
//		persons, 스택공간 메인메서드 안에 만들어짐
//		new Person[10] -> persons에는 person배열 시작주소 저장, Person객체 주소바이트(32bit) * 10개 공간의 배열 객체를 메모리공간에 만들어놓음
//		어떻게 초기화 되어있나 그냥 null? Yes!
//		Q. ArrayList<Person> personArrayList = new ArrayList<>(); 이것도 Person을 만든 게 아닌건가?
		ArrayList<Person> personArrayList = new ArrayList<>();
		System.out.println(personArrayList); // []
		System.out.println(personArrayList.hashCode());
		personArrayList.add(new Person("g",1));
		System.out.println(personArrayList.get(0).hashCode());
	}
}
