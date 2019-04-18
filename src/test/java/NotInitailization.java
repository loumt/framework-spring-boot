
class SuperClass {
    static {
        System.out.println("Super Class Init ...");
    }

    public static int value = 15;
}


class SubClass extends SuperClass {
    static {
        System.out.println("Sub Class Init ........");
    }
}

class ConstClass {
    static {
        System.out.println("Constant init ............");
    }

    public static final int value = 2;
}







public class NotInitailization {
    public static void main(String[] args) {
        System.out.println(ConstClass.value);
    }
}
