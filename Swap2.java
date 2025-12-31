package practice;

public class Swap2 {
	public static void main(String[] args) {
		int n1=10;
		int n2=20;
		System.out.println("before Swap :"+n1+" "+n2);
		n1=n1^n2;
		n2=n1^n2;
		n1=n1^n2;
		System.out.println("After Swap :"+n1+" "+n2);
	}
}
