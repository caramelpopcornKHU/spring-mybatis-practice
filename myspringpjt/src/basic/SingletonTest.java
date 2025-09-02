package basic;

public class SingletonTest {

	public static void main(String[] args) {
		MySingleton singleton1 = MySingleton.getInstance();
		MySingleton singleton2 = MySingleton.getInstance();
		MySingleton singleton3 = MySingleton.getInstance();
		MySingleton singleton4 = MySingleton.getInstance();
		MySingleton singleton5 = MySingleton.getInstance();
	}

}

class MySingleton {

	private static MySingleton st = new MySingleton();

	private MySingleton() {
		System.err.println("MySingleton 객체 생성 - 나 heap에 생겼다. 주소값 받아가라");
	}

	public static MySingleton getInstance() {
		return st;
	}

}
