package ec.edu.ups.ExamenVeletangaVinicioServidor.utils;

import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.SQLException;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import com.sun.org.slf4j.internal.LoggerFactory;

public class Resources {

	String dsName = "java:jboss/datasources/ExamenVeletangaVinicioServidorDS";

    @Produces
    private Connection createConnection() throws SQLException, NamingException {
        InitialContext ic = new InitialContext();
        DataSource ds = (DataSource)ic.lookup(dsName);
        return ds.getConnection();
    }
    
    private void closeConnection(@Disposes Connection conn) throws SQLException {
        conn.close();
    }
    
    @Produces	
    @PersistenceContext(name = "ExamenVeletangaVinicioServidorPersistenceUnit")
    private EntityManager em;  

//  @Produces
//  public Logger produceLog(InjectionPoint injectionPoint) {
//  	
//  	return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
//  }
}

