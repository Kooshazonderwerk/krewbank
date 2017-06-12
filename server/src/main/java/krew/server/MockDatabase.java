package krew.server;

/**
 * Created by Kush on 3-4-2017.
 */
class MockDatabase implements Database
{
    public long getBalance(String rekeningNr) {
        return 123456789;
    }

    public boolean withdraw(String rekeningNr, long amount) {
        return true;
    }
}
