package com.data.weatherHistory.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class LocalDateConverter extends AbstractBeanField {
  private static final String DATE_FORMAT = "dd/MM/yyyy";

  @Override
  public Object convert(String s) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
    try {
      return new SimpleDateFormat(DATE_FORMAT).parse(s);
    } catch (ParseException e) {
      return null;
    }
  }
}