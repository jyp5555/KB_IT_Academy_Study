package day05;

import java.util.ArrayList;
import java.util.Collections;

public class ExamSort2 {

	public static void main(String[] args) {
		ArrayList<Person> pa = new ArrayList<>();
		pa.add(new Person("하",5));
		pa.add(new Person("나",2));
		pa.add(new Person("다",3));
		
		Collections.sort(pa);
//		MergeSort or TimSort?

		System.out.println(pa);
	}
}

class Person implements Comparable<Person>{

	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "name=" + name + ", age=" + age;
	}

	/**
	 * <strong>Comparable은 "자기 자신과 매개변수 객체를 비교"</strong>하는 것이고, <strong>Comparator는 "두 매개변수 객체를 비교"</strong>한다는 것이다.<br>
	 * Comparable은 lang패키지에 있기 때문에 import 를 해줄 필요가 없지만, Comparator는 util패키지에 있다.<br>
	 * <h3 style="color:red">바로 뺄셈 과정에서 자료형의 범위를 넘어버리는 경우가 발생 가능</h3>
	 * compareTo를 구현하거나, 이후 설명 할 compare을 구현 할 때 대소비교에 있어 이러한 Overflow 혹은, Underflow가 발생할 여지가 있는지를 반드시 확인하고 사용해야 한다.<br><br>
	 */
	@Override
	public int compareTo(Person o) {//
//		return this.name.compareTo(o.getName());//this.name(앞), o.getName(뒤)
//		이름순 정렬
//		return this.age - o.getAge();//오름차순 정렬(-면 그대로, +면 앞 뒤 바꾸기)
		return o.getAge()-this.age;//내림차순 정렬
	}
	
}
