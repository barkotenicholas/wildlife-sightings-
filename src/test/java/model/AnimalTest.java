package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    @DisplayName("Check if animal instantiates correctly")
    public void animal_instantiatesCorrectly_true(){
        Animal testAnimal = new Animal("Lion");
        assertNotNull(testAnimal);
    }

    @Test
    @DisplayName("Check if Animal returns string")
    public void getName_returnsInstantiatedName_String(){
        Animal testAnimal = new Animal("Lion");
        assertEquals(testAnimal.getAnimalName(),"Lion");
    }
}