package ch.survalit.greeting.entity;

public class Greeting {
    public String name;
    public int age;
    public boolean isHappy;
    public Address address;

    public Greeting(String name, int age, boolean isHappy, Address address) {
        this.name = name;
        this.age = age;
        this.isHappy = isHappy;
        this.address = address;
    }

}
