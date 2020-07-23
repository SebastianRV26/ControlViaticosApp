package app.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * This data class represents response from the server.
 */
public class StatusResponse {

    @SerializedName("statusCode")
    int statusCode;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusResponse) {
        this.statusCode = statusResponse;
    }

    @Override
    public String toString() {
        return "StatusCode{" + "statusCode=" + statusCode + '}';
    }
}
