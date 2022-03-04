package model;

import Database.DB;
import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class Animal {
    private String name;
    private int id;

    public Animal(String animalName) {
        this.name = animalName;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void save(){

        try(Connection con = DB.sql2o.open()) {
        String sql = "INSERT INTO animal (name) values (:name)";
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("name",this.name)
                    .executeUpdate()
                    .getKey();
        }

    }

    public static List<Animal> all(){

        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT  * FROM animal";
            return con.createQuery(sql).executeAndFetch(Animal.class);
        }

    }
    public static Animal find(int id){
        try(Connection con = DB.sql2o.open()) {

            String sql = "SELECT * FROM animal where id =:id";
            return con.createQuery(sql).addParameter("id",id).executeAndFetchFirst(Animal.class);
        }
    }
}
