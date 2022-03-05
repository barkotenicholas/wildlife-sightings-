package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}