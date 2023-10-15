package hexlet.code.schemas;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
public final class MapSchema extends BaseSchema<Map<?, ?>> {
    @Override
    public boolean isValid(Map<?, ?> mapForValidation) {
        if (Objects.equals(mapForValidation, null)) {
            return !isNotAllowed();
        }

        for (Object key: checks.keySet()) {
            if (!checks.get(key).test(mapForValidation)) {
                return false;
            }
        }
        return true;
    }

    public BaseSchema shape(Map<String, BaseSchema> schemas) {
        addCheck("name", s -> schemas.get("name").isValid(((Map<?, ?>) s).get("name")));
        addCheck("age", s -> schemas.get("age").isValid(((Map<?, ?>) s).get("age")));
        return this;
    }

    public MapSchema sizeof(Integer size) {
        addCheck("mapSize", m -> ((Map<?, ?>) m).size() == size);
        return this;
    }
}
