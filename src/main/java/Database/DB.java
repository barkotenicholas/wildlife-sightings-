package Database;

import org.sql2o.Sql2o;
import org.sql2o.converters.UUIDConverter;
import org.sql2o.quirks.NoQuirks;
import org.sql2o.quirks.PostgresQuirks;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

public class DB {

    private static URI dbUri;
    public static Sql2o sql2o;

    static {

        try {
            if (System.getenv("DATABASE_URL") == null) {
                dbUri = new URI("postgres://localhost:5432/wildlife_tracker_test");
            } else {
                dbUri = new URI(System.getenv("DATABASE_URL"));
            }


            int port = dbUri.getPort();
            String host = dbUri.getHost();
            String path = dbUri.getPath();
            String username = (dbUri.getUserInfo() == null) ? "ylmhrirtgiauru" : dbUri.getUserInfo().split(":")[0];
            String password = (dbUri.getUserInfo() == null) ? "36cd037470a9096b5a5751975030c4f644b059c371880eb4092b88b78a6b315b" : dbUri.getUserInfo().split(":")[1];

            sql2o = new Sql2o("postgresql://" + host + ":" + port + path, username, password,new PostgresQuirks());
        } catch (URISyntaxException e ) {
        }
    }
}


