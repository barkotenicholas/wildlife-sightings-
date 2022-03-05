package model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(DatabaseRule.class)
class SightingTest {

    @Test
    @DisplayName("Sighting instantites correctly ")
    void sights_instantiatesCorrectly_true(){
        NormalAnimal testAnimal = new NormalAnimal("Lion");
        Ranger testRanger = new Ranger("Nicholas",123);
        Timestamp now = new Timestamp(new Date().getTime());
        Sighting testSighting = new Sighting(testAnimal.getId(),"ZoneA",now,testRanger.getId());        assertTrue(testSighting instanceof Sighting);
    }
    @Test
    @DisplayName("sighting is reported  with appropriate animal")
    void sight_intantiatesWithAnimal_id(){
        NormalAnimal testAnimal = new NormalAnimal("Lion");
        Ranger testRanger = new Ranger("Nicholas",123);
        Timestamp now = new Timestamp(new Date().getTime());
        Sighting testSighting = new Sighting(testAnimal.getId(),"ZoneA",now,testRanger.getId());
        assertEquals(testSighting.getAnimal_id(),testAnimal.getId());
    }
    @Test
    @DisplayName("sighting is reported  with appropriate Location")
    void sight_intantiatesWithLocation_String(){
        NormalAnimal testAnimal = new NormalAnimal("Lion");
        Ranger testRanger = new Ranger("Nicholas",123);
        Timestamp now = new Timestamp(new Date().getTime());
        Sighting testSighting = new Sighting(testAnimal.getId(),"ZoneA",now,testRanger.getId());
        assertEquals(testSighting.getZone(),"ZoneA");
    }
    @Test
    @DisplayName("sighting is reported  with appropriate Time")
    void sight_intantiatesWithTime_Timestamp(){
        NormalAnimal testAnimal = new NormalAnimal("Lion");
        Ranger testRanger = new Ranger("Nicholas",123);
        Timestamp now = new Timestamp(new Date().getTime());
        Sighting testSighting = new Sighting(testAnimal.getId(),"ZoneA",now,testRanger.getId());
        Timestamp rightNow = new Timestamp(new Date().getTime());
        assertEquals(testSighting.getTimestamp(),rightNow);
    }
    @Test
    @DisplayName("sighting is instantiates with ranger ID")
    void sight_intantiatesWithRangerId_(){
        NormalAnimal testAnimal = new NormalAnimal("Lion");
        Ranger testRanger = new Ranger("Nicholas",123);
        Timestamp now = new Timestamp(new Date().getTime());
        Sighting testSighting = new Sighting(testAnimal.getId(),"ZoneA",now,testRanger.getId());
        Timestamp rightNow = new Timestamp(new Date().getTime());
        assertEquals(testSighting.getRanger_id(),testRanger.getId());
    }
    @Test
    @DisplayName("save sightings returns with id")
    void save_returnssightingwithid_int(){
        NormalAnimal testAnimal = new NormalAnimal("Lion");
        Ranger testRanger = new Ranger("Nicholas",123);
        Timestamp now = new Timestamp(new Date().getTime());
        Sighting testSighting = new Sighting(testAnimal.getId(),"ZoneA",now,testRanger.getId());

        testSighting.save();
        Sighting test =Sighting.all().get(0);
        assertEquals(testSighting.getId(),test.getId());

    }

    @Test
    @DisplayName("find siting with location")
    void fins_sitingWithLocation_SIghting(){
        NormalAnimal testAnimal = new NormalAnimal("Lion");
        Ranger testRanger = new Ranger("Nicholas",123);
        Timestamp now = new Timestamp(new Date().getTime());
        Sighting testSighting = new Sighting(testAnimal.getId(),"ZoneA",now,testRanger.getId());
        testSighting.save();

        NormalAnimal testAnimal1 = new NormalAnimal("Lion");
        Ranger testRanger1 = new Ranger("Nicholas",123);
        Timestamp now1 = new Timestamp(new Date().getTime());
        Sighting testSighting1 = new Sighting(testAnimal1.getId(),"ZoneA",now,testRanger1.getId());
        testSighting1.save();

        NormalAnimal testAnimal2 = new NormalAnimal("Lion");
        Ranger testRanger2 = new Ranger("Nicholas",123);
        Timestamp now2 = new Timestamp(new Date().getTime());
        Sighting testSighting2 = new Sighting(testAnimal2.getId(),"ZoneA",now,testRanger2.getId());
        testAnimal2.save();

        Sighting temp = Sighting.find(testSighting1.getZone());
        assertEquals(testSighting1.getAnimal_id(),temp.getAnimal_id());
    }
    @Test
    @DisplayName("find all siting with location")
    void findloc_returnsAllsitingsWithinASpecficLocation(){
        NormalAnimal testAnimal = new NormalAnimal("Lion");
        Ranger testRanger = new Ranger("Nicholas",123);
        Timestamp now = new Timestamp(new Date().getTime());
        Sighting testSighting = new Sighting(testAnimal.getId(),"ZoneA",now,testRanger.getId());
        testSighting.save();

        NormalAnimal testAnimal1 = new NormalAnimal("Lion");
        Ranger testRanger1 = new Ranger("Nicholas",123);
        Timestamp now1 = new Timestamp(new Date().getTime());
        Sighting testSighting1 = new Sighting(testAnimal1.getId(),"ZoneA",now,testRanger1.getId());
        testSighting1.save();

        NormalAnimal testAnimal2 = new NormalAnimal("Lion");
        Ranger testRanger2 = new Ranger("Nicholas",123);
        Timestamp now2 = new Timestamp(new Date().getTime());
        Sighting testSighting2 = new Sighting(testAnimal2.getId(),"ZonaeA",now,testRanger2.getId());
        testSighting2.save();

        List<Sighting> list;
        list = Sighting.findall("ZoneA");
        System.out.println(list.size());
        assertEquals(list.size(),2);
    }
}