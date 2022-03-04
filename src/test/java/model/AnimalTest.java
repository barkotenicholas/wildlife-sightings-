package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(DatabaseRule.class)
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
        assertEquals(testAnimal.getName(),"Lion");
    }
    @Test
    @DisplayName("check if equals returns true for name")
    public void equals_returnsTrueIfNameIsSame_true(){
        Animal firstAnimal = new Animal("Lion");
        Animal secondAnimal = new Animal("Lion");
        assertTrue(firstAnimal.equals(secondAnimal));
    }
    @Test
    @DisplayName("saves assigns id to animal")
    public void save_assignsIdToAnimal_int(){
        Animal testAnimal = new Animal("Lion");
        testAnimal.save();
        Animal savedAnimal = Animal.all().get(0);
        assertEquals(testAnimal.getId(),savedAnimal.getId());
    }
}