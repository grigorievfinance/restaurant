package com.grigorievfinance.resraurantserver.util;

import com.grigorievfinance.resraurantserver.HasId;
import com.grigorievfinance.resraurantserver.error.IllegalRequestDataException;
import com.grigorievfinance.resraurantserver.error.NotFoundException;
import lombok.experimental.UtilityClass;

import java.util.Optional;

@UtilityClass
public class ValidationUtil {

    public static void checkNew(HasId bean) {
        if (!bean.isNew()) {
            throw new IllegalRequestDataException(bean.getClass().getSimpleName() + " must be new (id=null)");
        }
    }

    public static void assureIdConsistent(HasId bean, int id) {
        if (bean.isNew()) {
            bean.setId(id);
        } else if (bean.id() != id) {
            throw new IllegalRequestDataException(bean.getClass().getSimpleName() + " must has id=" + id);
        }
    }

    public static <T> T checkNotFoundWithId(Optional<T> optional, int id) {
        return checkNotFoundWithId(optional, "Entity with id=" + id +" not found");
    }

    public static <T> T checkNotFoundWithId(Optional<T> optional, String msg) {
        return optional.orElseThrow(() -> new NotFoundException(msg));
    }

    public static void checkSingleModification(int count, String msg) {
        if (count != 1) {
            throw new NotFoundException(msg);
        }
    }
}
