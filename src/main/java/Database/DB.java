package Database;

import org.sql2o.Sql2o;
import org.sql2o.converters.Converter;
import org.sql2o.converters.UUIDConverter;
import org.sql2o.quirks.NoQuirks;
import org.sql2o.quirks.PostgresQuirks;
import org.sql2o.quirks.Quirks;
import org.sql2o.quirks.parameterparsing.SqlParameterParsingStrategy;

import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
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

            sql2o = new Sql2o("postgresql://" + host + ":" + port + path, username, password, new Quirks() {
                @Override
                public <E> Converter<E> converterOf(Class<E> ofClass) {
                    return null;
                }

                @Override
                public String getColumnName(ResultSetMetaData meta, int colIdx) throws SQLException {
                    return null;
                }

                @Override
                public boolean returnGeneratedKeysByDefault() {
                    return false;
                }

                @Override
                public void setParameter(PreparedStatement statement, int paramIdx, Object value) throws SQLException {

                }

                @Override
                public void setParameter(PreparedStatement statement, int paramIdx, InputStream value) throws SQLException {

                }

                @Override
                public void setParameter(PreparedStatement statement, int paramIdx, int value) throws SQLException {

                }

                @Override
                public void setParameter(PreparedStatement statement, int paramIdx, Integer value) throws SQLException {

                }

                @Override
                public void setParameter(PreparedStatement statement, int paramIdx, long value) throws SQLException {

                }

                @Override
                public void setParameter(PreparedStatement statement, int paramIdx, Long value) throws SQLException {

                }

                @Override
                public void setParameter(PreparedStatement statement, int paramIdx, String value) throws SQLException {

                }

                @Override
                public void setParameter(PreparedStatement statement, int paramIdx, Timestamp value) throws SQLException {

                }

                @Override
                public void setParameter(PreparedStatement statement, int paramIdx, Time value) throws SQLException {

                }

                @Override
                public void setParameter(PreparedStatement statement, int paramIdx, boolean value) throws SQLException {

                }

                @Override
                public void setParameter(PreparedStatement statement, int paramIdx, Boolean value) throws SQLException {

                }

                @Override
                public void setParameter(PreparedStatement statement, int paramIdx, UUID value) throws SQLException {

                }

                @Override
                public Object getRSVal(ResultSet rs, int idx) throws SQLException {
                    return null;
                }

                @Override
                public void closeStatement(Statement statement) throws SQLException {

                }

                @Override
                public SqlParameterParsingStrategy getSqlParameterParsingStrategy() {
                    return null;
                }
            });
        } catch (URISyntaxException e ) {
        }
    }
}


