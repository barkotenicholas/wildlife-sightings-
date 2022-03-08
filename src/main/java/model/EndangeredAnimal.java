package model;

import Database.DB;
import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class EndangeredAnimal  extends Animal{

    public String health;
    public String age;
    public static final String DATABASE_TYPE = "Endangered";


    public EndangeredAnimal(String animalName, String health, String age) {
        super(animalName);
        this.name = animalName;
        this.health = health;
        this.age = age;
        type = DATABASE_TYPE;
    }

    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }


    @Override
    public void save() {

        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animal (name ,type,health,age) values (:name,:type,:health,:age)";
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("name",this.name)
                    .addParameter("type",this.type)
                    .addParameter("health",this.health)
                    .addParameter("age",this.age)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<EndangeredAnimal> all(){
            String sql = "SELECT * FROM animal WHERE type = 'Endangered' ";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(EndangeredAnimal.class);
        }

    }

    public static EndangeredAnimal find(int id){
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animal WHERE id = :id ";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(EndangeredAnimal.class);
        }
    }
}
