package krew.server;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;


/**
 * Created by Kush on 3-4-2017.
 */
public class Databaseimpl implements Database {
    private static final Logger logger = LoggerFactory.getLogger(Databaseimpl.class);
    private Connection con;
    private String host;
    private String uName;
    private String uPass;
    private ResultSet rs;

    public Databaseimpl() {

        this.con = null;
        this.host = "jdbc:mysql://localhost:3306/Bankaccount?serverTimezone=UTC";
        this.uName = "root";
        this.uPass = "Project3";
        this.rs = null;

        this.connect();
    }

    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(host, uName, uPass);
            logger.info("Connection to the database is established.");


        } catch (Exception e) {
            logger.error("Class not found, connection to the database failed", e);
            logger.error("Probleem komt door de Driver die niet goed is of de wachtwoord en gebruikersnaam!");
        }
    }

    @Override
    public long getBalance(String rekeningNr) {
        long saldo = 0;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT saldo FROM Bankaccount.klant WHERE Bankaccount.klant.IBAN = ?");

            ps.setString(1, rekeningNr);

            rs = ps.executeQuery();
            rs.next();
            saldo = rs.getLong("saldo =");
            logger.debug("saldo =" + saldo);
        } catch (SQLException e) {
            logger.error("execution of query select saldo failed.", e);
        }

        return saldo;
    }

    @Override
    public boolean withdraw(String rekeningNr, long amount)
    {
        try {
            long saldo = getBalance(rekeningNr);

            if (saldo > amount) {
                logger.debug("rekening nummer:{}\t saldo :{}", rekeningNr, saldo);

                PreparedStatement ps = con.prepareStatement("UPDATE klant SET saldo = ? WHERE IBAN = ?");

                ps.setLong(1, (saldo - amount));
                ps.setString(2, rekeningNr);

                boolean result = ps.execute();

                if (logger.isDebugEnabled()) {
                    logger.debug("Nieuwe saldo: {}", getBalance(rekeningNr));
                }

                return result;
            }
            logger.debug("saldo is ontoereikend");
            return false;
        } catch (SQLException e) {
            logger.error("Execution of query withdraw failed", e);
        }
        return false;
    }
}
