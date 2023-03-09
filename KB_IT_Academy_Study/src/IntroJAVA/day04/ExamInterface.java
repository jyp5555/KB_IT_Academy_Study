package IntroJAVA.day04;

public class ExamInterface {

	public static void main(String[] args) {
		SwimStudent s1 = new SwimStudent("",0,"");
		System.out.println(s1); 
		s1.getAge();
		s1.swim();
		
		SwimCar c1 = new SwimCar("","");
		System.out.println(c1.toString());
		c1.swim();
		
		Swimmable[] swims = new Swimmable[2];//interface(부모)상속받아서... Student 자체 기능 안보임...
		swims[0] = c1;
		swims[1] = s1;
		c1.getModel();
		System.out.println();
		for(Swimmable swim : swims) {
			swim.swim();
		}
	}
}

interface Swimmable{
	void swim();
}

class SwimStudent extends Student implements Swimmable {

	public SwimStudent(String name, int age, String major) {
		super(name, age, major);
	}

	@Override
	public void swim() {
		System.out.println("수영하자");
	}	
}

class SwimCar extends Car implements Swimmable{

	private String model;
	private String type;

	public SwimCar(String model, String type) {
		super(model, type);
		this.model = model;
		this.type = type;
	}

	@Override
	public void swim() {
		System.out.println("수중 프로펠러 작동");
	}

	@Override
	public String toString() {
		return "SwimCar [model=" + model + ", type=" + type + "]";
	}
	
	
}

class Car{
	private String model, type;

	public Car(String model, String type) {
		super();
		this.model = model;
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "model=" + model + ", type=" + type;
	}
	
}