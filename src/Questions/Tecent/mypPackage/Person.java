package Questions.Tecent.mypPackage;

public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    private void say() {
        System.out.println("Hi, this is private method");
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private Person(String name, int id) {
        this.name = name;
        this.age = id;
    }

    public Person() {

    }
}
