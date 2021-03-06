package krew.api;

/**
 * Created by Kush on 13-6-2017.
 */

import org.codehaus.jackson.annotate.JsonProperty;


public class CheckPasRequest {
    @JsonProperty
    private int bankID;
    @JsonProperty
    private String pasID;

    public CheckPasRequest() {
    }

    public CheckPasRequest(int bankID, String pasID) {
        this.setBankID(bankID);
        this.setPasID(pasID);
    }

    public int getBankID() {
        return this.bankID;
    }

    public void setBankID(int bankID) {
        this.bankID = bankID;
    }

    public String getPasID() {
        return (this.pasID);
    }

    public void setPasID(String pasID) {
        this.pasID = pasID;
    }
}
