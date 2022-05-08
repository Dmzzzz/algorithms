package patterns.builder;

public class UserBuilder {

    private String name;
    private Integer age;
    private String mail;

    public UserBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder age(Integer age) {
        this.age = age;
        return this;
    }

    public UserBuilder mail(String mail) {
        this.mail = mail;
        return this;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getMail() {
        return mail;
    }

    public User build() {
        return new User(this);
    }
}