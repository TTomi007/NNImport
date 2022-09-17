package com.nn.mapper;

import com.nn.data.Policy;
import com.nn.dto.PolicyDto;
import org.mapstruct.Mapper;

@Mapper
public interface PolicyMapper {

    Policy PolicyDtoToPolicy(PolicyDto policyDto);

}
