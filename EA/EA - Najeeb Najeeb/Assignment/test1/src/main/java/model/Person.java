package model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Person")
public class Person extends Owner{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int age;

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
