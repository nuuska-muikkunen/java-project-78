package hexlet.code.schemas;

import java.util.List;
import java.util.ArrayList;
/**
 * This is a parent class for validation schemas.
 * @param <T> is type of the object to be validates
 */
public class BaseSchema<T> {

    private boolean isNotAllowed = false;
    private boolean isActiveStringRestriction = false;
    private List<Object> listOfRestrictions = new ArrayList<>();

    public List<Object> getListOfRestrictions() {
        return listOfRestrictions;
    }
    /**
     * This method isActiveStringRestriction() sets restriction activity.
     * @return boolean true if restrictions are active or false if is not active
     */
    public boolean isActiveStringRestriction() {
        return isActiveStringRestriction;
    }
    /**
     * This method setActiveStringRestriction() sets restriction activity.
     * @param activeStringRestriction is the status of restrictions activity: true or false.
     */
    public void setActiveStringRestriction(boolean activeStringRestriction) {
        isActiveStringRestriction = activeStringRestriction;
    }
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
    /**
     * This method required() sets null or "" restrictions.
     * @return object of BaseSchema with the activated null or "" restriction
     */
    public BaseSchema required() {
        setNotAllowed(true);
        return this;
    }
    /**
     * This method contains() sets restriction adding object to be contained in the list of validated one.
     *
     * @param restriction is the object
     * @return Baseschema the schema with modified list of restrictions
     */
    public BaseSchema contains(T restriction) {
        setActiveStringRestriction(true);
        if (!listOfRestrictions.contains(restriction)) {
            listOfRestrictions.add(restriction);
        }
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
    };

}
