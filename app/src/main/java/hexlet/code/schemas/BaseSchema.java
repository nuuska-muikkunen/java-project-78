package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * This is a parent class for validation schemas.
 * @param <T> is type of the object to be validates
 */
public class BaseSchema<T> {

    private boolean isNotAllowed = false;

    /**
     * This method setNotAllowed() sets value to switch of null or "" restrictions.
     * @param notAllowed is the status of null or "" restrictions activity: true or false.
     */
    public void setNotAllowed(boolean notAllowed) {
        this.isNotAllowed = notAllowed;
    }
    /**
     * This method isNotAllowed() returns value of status switch null or "" restrictions.
     * @return boolean true if null or "" restrictions are active or false if is not active
     */
    public boolean isNotAllowed() {
        return this.isNotAllowed;
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
     * This method contains() sets restriction adding object to be contained in the list of validated one.
     *
     * @param restriction is the string which has to include into verified string
     * @return object of BaseSchema with the activated restriction to have particular strings
     *         included into verified string
    **/
    public BaseSchema contains(Object restriction) {
        addCheck("contains", s -> ((String) s).contains((String) restriction));
        return this;
    }

    /**
     * This method required() sets null or "" restrictions.
     * @return object of BaseSchema with the activated null or "" restriction
     */
    public BaseSchema required() {
//        addCheck("allowsNull", s -> (s instanceof String)
//                    ? (s == null || s.equals(""))
//                    : ((s instanceof Integer) ? s == null : false));
        setNotAllowed(true);
        return this;
    }
    /**
     * This method isValid() sets restriction adding object to be contained in the list of validated one.
     *
     * @param obj is the object to be validated against restrictions
     * @return boolean true is the object valid or false if it is not valid.
     */
    public boolean isValid(T obj) {
        return true;
    }

}
