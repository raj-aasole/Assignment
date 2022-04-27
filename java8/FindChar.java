package Questions;
import java.util.*;
// wap to find occurance of character using lambda exp
interface I1
{
	void show();
}
public class FindChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		I1 obj=()->
		{
			int count[]=new int[256];
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter a string  ");

			String s=sc.next();
			System.out.println("Enter a string is :"+s);
			for(int i=0;i<s.length();i++)
			{
				count[((int)s.charAt(i))]++;
			}
			for(int i=0;i<256;i++)
			{
				if(count[i] !=0)
				{
					System.out.println((char)i+" ->>"+count[i]);
				}
			}
		};
obj.show();
	}

}
