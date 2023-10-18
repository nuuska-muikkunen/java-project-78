package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        addCheck("name", s -> schemas.get("name").isValid(s.get("name")));
        addCheck("age", s -> schemas.get("age").isValid(s.get("age")));
        return this;
    }

    public MapSchema required() {
        setNotAllowed(true);
        return this;
    }

    public MapSchema sizeof(Integer size) {
        addCheck("mapSize", m -> m.size() == size);
        return this;
    }
}
