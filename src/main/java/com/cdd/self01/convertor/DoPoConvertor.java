package com.cdd.self01.convertor;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @Author: cdd
 * @Date: Created in 2023/3/3
 * @Description:
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DoPoConvertor {

}
