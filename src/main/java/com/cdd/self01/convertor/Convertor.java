package com.cdd.self01.convertor;

import org.mapstruct.factory.Mappers;

/**
 * @Author: cdd
 * @Date: Created in 2023/3/3
 * @Description:
 */
public class Convertor {
    public static DtoDoConvertor dtoDo = Mappers.getMapper(DtoDoConvertor.class);
    public static DoPoConvertor doPo = Mappers.getMapper(DoPoConvertor.class);
    public static PoDtoConvertor poDto = Mappers.getMapper(PoDtoConvertor.class);
}
