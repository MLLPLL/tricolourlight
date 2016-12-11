package aaa;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ThinkPad on 2016/12/7.
 */
public class TestMain {
    public static void main(String[] strs) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "{\"name\" : \"mkyong\"}";

//Object to JSON in file
        Map map = mapper.readValue(new File("e:\\test.json"),Map.class);

        map = mapper.readValue(jsonInString,Map.class);

        map.entrySet();
//Object to JSON in String
//        String jsonInString = mapper.writeValueAsString(obj);
    }
}
