
public class EssaiInterfaceErreur {
	public static void main(String[] args) {
		doAction(new OneClass());
		doAction(new AnotherClass());
	}

	public static void doAction(Object anObject) {
		anObject.method1("Hello!");
	}
}
class OneClass {
    public int method1(String parameter) {
    		System.out.println("OneClass returns 1 "+parameter);
        return 1;
    }
}

class AnotherClass {
    public int method1(String parameter) {
		System.out.println("AnotherClass returns 2 "+parameter);
        return 2;
    }
}

interface SimpleInterface{
	public int method1(String parameter);
}
