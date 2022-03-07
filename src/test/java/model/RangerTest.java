package model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
@Disabled
@ExtendWith(DatabaseRule.class)
class RangerTest {
    @Test
    @DisplayName("Ranger instantiates correctly")
    void ranger_instatiatesCorrectly_true(){
        Ranger testRanger = new Ranger("nicholas",123);
        assertNotNull(testRanger instanceof Ranger);
    }
    @Test
    @DisplayName("Ranger returns name when instantiated")
    void ranger_returnsnamewhenInstantiated_true(){
        Ranger testRanger = new Ranger("nicholas",123);
        assertEquals("nicholas",testRanger.getName());
    }
    @Test
    @DisplayName("Ranger returns badgeno when instantiated")
    void ranger_returnsbadgewhenInstantiated_true(){
        Ranger testRanger = new Ranger("nicholas",123);
        assertEquals(123,testRanger.getBadgeNo());
    }
    @Test
    @DisplayName("Ranger object saves to database")
    public void save_successfulnessesRanger_true(){
        Ranger testRanger  = new Ranger("nicholas",123);
        testRanger.save();
        Ranger testTwo = Ranger.all().get(0);
        System.out.println(testRanger.getBadgeNo());
        System.out.println(testTwo.getBadgeNo());
        assertTrue(testRanger.equals(testTwo));
    }
    @Test
    @DisplayName("all returns all instances of Ranger in database")
    public void all_returnsAlliancesOfRangerInDatabase_true(){
        Ranger testOne  = new Ranger("Tiger",324);
        Ranger testTwo  = new Ranger("Tiger",45);
        Ranger testThree  = new Ranger("Tiger",23);
        Ranger testFour  = new Ranger("Tiger",1);

        testOne.save();
        testTwo.save();
        testThree.save();
        testFour.save();

        assertEquals(true, Ranger.all().get(0).equals(testOne));
        assertEquals(true, Ranger.all().get(1).equals(testTwo));
        assertEquals(true, Ranger.all().get(2).equals(testThree));
        assertEquals(true, Ranger.all().get(3).equals(testFour));

    }
    @Test
    @DisplayName("find returns endangered animal with same id")
    public void find_returnsEndangeredAnimalWithSameID_EndangeredAnimal(){
        Ranger testOne  = new Ranger("Tiger",324);
        Ranger testTwo  = new Ranger("Tiger",45);
        Ranger testThree  = new Ranger("Tiger",23);
        Ranger testFour  = new Ranger("Tiger",1);
        testOne.save();
        testTwo.save();
        testThree.save();
        testFour.save();
        assertEquals(Ranger.find(testFour.getId()).getName(), testFour.getName());

    }

}