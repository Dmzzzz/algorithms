package patterns.builder;

public class User {

    private final String name;
    private final Integer age;
    private final String mail;

    public User(UserBuilder userBuilder) {
        this.name = userBuilder.getName();
        this.age = userBuilder.getAge();
        this.mail = userBuilder.getMail();
    }

    public static void main(String[] args) {
        User user = new UserBuilder().name("Alex").age(10).mail("mail.ru").build();
    }
}