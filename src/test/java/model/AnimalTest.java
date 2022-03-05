//package model;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(DatabaseRule.class)
//class AnimalTest {
//
//    @Test
//    @DisplayName("Check if animal instantiates correctly")
//    public void animal_instantiatesCorrectly_true(){
//        Animal testAnimal = new Animal("Lion");
//        assertNotNull(testAnimal);
//    }
//
//    @Test
//    @DisplayName("Check if Animal returns string")
//    public void getName_returnsInstantiatedName_String(){
//        Animal testAnimal = new Animal("Lion");
//        assertEquals(testAnimal.getName(),"Lion");
//    }
//    @Test
//    @DisplayName("check if equals returns true for name")
//    public void equals_returnsTrueIfNameIsSame_true(){
//        Animal firstAnimal = new Animal("Lion");
//        Animal secondAnimal = new Animal("Lion");
//        assertTrue(firstAnimal.equals(secondAnimal));
//    }
//    @Test
//    @DisplayName("saves assigns id to animal")
//    public void save_assignsIdToAnimal_int(){
//        Animal testAnimal = new Animal("Lion");
//        testAnimal.save();
//        Animal savedAnimal = Animal.all().get(0);
//        assertEquals(testAnimal.getId(),savedAnimal.getId());
//    }
//    @Test
//    @DisplayName("save inserts object into database")
//    public void save_insertsObjectIntoDatabase_true(){
//        Animal testAnimal = new Animal("Lion");
//        testAnimal.save();
//        assertEquals(Animal.all().get(0), testAnimal);
//    }
//    @Test
//    @DisplayName("All returns all instances of Animal")
//    public void all_returnsAllInstancesOfAnimals_list(){
//        Animal firstAnimal = new Animal("Zebra");
//        Animal secondAnimal = new Animal("Lion");
//        Animal thirdAnimal = new Animal("Elephant");
//        Animal fourthAnimal = new Animal("Tiger");
//
//        firstAnimal.save();
//        secondAnimal.save();
//        thirdAnimal.save();
//        fourthAnimal.save();
//
//        assertTrue(Animal.all().get(0).equals(firstAnimal));
//        assertTrue(Animal.all().get(1).equals(secondAnimal));
//        assertTrue(Animal.all().get(2).equals(thirdAnimal));
//        assertTrue(Animal.all().get(3).equals(fourthAnimal));
//    }
//    @Test
//    @DisplayName("find returns with correct Animal")
//    public void find_returnsWithCorrectId_Animal(){
//        Animal firstAnimal = new Animal("Zebra");
//        Animal secondAnimal = new Animal("Lion");
//        Animal thirdAnimal = new Animal("Elephant");
//        Animal fourthAnimal = new Animal("Tiger");
//
//        firstAnimal.save();
//        secondAnimal.save();
//        thirdAnimal.save();
//        fourthAnimal.save();
//
//        assertEquals(Animal.find(thirdAnimal.getId()),thirdAnimal);
//    }
//    @Test
//    @DisplayName("Updates updates data")
//    public void update_updatesNameInAnimal_true(){
//        Animal testAnimal = new Animal("Lion");
//        testAnimal.save();
//        testAnimal.update("zebra",testAnimal.getId());
//        Animal newAnimal = Animal.all().get(0);
//        assertEquals("zebra",newAnimal.getName());
//    }
//}