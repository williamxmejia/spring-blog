package com.codeup.springblog.model;

import javax.persistence.*;

@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int age;

    private String type;

    private String name;

    @OneToOne
    private PetDetails petDetails;

    public Pet() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetDetails getPetDetails() {
        return petDetails;
    }

    public void setPetDetails(PetDetails petDetails) {
        this.petDetails = petDetails;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", age=" + age +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", petDetails=" + petDetails +
                '}';
    }
}
