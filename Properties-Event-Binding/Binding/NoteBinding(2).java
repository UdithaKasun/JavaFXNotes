public class Binding {
	public static void main(String[] args) {
		/*IntegerProperty num1 = new SimpleIntegerProperty(5);
		IntegerProperty num2 = new SimpleIntegerProperty(5);
		
		NumberBinding sum = num1.add(num2);
		System.out.println(sum.doubleValue());
		num1.set(10);
		System.err.println(sum.doubleValue());*/
		
		int x = 5;
		int y = 5;
		
		int sum = x+y;
		System.out.println("Sum Before : "+sum);
		x = 10;
		System.out.println("Sum After : "+sum);
	}
}
