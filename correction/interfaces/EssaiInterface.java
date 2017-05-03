
public class EssaiInterface {
	public static void main(String[] args) {
		doAction(new OneClass());
		doAction(new AnotherClass());
	}

	public static void doAction(SimpleInterface anObject) {
		anObject.method1("Hello!");
	}
}
class OneClass implements SimpleInterface{
    public int method1(String parameter) {
    		System.out.println("OneClass returns 1 "+parameter);
        return 1;
    }
}

class AnotherClass implements SimpleInterface{
    public int method1(String parameter) {
		System.out.println("AnotherClass returns 2 "+parameter);
        return 2;
    }
}

interface SimpleInterface{
	public int method1(String parameter);
}
