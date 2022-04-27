package Questions;

// WAP to implements binary search using lambda exp
interface I5 {
	void show();
}

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		I5 obj = () -> {
			int arr[] = { 12, 22, 32, 42, 52 };
			int key = 30,first=0,found=0;
			
			int last = arr.length - 1;
			int mid = (first + last) / 2;
			
			while (first <= last)
			{
				if (arr[mid] < key)
				{
					first = mid + 1;
				} 
				else if (arr[mid] == key)
				{
					System.out.println("Element is found at index: " + mid);
					found=1;
					break;
				} 
				else 
				{
					last = mid - 1;
				}
				mid = (first + last) / 2;
			}
			if (first > last) 
			{
				System.out.println("Element is not found!");
			}
		};
		obj.show();
	}

}
