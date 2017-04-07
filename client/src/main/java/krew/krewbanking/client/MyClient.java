package krew.krewbanking.client;

/**
 * Created by Kush on 7-4-2017.
 */
//import krew.krewbanking.api.*;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.*;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * Created by elvira on 24-03-17.
 */
public class MyClient
{
    private Client client;
    private WebTarget target;


    public MyClient(int port)
    {
        client  = ClientBuilder.newClient().register(JacksonFeature.class);
        target  = client.target("http://145.24.222.127:" + port);
    }

    public static void main(String[] args)
    {

        MyClient client = new MyClient(8025);
        WithdrawRequest request = new WithdrawRequest();
        request.setIBAN("1234");
        request.setAmount(10);

        System.out.println("Saldo op rekening nummer " + request.getIBAN() + " is "
                +client.balance(request.getIBAN()).getBalance() + " euro.");

        System.out.println("U wilt " + request.getAmount() + " euro pinnen. ");
        WithdrawResponse response = client.withdraw(request);
        System.out.println(response.toString());

    }

    public BalanceResponse balance(String IBAN)
    {
        BalanceResponse response = target
                .path("/balance/" + IBAN)
                .request(MediaType.APPLICATION_JSON)
                .get(BalanceResponse.class);

        return response;
    }

    private WithdrawResponse withdraw(WithdrawRequest request)
    {


        WithdrawResponse response = target
                .path("withdraw")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(request, MediaType.APPLICATION_JSON), WithdrawResponse.class);

        return response;
    }
}