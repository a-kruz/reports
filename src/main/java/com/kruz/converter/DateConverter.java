package com.kruz.converter;

import com.opensymphony.xwork2.conversion.TypeConversionException;
import java.util.Map;
import java.util.Locale;
import java.text.DateFormat;
import org.apache.struts2.util.StrutsTypeConverter;

public class DateConverter extends StrutsTypeConverter {
    private final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US);
    
    @Override
    public Object convertFromString(Map context, String[] values, Class toClass) {
        if(values[0] == null) 
            return null;
        try {
            return DATE_FORMAT.parse(values[0]);
        } catch (Exception e) {
            throw new TypeConversionException(e.getMessage());
        }
    }

    @Override
    public String convertToString(Map context, Object o) {
        if(o == null) 
            return null;
        try {
            return DATE_FORMAT.format(o);
        } catch (Exception e) {
            throw new TypeConversionException(e.getMessage());
        }      
    }
 }
