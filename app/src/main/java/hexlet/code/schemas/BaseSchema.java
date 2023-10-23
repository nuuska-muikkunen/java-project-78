package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
/**
 * This is a parent class for validation schemas.
 * @param <T> is type of the object to be validates. It supports int, String and Map objects.
 */
public abstract class BaseSchema<T> {
    protected boolean required;
    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();
    /**
     * This method addCheck() sets restriction activities.
     *
     * @param checkName is the name of restriction.
     * @param testCheck is the name of Predicate for restriction test
     */
    public void addCheck(String checkName, Predicate<T> testCheck) {
        checks.put(checkName, testCheck);
    }
    /**
     * This method isValid() validate the object against established restrictions.
     *
     * @param objectForValidation is the object to be validated against correspondence to the restrictions
     * @return boolean true is the object valid or false if it is not valid.
     */
    public boolean isValid(T objectForValidation) {

        if (Objects.equals(objectForValidation, null)) {
            return !required;
        }

        for (String key: checks.keySet()) {
            if (!checks.get(key).test(objectForValidation)) {
                return false;
            }
        }

        return true;
    }
}
