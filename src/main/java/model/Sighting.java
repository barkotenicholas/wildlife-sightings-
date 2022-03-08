package model;

import Database.DB;
import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class Sighting {

    private int id;
    private int animal_id;
    private String location;
    private Timestamp timestamp;
    private int ranger_id;
    private String animal_name;
    private String ranger_name;

    public Sighting(int animal_id, String zone, Timestamp timestamp, int ranger_id) {
        this.animal_id = animal_id;
        this.location = zone;
        this.timestamp = timestamp;
        this.ranger_id = ranger_id;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public String getZone() {
        return location;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public int getRanger_id() {
        return ranger_id;
    }

    public int getId() {
        return id;
    }

    public String getAnimal_name() {
        return animal_name;
    }

    public String getRanger_name() {
        return ranger_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sighting sighting = (Sighting) o;
        return id == sighting.id && animal_id == sighting.animal_id && ranger_id == sighting.ranger_id && Objects.equals(location, sighting.location) && Objects.equals(timestamp, sighting.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, animal_id, location, timestamp, ranger_id);
    }

    public void save() {

        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sighting (animal_id, location, ranger_id, timestamp) VALUES (:animal_id, :location, :ranger_id, now());";
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("animal_id",this.animal_id)
                    .addParameter("location",this.location)
                    .addParameter("ranger_id",this.ranger_id)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<Sighting> all(){
        String sql = "SELECT * FROM sighting RETURNING id ;";
        try(Connection con = DB.sql2o.open()) {
            List<Sighting> list = con.createQuery(sql).executeAndFetch(Sighting.class);
            for(Sighting s : list){
                s.getAnimalName();
                s.getRangerName();
            }
            return list;
        }

    }
    public static Sighting find(String location){
        String sql = "SELECT * FROM sighting WHERE location = :location; ";
        try(Connection con = DB.sql2o.open()) {
            return  con.createQuery(sql).addParameter("location",location).executeAndFetchFirst(Sighting.class);
        }
    }
    public static List<Sighting> findall(String location){
        String sql = "SELECT * FROM sighting WHERE location = :location ORDER BY timestamp DESC; ";
        try(Connection con = DB.sql2o.open()) {
            List<Sighting> list = con.createQuery(sql).addParameter("location",location).executeAndFetch(Sighting.class);
            for(Sighting s : list){
                s.getAnimalName();
                s.getRangerName();
            }
            return list;

        }
    }

    public void getAnimalName(){

            Animal animal = Animal.find(this.animal_id);
            this.animal_name = animal.getName();

    }
    public void getRangerName(){
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM ranger WHERE id = :id; ";
            Ranger ranger = con.createQuery(sql)
                    .addParameter("id", this.ranger_id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Ranger.class);
            this.ranger_name = ranger.getName();
            System.out.println(ranger.getName());
        }
    }
}
