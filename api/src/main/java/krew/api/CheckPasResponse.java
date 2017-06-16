package krew.api;

import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Created by Kush on 13-6-2017.
 */


public class CheckPasResponse {

    @JsonProperty
    private boolean doesExist;
    @JsonProperty
    private boolean blocked;

    public CheckPasResponse() {
    }

    public CheckPasResponse(boolean doesExist, boolean blocked) {
        this.setDoesExist(doesExist);
        this.setBlocked(blocked);
    }

    public boolean doesExist() {
        return doesExist;
    }

    public void setDoesExist(boolean doesExist) {
        this.doesExist = doesExist;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

}