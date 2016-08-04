package reponses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import fpl_base.Util;

import javax.json.JsonValue;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class Element implements JsonValue {

    @Override
    public ValueType getValueType() {
        return ValueType.OBJECT;
    }

    int id;             // 1
    String photo;           // "48844.jpg"
    String web_name;        // "Ospina"
    String status;          // "a"
    int code;           // 48844
    String first_name;      // "David"
    String second_name;     // "Ospina"
    int squad_number;   // ;  // 13
    String news;            //""
    String now_cost;        //;  // 50
    String chance_of_playing_this_round;    // null
    String chance_of_playing_next_round;    //;  // null" +
    double value_form; //;  // "0.0"
    double value_season; //;  // "0.0"
    double cost_change_start;//;  // 0
    
    // doubles eller ints?
    double cost_change_event;       // 0
    double cost_change_start_fall;  // 0
    double cost_change_event_fall;  // 0
    
    boolean in_dreamteam;           // false 
    int dreamteam_count;            // 0
    double selected_by_percent;     // 0.1
    double form;                    // 0.0
    int transfers_out;              // 0
    int transfers_in;               // 0
    int transfers_out_event;        // 0
    int transfers_in_event;         // 0
    int loans_in;                   // 0
    int loans_out;                  // 0
    int loaned_in;                  // 0
    int loaned_out;                 // 0
    int total_points;               // 20
    int event_points;               // 0
    double points_per_game;         // "5.0"
    
    // doubles?
    Double ep_this;                 // null
    Double ep_next;                 // "3.2"

    boolean special;// false
    int minutes;    // 360
    int goals_scored;// 0
    int assists;  // 0
    int clean_sheets;  // 2
    int goals_conceded;  // 5
    int own_goals;  // 0
    int penalties_saved;  // 0
    int penalties_missed;  // 0
    int yellow_cards;  // 0
    int red_cards;  // 0
    int saves;  // 17
    int bonus;  // 2
    int bps;  // 98
    double influence;  // "108.6"
    double creativity;  // "0.0"
    double threat;  // "0.0"
    double ict_index;  // "10.9"
    int ea_index;  // 56
    int element_type;  // 1
    int team;  // 1

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
