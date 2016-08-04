package reponses;

import com.fasterxml.jackson.core.JsonProcessingException;
import fpl_base.Util;

import javax.json.JsonValue;

/**
 * Created by Eivind on 04.08.2016.
 */
public class Phase implements JsonValue {
    Integer id;          // 1
    String name;         // "Overall"
    Integer start_event; // 1
    Integer stop_event;  // 38

    @Override
    public ValueType getValueType() {
        return ValueType.OBJECT;
    }

    @Override
    public String toString() {
        try {
            return Util.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error serializing Element";
        }
    }
}
