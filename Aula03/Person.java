public class Person {
    private String name;
    private Integer age;

    public static Person build() {
        return new Person();
    }
    public String toString() {
        return this.name + " - Age: " + this.age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
}


