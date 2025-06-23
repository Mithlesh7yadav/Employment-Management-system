public class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) throws InvalidDataException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidDataException("Name cannot be null or empty.");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}