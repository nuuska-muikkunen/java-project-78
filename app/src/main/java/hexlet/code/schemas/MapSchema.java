package hexlet.code.schemas;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
public class MapSchema extends BaseSchema<Map<?, ?>> {
    private boolean notAnyLength = false;
    private boolean isForShapeValidation = false;
    private List<Integer> arrayOfLengthsAllowed = new ArrayList<>();
    private Map<String, BaseSchema> mapOfSchemas = new HashMap<>();

    @Override
    public boolean isValid(Map<?, ?> mapForValidation) {
        if (Objects.equals(mapForValidation, null)) {
            return !isNotAllowed();
        }

        if (isNotAnyLength()) {
            for (Integer size : arrayOfLengthsAllowed) {
                if (mapForValidation.size() == size) {
                    return true;
                }
            }
            return false;
        }

        if (isForShapeValidation()) {
            boolean boo = true;
            for (Object key : mapForValidation.keySet()) {
                boo = boo && mapOfSchemas.get(key).isValid(mapForValidation.get(key));
            }
            return boo;
        }
        return true;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        setForShapeValidation(true);
        for (String key: schemas.keySet()) {
            this.mapOfSchemas.put(key, schemas.get(key));
        }
        return this;
    }

    public MapSchema sizeof(Integer size) {
        setNotAnyLength(true);
        if (!this.arrayOfLengthsAllowed.contains(size)) {
            this.arrayOfLengthsAllowed.add(size);
        }
        return this;
    }
}
