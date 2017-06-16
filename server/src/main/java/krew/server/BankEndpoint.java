package krew.server;

import krew.api.BalanceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

;



/**
 * Created by Kush on 3-4-2017.
 */

@Path("/")
public class BankEndpoint {
    public static final Logger logger = LoggerFactory.getLogger(BankEndpoint.class);

    /*
    * Mogelijk Http methodes
    * GET      - get something from the server
    * POST     - create something new on the server
    * PUT      - update something on the server
    * DELETE   - remover something from the server
    */
    @GET
    @Path("/balance/{rekeningNr}")
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public BalanceResponse getSaldo(@PathParam("rekeningNr") String rekeningNummer) {
        Database db = Server.getDatabase();
        logger.trace("In the BankEndpoint::getSaldo()");

        BalanceResponse balanceResponse = new BalanceResponse();
        balanceResponse.setBalance(db.getBalance(rekeningNummer));
        balanceResponse.setRekeningNummer(rekeningNummer);

        return balanceResponse;
    }
}

