package model;

import Database.DB;
import org.sql2o.Connection;

import java.util.List;

public class NormalAnimal extends Animal{

    public static final String DATABASE_TYPE = "Normal";


    public NormalAnimal(String animalName) {
        super(animalName);
        this.name = animalName;

        type = DATABASE_TYPE;
    }


    @Override
    public void save() {

        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animal (name ,type) values (:name,:type)";
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("name",this.name)
                    .addParameter("type",this.type)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<NormalAnimal> all(){
        String sql = "SELECT * FROM animal WHERE type = 'Normal';";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(NormalAnimal.class);
        }

    }

    public static NormalAnimal find(int id){
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animal WHERE id = :id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(NormalAnimal.class);
        }
    }
}
