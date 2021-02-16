import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.logging.Logger;

public class EventBus{

    private Logger logger = Logger.getLogger(EventBus.class.getName());

    
    public void publishEvent(boolean tankStatus, String cityName){

        JsonObject object = new JsonObject();
        object.addProperty("Status", tankStatus);
        object.addProperty("City Name", cityName);

        String json = new Gson().toJson(object);

        MessageQueue.sendEvent(json);

        logger.info("Current Status " + json);
    }
}