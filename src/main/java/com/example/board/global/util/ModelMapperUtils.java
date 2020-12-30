package com.example.board.global.util;

import org.modelmapper.ModelMapper;

public class ModelMapperUtils {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static <D> D convertEntityIntoDTO(Object source, Class<D> destination) {
        return modelMapper.map(source, destination);
    }
}
