package model;

import Database.DB;
import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public  class Animal {
    public String name;
    public int id;
    public String health;
    public String age;
    public String type;

    public Animal(String animalName) {
        this.name = animalName;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
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


    public static Animal find(int id){
        try(Connection con = DB.sql2o.open()) {

            String sql = "SELECT * FROM animal where id =:id --";
            return con.createQuery(sql).addParameter("id",id).executeAndFetchFirst(Animal.class);
        }
    }

    public void update(String newName,int id){

        try(Connection con = DB.sql2o.open()) {
            String sql = "UPDATE animal SET name = :name WHERE id = :id --";
            con.createQuery(sql)
                    .addParameter("name",newName)
                    .addParameter("id",id)
                    .executeUpdate();
        }
    }
}
