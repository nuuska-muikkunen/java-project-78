package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
/**
 * This is a parent class for validation schemas.
 * @param <T> is type of the object to be validates
 */
public abstract class BaseSchema<T> {
    private boolean isNotAllowed;
    /**
    * This method isNotAllowed() returns the status of null or "" restrictions.
    * @return boolean true if the restriction active or false if it is not active.
    */
    public boolean isNotAllowed() {
        return isNotAllowed;
    }
    /**
     * This method setNotAllowed() sets value to switch of null or "" restrictions.
     * @param notAllowed is the status of null or "" restrictions: true or false.
    */
    public void setNotAllowed(boolean notAllowed) {
        this.isNotAllowed = notAllowed;
    }

    protected Map<String, Predicate> checks = new LinkedHashMap<>();
    /**
     * This method addCheck() sets restriction activities.
     * @param checkName is the name of restriction.
     * @param testCheck is the name of Predicate for restriction test
     */
    public void addCheck(String checkName, Predicate testCheck) {
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
            return !isNotAllowed();
        }

        for (String key: checks.keySet()) {
            if (!checks.get(key).test(objectForValidation)) {
                return false;
            }
        }

        return true;
    }
}
