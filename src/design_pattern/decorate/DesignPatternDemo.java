package design_pattern.decorate;

public class DesignPatternDemo {

	public static void main(String[] args) {
		Phone phone = new IPhone();
		phone.call();
		
		System.out.println("===========");
		
		//Phone phone2 = new PhoneDecorate(new IPhone());
		Phone phone2 = new PhoneDecorate(phone);
		phone2.call();
		
		
		
	}

}
