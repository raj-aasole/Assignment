package Questions;

interface I4 {
	default void show() {

		int cnt[] = new int[10];
		int N = 2235;
		int res = 0;
		while (N > 0) {
			int rem = N % 10;
			cnt[rem]++;
			N = N / 10;
		}
		for (int i = 0; i < 10; i++) {
			if (cnt[i] > 1) {
				res++;
			}

		}
		System.out.println("duplicate elements :" + res);
	}
}

public class DuplicateDigit implements I4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DuplicateDigit d = new DuplicateDigit();
		d.show();

	}

}
