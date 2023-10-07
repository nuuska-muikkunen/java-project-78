package hexlet.code;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class MapSchema extends BaseSchema<Map<?, ?>> {
    private boolean notAnyLength = false;
    private List<Integer> arrayOfLengthsAllowed = new ArrayList<>();

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
        return true;
    }

    public MapSchema sizeof(Integer size) {
        setAnyLength(true);
        if (!this.arrayOfLengthsAllowed.contains(size)) {
            this.arrayOfLengthsAllowed.add(size);
        }
        return this;
    }

}
