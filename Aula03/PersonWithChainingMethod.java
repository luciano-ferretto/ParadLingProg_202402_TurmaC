public class PersonWithChainingMethod {
    private String name;
    private Integer age;
    public static PersonWithChainingMethod build() {
        return new PersonWithChainingMethod();
    }
    public String toString() {
        return this.name + " - Age: " + this.age;
    }
    public String getName() {
        return name;
    }
    public PersonWithChainingMethod setName(String name) {
        this.name = name;
        return this;
    }
    public Integer getAge() {
        return age;
    }
    public PersonWithChainingMethod setAge(Integer age) {
        this.age = age;
        return this;
    }
}

