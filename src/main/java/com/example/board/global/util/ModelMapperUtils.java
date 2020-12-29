package com.example.board.global.util;

import org.modelmapper.ModelMapper;

public class ModelMapperUtils {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static ModelMapper getModelMapper() {
        return modelMapper;
    }
}
