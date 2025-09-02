package basic;

public class NullPointerTest {
	public static void main(String[] args) {
		String str = null;
		String str2 = new String("dddd");
		System.out.println(str.length()); //  java.lang.NullPointerException
	}
}
