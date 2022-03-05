package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(DatabaseRule.class)
class NormalAnimalTest {

    @Test
    @DisplayName("Endangered animal instantiates correctly")
    public void endangered_instantiatesCorrectly_true(){
        NormalAnimal endangeredAnimal  = new NormalAnimal("Tiger");
        assertNotNull(endangeredAnimal);
    }
    @Test
    @DisplayName("endangered animal returns Name")
    public void endangered_animalInstantiatesWithName_String(){
        NormalAnimal endangeredAnimal  = new NormalAnimal("Tiger");
        assertEquals("Tiger",endangeredAnimal.getName());
    }
    @Test
    @DisplayName("Equals returns true if properties are same")
    public void equals_returnsTrueIfPropertiesAreSame_true(){
        NormalAnimal testOne  = new NormalAnimal("Tiger");
        NormalAnimal testTwo  = new NormalAnimal("Tiger");
        assertTrue(testOne.equals(testTwo));
    }
    @Test
    @DisplayName("Endangered object saves to database")
    public void save_successfulnessesEndangeredAnimal_true(){
        NormalAnimal testNormal  = new NormalAnimal("Tiger");
        testNormal.save();
        NormalAnimal testTwo = NormalAnimal.all().get(0);
        assertTrue(testNormal.equals(testTwo));
    }
    @Test
    @DisplayName("all returns all instances of endenagered animal in database")
    public void all_returnsAlliancesOfAnimalsInDatabase_true(){
        NormalAnimal testOne  = new NormalAnimal("Tiger");
        NormalAnimal testTwo  = new NormalAnimal("Tiger");
        NormalAnimal testThree  = new NormalAnimal("Tiger");
        NormalAnimal testFour  = new NormalAnimal("Tiger");

        testOne.save();
        testTwo.save();
        testThree.save();
        testFour.save();

        assertEquals(true, NormalAnimal.all().get(0).equals(testOne));
        assertEquals(true, NormalAnimal.all().get(1).equals(testTwo));
        assertEquals(true, NormalAnimal.all().get(2).equals(testThree));
        assertEquals(true, NormalAnimal.all().get(3).equals(testFour));

    }
    @Test
    @DisplayName("find returns endangered animal with same id")
    public void find_returnsEndangeredAnimalWithSameID_EndangeredAnimal(){
        NormalAnimal testOne  = new NormalAnimal("Tiger");
        NormalAnimal testTwo  = new NormalAnimal("Tiger");
        NormalAnimal testThree  = new NormalAnimal("Tiger");
        NormalAnimal testFour  = new NormalAnimal("Tiger");
        testOne.save();
        testTwo.save();
        testThree.save();
        testFour.save();
        assertEquals(NormalAnimal.find(testFour.getId()), testFour);

    }
}