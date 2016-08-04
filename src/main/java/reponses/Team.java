package reponses;

import javax.json.JsonObject;

public class Team {

    int id; // 1
    EventFixture current_event_fixture; // []
    EventFixture next_event_fixture;    // []
    String name;                        // "Arsenal"
    int code;                           // 3
    String short_name;                  // "ARS"
    boolean unavailable;                // false
    int strength;                       //4
    int position;                       //0
    int played;                         //0
    int win;                            //0
    int loss;                           //0
    int draw;                           //0
    int points;                         //0
    String form;                        // null
    String link_url;                    // ""
    int strength_overall_home;          //1240
    int strength_overall_away;          //1325
    int strength_attack_home;           //1200
    int strength_attack_away;           //1375
    int strength_defence_home;          //1300
    int strength_defence_away;          //1315
    int team_division;                  //1

    // Gjør det manuelt pga nesta arrays
    Team(JsonObject json) {
        id = json.getInt("id");
        current_event_fixture = new EventFixture(json.getJsonObject("current_event_fixture"));
        next_event_fixture = new EventFixture(json.getJsonObject("next_event_fixture"));
        name = json.getString("name");
        code = json.getInt("code");
        short_name = json.getString("short_name");
        unavailable = json.getBoolean("unavailable");
        strength = json.getInt("strength");
        position = json.getInt("position");
        played = json.getInt("played");
        win = json.getInt("win");
        loss = json.getInt("loss");
        draw = json.getInt("draw");
        points = json.getInt("points");
        form = json.getString("form");
        link_url = json.getString("link_url");
        strength_overall_home = json.getInt("strength_overall_home");
        strength_overall_away = json.getInt("strength_overall_away");
        strength_attack_home = json.getInt("strength_attack_home");
        strength_attack_away = json.getInt("strength_attack_away");
        strength_defence_home = json.getInt("strength_defence_home");
        strength_defence_away = json.getInt("strength_defence_away");
        team_division = json.getInt("team_division");
    }

    private class EventFixture {
        boolean is_home;    // true
        int day;            // 14
        int event_day;      // 2
        int month;          // 8
        int id;             // 8
        int opponent;       // 9

        EventFixture(JsonObject json) {
            is_home = json.getBoolean("is_home");
            day = json.getInt("day");
            event_day = json.getInt("event_day");
            month = json.getInt("month");
            id = json.getInt("id");
            opponent = json.getInt("opponent");
        }
    }

}
