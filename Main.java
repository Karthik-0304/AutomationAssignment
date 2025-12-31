package practice;

class A
{
    public void oddNumber(int i, int j)
    {
        System.out.println("Odd Number : ");
        for(int l = i;l<=j;l++)
        {
            if(l%2==1)
            {
                System.out.println(l);
            }
        }
    }
}

public class Main {
	public static void main(String[] args)
    {
        A obj  = new A();
        obj.oddNumber(1,20);
        System.out.println();

    }
}
