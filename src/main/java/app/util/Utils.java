package app.util;

import app.data.model.StatusResponse;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

/**
 * Class for utilities.
 */
public class Utils {

    /**
     * Converts a {@link Throwable} into an {@link StatusResponse} if the thrwbl
     * is an {@link HttpException}.
     *
     * @param thrwbl parameter to convert
     * @return an {@link StatusResponse} if can be converted
     */
    public static StatusResponse parseStatusResponse(Throwable thrwbl) {
        if (thrwbl instanceof HttpException) {
            ResponseBody body = ((HttpException) thrwbl).response().errorBody();
            Gson gson = new Gson();
            TypeAdapter<StatusResponse> adapter = gson.getAdapter(StatusResponse.class);
            try {
                StatusResponse statusResponse
                        = adapter.fromJson(body.string());
                return statusResponse;
            } catch (IOException e) {
            }
        }
        return null;
    }

    /**
     * Check if a String is null or empty.
     *
     * @param str String
     * @return true or false depending the String
     */
    public static boolean textIsNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}
