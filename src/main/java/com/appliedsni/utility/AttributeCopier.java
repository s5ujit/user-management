package com.appliedsni.utility;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;


public final class AttributeCopier extends BeanUtils {

  
    private AttributeCopier() {

    }

    public static void copyAttribute(final Object pSource, final Object pTarget) {

        Assert.notNull(pSource, "Source must not be null");
        Assert.notNull(pTarget, "Target must not be null");
        PropertyDescriptor targetPd = null;
        Object value = null;
        Method readMethod = null;
        Method writeMethodToCompare = null;
        Method writeMethod = null;
        PropertyDescriptor sourcePd = null;

        final Class actualEditable = pTarget.getClass();
        final PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);

        try {
            for (int i = 0; i < targetPds.length; i++) {
                targetPd = targetPds[i];
                if (targetPd.getWriteMethod() != null) {
                    sourcePd = getPropertyDescriptor(pSource.getClass(), targetPd.getName());
                    if (sourcePd != null && sourcePd.getReadMethod() != null) {
                        readMethod = sourcePd.getReadMethod();
                        writeMethodToCompare = targetPd.getReadMethod();
                        writeMethod = targetPd.getWriteMethod();
                        if (readMethod != null
                                    && writeMethodToCompare != null
                                    && readMethod
                                                .getReturnType()
                                                .getName()
                                                .equalsIgnoreCase(
                                                    writeMethodToCompare.getReturnType().getName())
                                    && !isCollection(readMethod.getReturnType().getName())) {

                            value = readMethod.invoke(pSource, new Object[0]);
                            writeMethod.invoke(pTarget, new Object[]{ value });
                        }
                    }
                }
            }
        }
        catch (final IllegalArgumentException pIllegalArgumentException) {
        	pIllegalArgumentException.printStackTrace();
        }
        catch (final IllegalAccessException pIllegalAccessException) {
        	pIllegalAccessException.printStackTrace();
        }
        catch (final InvocationTargetException pInvocationTargetException) {
        	pInvocationTargetException.printStackTrace();
        }

    }

    private static boolean isCollection(final String pString) {
        boolean isCollection = false;
        if ((pString.equalsIgnoreCase("java.util.List")) || (pString.equalsIgnoreCase("java.util.Set"))) {
            isCollection = true;
        }
        return isCollection;
    }

}
