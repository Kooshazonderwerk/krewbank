package krew.api;

/**
 * Created by Kush on 13-6-2017.
 */
import org.codehaus.jackson.annotate.JsonProperty;

public class WithdrawResponse {

    @JsonProperty
    private boolean succeeded;
    @JsonProperty
    private long transactieNummer;

    public WithdrawResponse() {
    }

    public WithdrawResponse(boolean succeeded, long transactieNummer) {
        this.setSucceeded(succeeded);
        this.setTransactieNummer(transactieNummer);
    }

    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }

    public long getTransactieNummer() {
        return transactieNummer;
    }

    public void setTransactieNummer(long transactieNummer) {
        this.transactieNummer = transactieNummer;
    }

}