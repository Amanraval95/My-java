class A {
    int a;

    public void hello() {
        System.out.println("Hello there! ,this is outer class");
    }

    class B {

        public void hey() {
            System.out.println("hey there! ,this is a inner class");
        }
    }
}

public class inner_class {
    public static void main(String[] args) {

        A obj = new A();
        obj.hello();
        A.B obj1 = obj.new B();
        obj1.hey();
    }
}
