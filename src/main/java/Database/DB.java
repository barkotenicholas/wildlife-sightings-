package Database;

import org.sql2o.Sql2o;

import java.net.URI;
import java.net.URISyntaxException;

public class DB {
    private static URI dbUri;
    public static Sql2o sql2o;

    static {

        try {
            if (System.getenv("DATABASE_URL") == null) {
                dbUri = new URI("jdbc:postgresql://localhost:5432/ddepip3jbbu866");
            } else {
                dbUri = new URI(System.getenv("DATABASE_URL"));
            }

            int port = dbUri.getPort();
            String host = dbUri.getHost();
            String path = dbUri.getPath();
            String username = (dbUri.getUserInfo() == null) ? "mkuxykkugosllg" : dbUri.getUserInfo().split(":")[0];
            String password = (dbUri.getUserInfo() == null) ? "649267604842a97d797c070f08b6b2003fcd0fce6b3b059886373431c642759b" : dbUri.getUserInfo().split(":")[1];

            sql2o = new Sql2o("postgresql://" + host + ":" + port + path, username, password);
        } catch (URISyntaxException e ) {
        }
    }
}
