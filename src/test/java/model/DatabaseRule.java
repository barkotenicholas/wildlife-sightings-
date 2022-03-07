package model;
import Database.DB;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class DatabaseRule implements  BeforeEachCallback, AfterEachCallback{

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        try(Connection con = DB.sql2o.open()) {
            String deleteAnimalQuery = "DELETE FROM animal *;";
            String deleteRangerQuery = "DELETE FROM ranger *;";
            String deleteSightingQuery = "DELETE FROM sighting *;";
            con.createQuery(deleteAnimalQuery).executeUpdate();
            con.createQuery(deleteRangerQuery).executeUpdate();
            con.createQuery(deleteSightingQuery).executeUpdate();
        }
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "ylmhrirtgiauru", "36cd037470a9096b5a5751975030c4f644b059c371880eb4092b88b78a6b315b");
    }
}
