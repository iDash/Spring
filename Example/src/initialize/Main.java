package initialize;

public class Main {

    public static void main(String[] args) {
        //Parent child = new Child();
        Parent parent = new Parent();
    }
}

class Parent {
    public Parent() {
        sayPi();
    }

    public void sayPi() {
        System.out.println("Pi");
    }
}

class Child extends Parent {
    private double Pi = Math.PI;

    public Child() {
        sayPi();
    }

    @Override
    public void sayPi() {
        System.out.println(Pi);
    }
}
