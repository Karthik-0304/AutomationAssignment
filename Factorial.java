package practice;

public class Factorial {
	public void findFactorial(int num) {
		System.out.println("Factorial of "+num+" is : ");
		int fa=1;
		for (int i =num;i>=1;i--) {
			fa=fa*i;
		}
		System.out.println(fa);
	}
	public static void main(String[] args) {
		Factorial obj =new Factorial();
		obj.findFactorial(5);
	}
}
