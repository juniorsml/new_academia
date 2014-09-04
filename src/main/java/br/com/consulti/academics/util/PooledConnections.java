package br.com.consulti.academics.util;
// @author Mateus Cordeiro 

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class PooledConnections {

    private static final String URL_DERBY = "jdbc:derby://localhost:1527/academics";
    private static final String USER = "consulTI";
    private static final String PASS = "141202";
    private static final String DRIVER_CLASS = "org.apache.derby.jdbc.ClientDriver";
    public static final Integer MINPOOLSIZE = 1;
    public static final Integer MAXPOOLSIZE = 2;
    //  public static  final Integer MAXSTATEMENTSPERCONNCTION = LoadDataBaseProperties.MAXSTATEMENTSPERCONNCTION;
    private static ComboPooledDataSource pool;

    public PooledConnections() {
    }

    public Connection getConnection() throws SQLException {
        if (pool == null) {
            pool = new ComboPooledDataSource();
            try {
                pool.setDriverClass(DRIVER_CLASS);
            } catch (PropertyVetoException ex) {
                Logger.getLogger("erro").error(PooledConnections.class + " : " + ex);
            }
            pool.setJdbcUrl(URL_DERBY);
            pool.setUser(USER);
            pool.setPassword(PASS);
            pool.setInitialPoolSize(2);
            pool.setMinPoolSize(MINPOOLSIZE);//Minimo de conexões paradas(standby)   
            pool.setAcquireIncrement(1);//   
            pool.setMaxPoolSize(MAXPOOLSIZE);//Maximo de conexões aberta  
            pool.setAcquireRetryAttempts(30);
            pool.setMaxStatementsPerConnection(2);
            pool.setNumHelperThreads(3);
            pool.setLogWriter(null);
        }

        return pool.getConnection();
    }
}