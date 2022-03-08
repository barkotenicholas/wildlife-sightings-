package model;

import Database.DB;
import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class Ranger {
    private int id;
    private String name;
    private int badgeNo;

    public Ranger(String name, int badgeNo) {
        this.name = name;
        this.badgeNo = badgeNo;
    }

    public String getName() {
        return name;
    }

    public int getBadgeNo() {
        return badgeNo;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ranger ranger = (Ranger) o;
        return id == ranger.id && badgeNo == ranger.badgeNo && Objects.equals(name, ranger.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, badgeNo);
    }

    public void save() {

        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO ranger (name ,badgeno ) values (:name,:badgeno)";
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("name",this.name)
                    .addParameter("badgeno",this.badgeNo)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Ranger> all(){
        String sql = "SELECT * FROM ranger --";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Ranger.class);
        }

    }

    public static Ranger find(int id){
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM ranger WHERE id = :id --";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Ranger.class);
        }
    }
}

