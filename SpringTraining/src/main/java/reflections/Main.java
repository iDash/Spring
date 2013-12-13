package reflections;

public class Main {
    public static void main(String[] args) throws Exception {
        Person person = ObjectFactory.createObject(Person.class);
    }
}
