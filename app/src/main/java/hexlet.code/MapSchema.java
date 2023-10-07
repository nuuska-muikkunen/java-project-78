package hexlet.code;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class MapSchema extends BaseSchema<Map<?, ?>> {
    private boolean notAnyLength = false;
    private boolean isForShapeValidation = false;
    private List<Integer> arrayOfLengthsAllowed = new ArrayList<>();

    private Map<String, BaseSchema> mapOfSchemas = new HashMap<>();

    public boolean isForShapeValidation() {
        return isForShapeValidation;
    }

    public void setForShapeValidation(boolean forShapeValidation) {
        isForShapeValidation = forShapeValidation;
    }

    public boolean isAnyLength() {
        return notAnyLength;
    }

    public void setAnyLength(boolean anyLength) {
        notAnyLength = anyLength;
    }

    @Override
    public boolean isValid(Map<?, ?> mapForValidation) {
        if (Objects.equals(mapForValidation, null)) {
            return !isNotAllowed();
        }

        if (isAnyLength()) {
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
        setAnyLength(true);
        if (!this.arrayOfLengthsAllowed.contains(size)) {
            this.arrayOfLengthsAllowed.add(size);
        }
        return this;
    }
}
