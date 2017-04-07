package krew.krewbanking.api;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by Kush on 7-4-2017.
 */

public class WithdrawRequest
{
    @JsonProperty
    private String IBAN;
    @JsonProperty
    private long amount;

    public WithdrawRequest()
    {
    }
    public String getIBAN()
    {
        return IBAN;
    }

    public void setIBAN(String IBAN)
    {
        this.IBAN = IBAN;
    }

    public long getAmount()
    {
        return amount;
    }

    public void setAmount(long amount)
    {
        this.amount = amount;
    }
}