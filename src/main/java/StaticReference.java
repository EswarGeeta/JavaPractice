public class StaticReference {


    public static void nonStaticMethod(int b) {
        System.out.println("in non static");
        System.out.println(System.identityHashCode(b));
        b = 10;
        System.out.println(System.identityHashCode(b));
    }

    public static void main(String[] args) {
        int a = 20;
        System.out.println(System.identityHashCode(a));
        nonStaticMethod(a);
        System.out.println(a);

        String st = "something";
        String st1 = "something";
        String st2 = "something";
        String st3 = "something";
        String st4 = "something";
        String st5 = "something";

        System.out.println(System.identityHashCode(st));
        System.out.println(System.identityHashCode(st1));
        System.out.println(System.identityHashCode(st2));
        System.out.println(System.identityHashCode(st3));
        System.out.println(System.identityHashCode(st4));
        System.out.println(System.identityHashCode(st5));

        st5 = "new";
        System.out.println(System.identityHashCode(st5));

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Float.MAX_VALUE);
    }


}
