package services;

import com.crowdar.api.rest.MethodsService;
import io.cucumber.java8.Th;

public class BaseService extends MethodsService {

    public static final ThreadLocal<String> API_KEY = new ThreadLocal<String>();

    public static final ThreadLocal<String> ID = new ThreadLocal<String>();
    public static final ThreadLocal<String> NAME = new ThreadLocal<String>();

}
