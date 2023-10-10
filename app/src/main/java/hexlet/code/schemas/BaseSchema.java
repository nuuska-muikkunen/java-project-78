package hexlet.code.schemas;

import java.util.List;
import java.util.ArrayList;

public abstract class BaseSchema<T> {

    private boolean isNotAllowed = false;
    private boolean isActiveStringRestriction = false;
    private List<Object> listOfRestrictions = new ArrayList<>();

    public List<Object> getListOfRestrictions() {
        return listOfRestrictions;
    }

    public boolean isActiveStringRestriction() {
        return isActiveStringRestriction;
    }

    public void setActiveStringRestriction(boolean activeStringRestriction) {
        isActiveStringRestriction = activeStringRestriction;
    }

    public void setNotAllowed(boolean notAllowed) {
        this.isNotAllowed = notAllowed;
    }

    public boolean isNotAllowed() {
        return this.isNotAllowed;
    }

    public BaseSchema required() {
        setNotAllowed(true);
        return this;
    }

    public BaseSchema contains(T restriction) {
        setActiveStringRestriction(true);
        if (!listOfRestrictions.contains(restriction)) {
            listOfRestrictions.add(restriction);
        }
        return this;
    }

    public abstract boolean isValid(T obj);

}
