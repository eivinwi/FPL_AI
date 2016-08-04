package reponses;

import javax.json.JsonValue;

/**
 * Created by Eivind on 04.08.2016.
 */
public class ElementType implements JsonValue {

    @Override
    public ValueType getValueType() {
        return ValueType.OBJECT;
    }

    int id;                         // 1
    String singular_name;           // "Goalkeeper"
    String singular_name_short;     // "GKP"
    String plural_name;             // "Goalkeepers"
    String plural_name_short;       // "GKP"

}
