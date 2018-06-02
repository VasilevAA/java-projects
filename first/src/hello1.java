class A{
    int a;
}

public class hello1 {
    public static void main(String[] args) {
        System.out.println("heey first world");

        A f = new A();
        f.a = 4;

        A c = f;
        f = new A();
        System.out.println(f.a);

    }
}