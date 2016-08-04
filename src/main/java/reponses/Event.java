package reponses;

import javax.json.JsonValue;

/**
 * Created by Eivind on 04.08.2016.
 */
public class Event implements JsonValue {
    @Override
    public ValueType getValueType() {
        return ValueType.OBJECT;
    }

    int id;                         // 1
    String name;                    // "Gameweek 1"
    String deadline_time;           // "2016-08-13T10:30:00Z"
    String average_entry_score;     // 0
    boolean finished;               // false
    boolean data_checked;           // false
    Integer highest_scoring_entry;  // null
    Integer deadline_time_epoch;    // 1471084200
    int deadline_time_game_offset;  // 3600
    String deadline_time_formatted; // "13 Aug 11:30"
    Integer highest_score;          // null
    
}
