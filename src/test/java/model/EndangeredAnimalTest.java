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
}