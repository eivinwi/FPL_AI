package reponses;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.*;

/**
 * Warning; ugly code. Do not read it. Or read it, whatever.
 */
public class GameSettings implements JsonValue {

    @Override
    public ValueType getValueType() {
        return ValueType.OBJECT;
    }

    @Override
    public String toString() {
        return game.toString() + "," + element_types.toString();
    }


    Map<String, ElementType> element_types;
    Game game;

    public GameSettings(JsonObject json) {

        game = new Game(json.getJsonObject("game"));

        element_types = new HashMap<>();
        JsonObject elementTypes = json.getJsonObject("element_type");

        for(String key : elementTypes.keySet()) {
            element_types.put(key, new ElementType(key, elementTypes.getJsonObject(key)));
        }
    }

    private class Game {

        @Override
        public String toString() {
            ObjectMapper om = new ObjectMapper();
            try {
                return om.writeValueAsString(this);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return "Error during toString on Game.";
        }

        private int scoring_ea_index;                   // 0
        private String league_prefix_public;            // "League"
        private int league_size_h2h_max;                // 20
        private int bps_tackles;                        // 2
        private String league_h2h_tiebreak;             // "+goals_scored||-goals_conceded"
        private int scoring_long_play;                  // 2
        private int bps_recoveries_limit;               // 3
        private String facebook_app_id;                 // "337309029685327"
        private int bps_tackled;                        // -1
        private boolean sys_vice_captain_enabled;       // true
        private int squad_squadplay;                    // 11
        private int bps_errors_leading_to_goal;         // -3
        private int bps_yellow_cards;                   // -3
        private boolean ui_el_hide_currency_qi;         // true
        private int scoring_bonus;                      // 1
        private int bps_fouls;                          // -1
        private int squad_squadsize;                    // 15
        private int transfers_cost;                     // 4
        private boolean ui_selection_short_team_names;  // true
        private int scoring_short_play;                 // 1
        private double transfers_sell_on_fee;           // 0.5
        private String transfers_type;                  // "cost"
        private int bps_long_play;                      // 6
        private int bps_long_play_limit;                // 60
        private int scoring_assists;                    // 3
        private int bps_pass_percentage_80;             // 4
        private int bps_own_goals;                      // -6
        private int scoring_long_play_limit;            // 60
        private int bps_pass_percentage_70;             // 2
        private boolean ui_show_home_away;              // true
        private boolean ui_el_hide_currency_sy;         // true
        private int fifa_league_id;                     // 1749
        private int bps_assists;                        // 9
        private int league_size_classic_max;            // 20
        private int bps_big_chances_created;            // 3
        private int scoring_red_cards;                  // -3
        private int squad_team_limit;                   // 3
        private int league_points_h2h_draw;             // 1
        private int transfers_limit;                    // 1
        private int scoring_penalties_saved;            // 5
        private int scoring_yellow_cards;               // -1
        private String game_timezone;                   // "Europe/London"
        private String static_game_url;                 // "https://ismdj.scdn5.secure.raxcdn.com/static/compass/plfpl/desktop/"
        private String currency_symbol;                 // "Â£"
        private int bps_target_missed;                  // -1
        private int bps_dribbles;                       // 1
        private int perform_league_id;                  // 156746
        private int bps_penalties_saved;                // 15
        private String support_email_address;           // "plfpl@mail.fantasy.premierleague.com"
        private int bps_offside;                        // -1
        private int cup_start_event_id;                 // 18
        private boolean sys_cdn_cache_enabled;          // true
        private int currency_multiplier;                // 10
        private int bps_red_cards;                      // -9
        private int bps_winning_goals;                  // 3
        private int scoring_saves;                      // 1
        private int league_join_private_max;            // 15
        private int league_join_public_max;             // 3
        private Formations formations;

        private int league_points_h2h_lose;             // 0
        private int currency_decimal_places;            // 1
        private int bps_errors_leading_to_goal_attempt; // -1
        private boolean sys_use_event_live_api;         // true
        private int ui_selection_price_gap;             // 5
        private int scoring_concede_limit;              // 2
        private Formation default_formation;
        private int ui_selection_player_limit;          // 30
        private int bps_key_passes;                     // 1
        private int bps_attempted_passes_limit;         // 30
        private int scoring_penalties_missed;           // -2
        private String photo_base_url;                  // "https://ismdj.scdn5.secure.raxcdn.com/static/plfpl/img/shirts/photos/"
        private int scoring_bps;                        // 0
        private int bps_penalties_missed;               // -6
        private int bps_penalties_conceded;             // -3
        private int scoring_own_goals;                  // -2
        private int squad_total_spend;                  // 1000
        private int bps_clearances_blocks_interceptions;// 1
        private int bps_short_play;                     // 3
        private int ui_element_wrap;                    // 0
        private int bps_pass_percentage_90;             // 6
        private int bps_big_chances_missed;             // -3
        private int league_max_ko_rounds_h2h;           // 3
        private int bps_recoveries;                     // 1
        private int bps_open_play_crosses;              // 1
        private int league_points_h2h_win;              // 3
        private int bps_saves;                          // 2
        private int bps_cbi_limit;                      // 2
        private int scoring_saves_limit;                // 3

        Game(JsonObject json) {
            scoring_ea_index = json.getInt("scoring_ea_index");
            league_prefix_public = json.getString("league_prefix_public");
            league_size_h2h_max = json.getInt("league_size_h2h_max");
            bps_tackles = json.getInt("bps_tackles");
            league_h2h_tiebreak = json.getString("league_h2h_tiebreak");
            scoring_long_play = json.getInt("scoring_long_play");
            bps_recoveries_limit = json.getInt("bps_recoveries_limit");
            facebook_app_id = json.getString("facebook_app_id");
            bps_tackled = json.getInt("bps_tackled");
            sys_vice_captain_enabled = json.getBoolean("sys_vice_captain_enabled");
            squad_squadplay = json.getInt("squad_squadplay");
            bps_errors_leading_to_goal = json.getInt("bps_errors_leading_to_goal");
            bps_yellow_cards = json.getInt("bps_yellow_cards");
            ui_el_hide_currency_qi = json.getBoolean("ui_el_hide_currency_qi");
            scoring_bonus = json.getInt("scoring_bonus");
            bps_fouls = json.getInt("bps_fouls");
            squad_squadsize = json.getInt("squad_squadsize");
            transfers_cost = json.getInt("transfers_cost");
            ui_selection_short_team_names = json.getBoolean("ui_selection_short_team_names");
            scoring_short_play = json.getInt("scoring_short_play");
            transfers_sell_on_fee = json.getInt("transfers_sell_on_fee");
            transfers_type = json.getString("transfers_type");
            bps_long_play = json.getInt("bps_long_play");
            bps_long_play_limit = json.getInt("bps_long_play_limit");
            scoring_assists = json.getInt("scoring_assists");
            bps_pass_percentage_80 = json.getInt("bps_pass_percentage_80");
            bps_own_goals = json.getInt("bps_own_goals");
            scoring_long_play_limit = json.getInt("scoring_long_play_limit");
            bps_pass_percentage_70 = json.getInt("bps_pass_percentage_70");
            ui_show_home_away = json.getBoolean("ui_show_home_away");
            ui_el_hide_currency_sy = json.getBoolean("ui_el_hide_currency_sy");
            fifa_league_id = json.getInt("fifa_league_id");
            bps_assists = json.getInt("bps_assists");
            league_size_classic_max = json.getInt("league_size_classic_max");
            bps_big_chances_created = json.getInt("bps_big_chances_created");
            scoring_red_cards = json.getInt("scoring_red_cards");
            squad_team_limit = json.getInt("squad_team_limit");
            league_points_h2h_draw = json.getInt("league_points_h2h_draw");
            transfers_limit = json.getInt("transfers_limit");
            scoring_penalties_saved = json.getInt("scoring_penalties_saved");
            scoring_yellow_cards = json.getInt("scoring_yellow_cards");
            game_timezone = json.getString("game_timezone");
            static_game_url = json.getString("static_game_url");
            currency_symbol = json.getString("currency_symbol");
            bps_target_missed = json.getInt("bps_target_missed");
            bps_dribbles = json.getInt("bps_dribbles");
            perform_league_id = json.getInt("perform_league_id");
            bps_penalties_saved = json.getInt("bps_penalties_saved");
            support_email_address = json.getString("support_email_address");
            bps_offside = json.getInt("bps_offside");
            cup_start_event_id = json.getInt("cup_start_event_id");
            sys_cdn_cache_enabled = json.getBoolean("sys_cdn_cache_enabled");
            currency_multiplier = json.getInt("currency_multiplier");
            bps_red_cards = json.getInt("bps_red_cards");
            bps_winning_goals = json.getInt("bps_winning_goals");
            scoring_saves = json.getInt("scoring_saves");
            league_join_private_max = json.getInt("league_join_private_max");
            league_join_public_max = json.getInt("league_join_public_max");

            formations = new Formations(json.getJsonObject("formations"));

            league_points_h2h_lose = json.getInt("league_points_h2h_lose");
            currency_decimal_places = json.getInt("currency_decimal_places");
            bps_errors_leading_to_goal_attempt = json.getInt("bps_errors_leading_to_goal_attempt");
            sys_use_event_live_api = json.getBoolean("sys_use_event_live_api");
            ui_selection_price_gap = json.getInt("ui_selection_price_gap");
            scoring_concede_limit = json.getInt("scoring_concede_limit");
            ui_selection_player_limit = json.getInt("ui_selection_player_limit");
            bps_key_passes = json.getInt("bps_key_passes");
            bps_attempted_passes_limit = json.getInt("bps_attempted_passes_limit");
            scoring_penalties_missed = json.getInt("scoring_penalties_missed");
            photo_base_url = json.getString("photo_base_url");
            scoring_bps = json.getInt("scoring_bps");
            bps_penalties_missed = json.getInt("bps_penalties_missed");
            bps_penalties_conceded = json.getInt("bps_penalties_conceded");
            scoring_own_goals = json.getInt("scoring_own_goals");
            squad_total_spend = json.getInt("squad_total_spend");
            bps_clearances_blocks_interceptions = json.getInt("bps_clearances_blocks_interceptions");
            bps_short_play = json.getInt("bps_short_play");
            ui_element_wrap = json.getInt("ui_element_wrap");
            bps_pass_percentage_90 = json.getInt("bps_pass_percentage_90");
            bps_big_chances_missed = json.getInt("bps_big_chances_missed");
            league_max_ko_rounds_h2h = json.getInt("league_max_ko_rounds_h2h");
            bps_recoveries = json.getInt("bps_recoveries");
            bps_open_play_crosses = json.getInt("bps_open_play_crosses");
            league_points_h2h_win = json.getInt("league_points_h2h_win");
            bps_saves = json.getInt("bps_saves");
            bps_cbi_limit = json.getInt("bps_cbi_limit");
            scoring_saves_limit = json.getInt("scoring_saves_limit");

            default_formation = new Formation(json.getJsonArray("default_formation"));
        }

        public int getScoring_ea_index() { return scoring_ea_index; }

        public String getLeague_prefix_public() { return league_prefix_public; }

        public int getLeague_size_h2h_max() { return league_size_h2h_max; }

        public int getBps_tackles() { return bps_tackles; }

        public String getLeague_h2h_tiebreak() { return league_h2h_tiebreak; }

        public int getScoring_long_play() { return scoring_long_play; }

        public int getBps_recoveries_limit() { return bps_recoveries_limit; }

        public String getFacebook_app_id() { return facebook_app_id; }

        public int getBps_tackled() { return bps_tackled; }

        public boolean isSys_vice_captain_enabled() { return sys_vice_captain_enabled; }

        public int getSquad_squadplay() { return squad_squadplay; }

        public int getBps_errors_leading_to_goal() { return bps_errors_leading_to_goal; }

        public int getBps_yellow_cards() { return bps_yellow_cards; }

        public boolean isUi_el_hide_currency_qi() { return ui_el_hide_currency_qi; }

        public int getScoring_bonus() { return scoring_bonus; }

        public int getBps_fouls() { return bps_fouls; }

        public int getSquad_squadsize() { return squad_squadsize; }

        public int getTransfers_cost() { return transfers_cost; }

        public boolean isUi_selection_short_team_names() { return ui_selection_short_team_names; }

        public int getScoring_short_play() { return scoring_short_play; }

        public double getTransfers_sell_on_fee() { return transfers_sell_on_fee; }

        public String getTransfers_type() { return transfers_type; }

        public int getBps_long_play() { return bps_long_play; }

        public int getBps_long_play_limit() { return bps_long_play_limit; }

        public int getScoring_assists() { return scoring_assists; }

        public int getBps_pass_percentage_80() { return bps_pass_percentage_80; }

        public int getBps_own_goals() { return bps_own_goals; }

        public int getScoring_long_play_limit() { return scoring_long_play_limit; }

        public int getBps_pass_percentage_70() { return bps_pass_percentage_70; }

        public boolean isUi_show_home_away() { return ui_show_home_away; }

        public boolean isUi_el_hide_currency_sy() { return ui_el_hide_currency_sy; }

        public int getFifa_league_id() { return fifa_league_id; }

        public int getBps_assists() { return bps_assists; }

        public int getLeague_size_classic_max() { return league_size_classic_max; }

        public int getBps_big_chances_created() { return bps_big_chances_created; }

        public int getScoring_red_cards() { return scoring_red_cards; }

        public int getSquad_team_limit() { return squad_team_limit; }

        public int getLeague_points_h2h_draw() { return league_points_h2h_draw; }

        public int getTransfers_limit() { return transfers_limit; }

        public int getScoring_penalties_saved() { return scoring_penalties_saved; }

        public int getScoring_yellow_cards() { return scoring_yellow_cards; }

        public String getGame_timezone() { return game_timezone; }

        public String getStatic_game_url() { return static_game_url; }

        public String getCurrency_symbol() { return currency_symbol; }

        public int getBps_target_missed() { return bps_target_missed; }

        public int getBps_dribbles() { return bps_dribbles; }

        public int getPerform_league_id() { return perform_league_id; }

        public int getBps_penalties_saved() { return bps_penalties_saved; }

        public String getSupport_email_address() { return support_email_address; }

        public int getBps_offside() { return bps_offside; }

        public int getCup_start_event_id() { return cup_start_event_id; }

        public boolean isSys_cdn_cache_enabled() { return sys_cdn_cache_enabled; }

        public int getCurrency_multiplier() { return currency_multiplier; }

        public int getBps_red_cards() { return bps_red_cards; }

        public int getBps_winning_goals() { return bps_winning_goals; }

        public int getScoring_saves() { return scoring_saves; }

        public int getLeague_join_private_max() { return league_join_private_max; }

        public int getLeague_join_public_max() { return league_join_public_max; }

        public Formations getFormations() { return formations; }

        public int getLeague_points_h2h_lose() { return league_points_h2h_lose; }

        public int getCurrency_decimal_places() { return currency_decimal_places; }

        public int getBps_errors_leading_to_goal_attempt() { return bps_errors_leading_to_goal_attempt; }

        public boolean isSys_use_event_live_api() { return sys_use_event_live_api; }

        public int getUi_selection_price_gap() { return ui_selection_price_gap; }

        public int getScoring_concede_limit() { return scoring_concede_limit; }

        public Formation getDefault_formation() { return default_formation; }

        public int getUi_selection_player_limit() { return ui_selection_player_limit; }

        public int getBps_key_passes() { return bps_key_passes; }

        public int getBps_attempted_passes_limit() { return bps_attempted_passes_limit; }

        public int getScoring_penalties_missed() { return scoring_penalties_missed; }

        public String getPhoto_base_url() { return photo_base_url; }

        public int getScoring_bps() { return scoring_bps; }

        public int getBps_penalties_missed() { return bps_penalties_missed; }

        public int getBps_penalties_conceded() { return bps_penalties_conceded; }

        public int getScoring_own_goals() { return scoring_own_goals; }

        public int getSquad_total_spend() { return squad_total_spend; }

        public int getBps_clearances_blocks_interceptions() { return bps_clearances_blocks_interceptions; }

        public int getBps_short_play() { return bps_short_play; }

        public int getUi_element_wrap() { return ui_element_wrap; }

        public int getBps_pass_percentage_90() { return bps_pass_percentage_90; }

        public int getBps_big_chances_missed() { return bps_big_chances_missed; }

        public int getLeague_max_ko_rounds_h2h() { return league_max_ko_rounds_h2h; }

        public int getBps_recoveries() { return bps_recoveries; }

        public int getBps_open_play_crosses() { return bps_open_play_crosses; }

        public int getLeague_points_h2h_win() { return league_points_h2h_win; }

        public int getBps_saves() { return bps_saves; }

        public int getBps_cbi_limit() { return bps_cbi_limit; }

        public int getScoring_saves_limit() { return scoring_saves_limit; }


        private class Formations {

            private Map<String, Formation> formations = new HashMap<>();

            Formations(JsonObject json) {
                Set<String> keys = json.keySet();

                for(String key : keys) {
                    JsonArray formation = json.getJsonArray(key);
                    formations.put(key, new Formation(formation));
                }
            }

            public Map<String, Formation> getFormations() { return formations; }

            public Formation getFormation(int name) {
                return formations.get(name);
            }

            @Override
            public String toString() {
                return formations.toString();
            }
        }
    }

    private class Formation {
        private int[][] formation;

        Formation(JsonArray json) {
            int x = json.size();
            int y = json.getJsonArray(0).size();
            formation = new int[x][y];

            for(int i = 0; i < json.size(); i++) {
                JsonArray inner = json.getJsonArray(i);
                for(int j = 0; j < inner.size(); j++) {
                    formation[i][j] = inner.getInt(j);
                }
            }
        }

        public int[][] getFormation() { return formation; }

        @Override
        public String toString() {
            return Arrays.deepToString(formation);
        }
    }

    private class ElementType {
        private int scoring_clean_sheets;   // 4
        private int squad_min_play;         // 1
        private int scoring_goals_conceded; // -1
        private int scoring_goals_scored;   // 6
        private int squad_max_play;         // 1
        private int squad_select;           // 2
        private int bps_clean_sheets;       // 12

        private int bps_goals_scored;       // 12
        private boolean ui_shirt_specific;  // true
        private Integer[] sub_positions_locked; // [ 12 ]

        public ElementType(String type, JsonObject json) {
            scoring_clean_sheets = json.getInt("scoring_clean_sheets");
            squad_min_play = json.getInt("squad_min_play");
            scoring_goals_conceded = json.getInt("scoring_goals_conceded");
            scoring_goals_scored = json.getInt("scoring_goals_scored");
            squad_max_play = json.getInt("squad_max_play");
            bps_goals_scored = json.getInt("bps_goals_scored");
            bps_clean_sheets = json.getInt("bps_clean_sheets");
            squad_select = json.getInt("squad_select");

            //GK
            if(type.equals("1")) {
                ui_shirt_specific = json.getBoolean("ui_shirt_specific");
                JsonArray subPositionsLocked = json.getJsonArray("sub_positions_locked");
                sub_positions_locked = new Integer[subPositionsLocked.size()];
                for (int i = 0; i < subPositionsLocked.size(); i++) {
                    sub_positions_locked[i] = subPositionsLocked.getInt(i);
                }
            }
        }

        public int getScoring_clean_sheets() { return scoring_clean_sheets; }

        public int getSquad_min_play() { return squad_min_play; }

        public int getScoring_goals_conceded() { return scoring_goals_conceded; }

        public int getScoring_goals_scored() { return scoring_goals_scored; }

        public int getSquad_max_play() { return squad_max_play; }

        public int getSquad_select() { return squad_select; }

        public int getBps_clean_sheets() { return bps_clean_sheets; }

        public int getBps_goals_scored() { return bps_goals_scored; }

        public boolean isUi_shirt_specific() { return ui_shirt_specific; }

        public Integer[] getSub_positions_locked() { return sub_positions_locked; }
    }
}
