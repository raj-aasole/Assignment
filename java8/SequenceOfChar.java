package Questions;
//To find sequence of character by using  default method

import java.util.*;
interface I2
{
	default void show()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a string  ");

		String s=sc.next();
		System.out.println("Enter a sequence :");
		String s1=sc.next();
		
		if(s.contains(s1)==true)
		{
			System.out.println("yes");
		}
		else
		{
			System.out.println("NO");
		}
	}
}

public class SequenceOfChar implements I2 {

	public static void main(String[] args) {
		
		SequenceOfChar obj=new SequenceOfChar();
		obj.show();
	}

}
