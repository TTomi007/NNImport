package com.nn.mapper;

import com.nn.data.SurValue;
import com.nn.dto.SurValueDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface SurValueMapper {

    @Mapping(target="surValue", source="surrenderValue")
    @Mapping(target="validDate", source="jobTimestamp")
    @Mapping(target="currency", constant = "HUF")
    SurValue SurValueDtoToSurValue(SurValueDto surValueDto);
}
