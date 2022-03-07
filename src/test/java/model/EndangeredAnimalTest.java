package model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(DatabaseRule.class)
@Disabled
class EndangeredAnimalTest {

    @Test
    @DisplayName("Endangered animal instantiates correctly")
    public void endangered_instantiatesCorrectly_true(){
        EndangeredAnimal endangeredAnimal  = new EndangeredAnimal("Tiger","healthy","newborn");
        assertNotNull(endangeredAnimal);
    }
    @Test
    @DisplayName("endangered animal returns Name")
    public void endangered_animalInstantiatesWithName_String(){
        EndangeredAnimal endangeredAnimal  = new EndangeredAnimal("Tiger","healthy","newborn");
        assertEquals("Tiger",endangeredAnimal.getName());
    }
    @Test
    @DisplayName("endangered animal returns Health")
    public void endangered_animalInstantiatesWithHealth_String(){
        EndangeredAnimal endangeredAnimal  = new EndangeredAnimal("Tiger","healthy","newborn");
        assertEquals("healthy",endangeredAnimal.getHealth());
    }
    @Test
    @DisplayName("endangered animal returns age")
    public void endangered_animalInstantiatesWithAge_String(){
        EndangeredAnimal endangeredAnimal  = new EndangeredAnimal("Tiger","healthy","newborn");
        assertEquals("newborn",endangeredAnimal.getAge());
    }
    @Test
    @DisplayName("Equals returns true if properties are same")
    public void equals_returnsTrueIfPropertiesAreSame_true(){
        EndangeredAnimal testOne  = new EndangeredAnimal("Tiger","healthy","newborn");
        EndangeredAnimal testTwo  = new EndangeredAnimal("Tiger","healthy","newborn");
        assertTrue(testOne.equals(testTwo));
    }
    @Test
    @DisplayName("Endangered object saves to database")
    public void save_successfulnessesEndangeredAnimal_true(){
        EndangeredAnimal endangeredAnimal  = new EndangeredAnimal("Tiger","healthy","newborn");
        endangeredAnimal.save();
        EndangeredAnimal testTwo =EndangeredAnimal.all().get(0);
        assertTrue(endangeredAnimal.equals(testTwo));
    }
    @Test
    @DisplayName("all returns all instances of endenagered animal in database")
    public void all_returnsAlliancesOfAnimalsInDatabase_true(){
        EndangeredAnimal testOne  = new EndangeredAnimal("Tiger","healthy","newborn");
        EndangeredAnimal testTwo  = new EndangeredAnimal("Tiger","healthy","newborn");
        EndangeredAnimal testThree  = new EndangeredAnimal("Tiger","healthy","newborn");
        EndangeredAnimal testFour  = new EndangeredAnimal("Tiger","healthy","newborn");

        testOne.save();
        testTwo.save();
        testThree.save();
        testFour.save();

        assertEquals(true, EndangeredAnimal.all().get(0).equals(testOne));
        assertEquals(true, EndangeredAnimal.all().get(1).equals(testTwo));
        assertEquals(true, EndangeredAnimal.all().get(2).equals(testThree));
        assertEquals(true, EndangeredAnimal.all().get(3).equals(testFour));

    }
    @Test
    @DisplayName("find returns endangered animal with same id")
    public void find_returnsEndangeredAnimalWithSameID_EndangeredAnimal(){
        EndangeredAnimal testOne  = new EndangeredAnimal("Tiger","healthy","newborn");
        EndangeredAnimal testTwo  = new EndangeredAnimal("Tiger","healthy","newborn");
        EndangeredAnimal testThree  = new EndangeredAnimal("Tiger","healthy","newborn");
        EndangeredAnimal testFour  = new EndangeredAnimal("Tiger","healthy","newborn");
        testOne.save();
        testTwo.save();
        testThree.save();
        testFour.save();
        assertEquals(EndangeredAnimal.find(testFour.getId()), testFour);

    }
}