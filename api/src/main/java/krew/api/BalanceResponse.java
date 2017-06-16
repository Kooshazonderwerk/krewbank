package krew.api;

/**
 * Created by Kush on 13-6-2017.
 */
import org.codehaus.jackson.annotate.JsonProperty;

public class BalanceResponse {

    @JsonProperty
    private long balance;

    public BalanceResponse() {
    }

    public BalanceResponse(long balance) {
        this.setBalance(balance);
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void setRekeningNummer(String rekeningNummer) {
    }
}
