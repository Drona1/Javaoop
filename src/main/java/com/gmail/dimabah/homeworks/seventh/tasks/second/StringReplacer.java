package com.gmail.dimabah.homeworks.seventh.tasks.second;

import java.lang.reflect.Field;

public class StringReplacer {

    public void hackTheObject(Object obj) {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (var field : fields) {
            if (field.getType().getSimpleName().equals("String")) {
                try {
                    if (field.trySetAccessible()) {
                        field.set(obj, "You're hacked. Send 10 btc to 34kNXokGAdmLvsJFFZdrkn27PPtvYLXDYS");
                    }

                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }


}
