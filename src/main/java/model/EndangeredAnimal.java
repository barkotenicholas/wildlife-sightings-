package model;

public class EndangeredAnimal  extends Animal{

    private String health;
    private String age;


    public EndangeredAnimal(String animalName, String health, String age) {
        super(animalName);
        this.health = health;
        this.age = age;
    }

}
