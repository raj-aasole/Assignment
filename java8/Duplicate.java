package Questions;
// WAP to find duplicate value count of given number
interface I3
{
	default void display()
	{
		int i,j,res=0;
		int a[]= {300,200,100,400,400};
		for(i=0 ;i<a.length ;i++)
		{
			for(j=i+1 ;j<a.length;j++)
			{
				if(a[i]==a[j])
				{
					System.out.println("Duplicate number is  found at index : "+i+" and number is :"+a[i]);
				}
				
				
			}
		}
	}
}
public class Duplicate implements I3 {

	public static void main(String[] args) {
	
		Duplicate d=new Duplicate();
		d.display();
	}

}
