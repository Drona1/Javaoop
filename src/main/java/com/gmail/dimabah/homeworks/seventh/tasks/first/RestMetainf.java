package com.gmail.dimabah.homeworks.seventh.tasks.first;

import java.lang.reflect.*;

public class RestMetainf {
    public String restoreClassMetainf(Class<?> clazz) {
        StringBuilder result = new StringBuilder();
        getPackageMetainf(result, clazz);
        getClassMetainf(result, clazz);
        getFieldsMetainf(result, clazz);
        getConstructorsMetainf(result, clazz);
        getMethodsMetainf(result, clazz);

        result.append("}");
        return result.toString();
    }

    private void getPackageMetainf(StringBuilder result, Class<?> clazz) {
        result.append("package ");
        result.append(clazz.getPackageName());
        result.append(System.lineSeparator());

        result.append(System.lineSeparator());
    }

    private void getClassMetainf(StringBuilder result, Class<?> clazz) {
        result.append(Modifier.toString(clazz.getModifiers()));
        result.append(" class ");
        result.append(clazz.getSimpleName());
        if (!clazz.getSuperclass().getSimpleName().equals("Object")) {
            result.append(" extend ");
            result.append(clazz.getSuperclass().getSimpleName());
        }
        Class<?>[] interfaces = clazz.getInterfaces();
        if (interfaces.length != 0) {
            result.append(" implements ");
            for (int i = 0; i < interfaces.length; i++) {
                if (i != 0) {
                    result.append(", ");
                }
                result.append(interfaces[i].getSimpleName());
            }
        }
        result.append(" {");
        result.append(System.lineSeparator());
    }

    private void getFieldsMetainf(StringBuilder result, Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (var i : fields) {
            result.append("\t");
            result.append(Modifier.toString(i.getModifiers()));
            result.append(" ");
            result.append(i.getType().getSimpleName());
            result.append(" ");
            result.append(i.getName());
            result.append(";");
            result.append(System.lineSeparator());
        }
        result.append(System.lineSeparator());
    }

    private void getConstructorsMetainf(StringBuilder result, Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (var i : constructors) {
            result.append("\t");
            result.append(Modifier.toString(i.getModifiers()));
            result.append(" ");
            result.append(clazz.getSimpleName());
            result.append("(");
            Parameter[] par = i.getParameters();
            for (int p = 0; p < par.length; p++) {
                if (p != 0) {
                    result.append(", ");
                }
                result.append(par[p].getType().getSimpleName());
                result.append(" ");
                result.append(par[p].getName());
            }
            result.append(") { ... }");
            result.append(System.lineSeparator());
        }
        result.append(System.lineSeparator());
    }

    private void getMethodsMetainf(StringBuilder result, Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (var i : methods) {
            result.append("\t");
            result.append(Modifier.toString(i.getModifiers()));
            result.append(" ");
            result.append(i.getReturnType().getSimpleName());
            result.append(" ");
            result.append(i.getName());
            result.append("(");
            Parameter[] par = i.getParameters();
            for (int p = 0; p<par.length;p++) {
                if (p != 0) {
                    result.append(", ");
                }
                result.append(par[p].getType().getSimpleName());
                result.append(" ");
                result.append(par[p].getName());
            }
            result.append(") ");
            Class <?>[] exceptions = i.getExceptionTypes();
            if (exceptions.length!=0) {
                result.append("throws ");
                for (int e = 0; e < exceptions.length; e++) {
                    if (e != 0) {
                        result.append(", ");
                    }
                    result.append(exceptions[e].getSimpleName());
                }
            }
            result.append(" { ... }");
            result.append(System.lineSeparator());
        }
    }
}
