package krew.server;

/**
 * Created by Kush on 3-4-2017.
 */
public interface Database
{
    long getBalance(String rekeningNr);
    boolean withdraw(String rekeningNr, long amount);
}
