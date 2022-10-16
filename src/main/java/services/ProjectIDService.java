package services;

import api.model.Project.ProjectResponse;
import com.crowdar.api.rest.Response;

import java.util.HashMap;
import java.util.Map;

public class ProjectIDService extends BaseService {
    public static Response get(String jsonName) {
        return get(jsonName, ProjectResponse[].class, setParams());
    }

    public static Response put(String jsonName) {
        return put(jsonName, ProjectResponse.class, setParamsPut(setParams()));
    }


    private static Map<String, String> setParams() {
        Map<String, String> params = new HashMap<>();
        params.put("api-key", API_KEY.get());
        return params;

    }

    private static Map<String, String> setParamsPut(Map<String, String> params) {
        params.put("name", NAME.get());
        return params;

    }
}
