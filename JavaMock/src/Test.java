  
interface  PramodNayak{
	 public abstract void display();
	 

}
interface  PramodNayak1{
	 public abstract void display();
	 

}

interface PramodNayak11 extends PramodNayak1{
	public abstract void displayee();
}
class pramod implements PramodNayak,PramodNayak1{
	public void display() {
		System.out.println("Hiw ");
	}
	public void display1() {
	
		System.out.println("Hi ");
	}
}
public class Test{
	
	public static void main(String[] args) {
		pramod p = new pramod();
		p.display();
		p.display1();
		
	}
} 