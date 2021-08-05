package com.finartz.RestApp.model.converter;

public interface GenericConverter<S, T> {
    T convert(S source);
}
