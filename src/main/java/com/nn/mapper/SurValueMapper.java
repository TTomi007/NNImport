package com.nn.mapper;

import com.nn.data.SurValue;
import com.nn.dto.SurValueDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface SurValueMapper {

    @Mapping(target="surValue", source="surValueDto.surrenderValue")
    @Mapping(target="validDate", source="surValueDto.jobTimestamp")
    @Mapping(target="currency", constant = "HUF")
    SurValue SurValueDtoToSurValue(SurValueDto surValueDto);
}
