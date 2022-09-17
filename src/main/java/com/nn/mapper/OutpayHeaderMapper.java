package com.nn.mapper;

import com.nn.data.OutpayHeader;
import com.nn.dto.OutpayHeaderDto;
import org.mapstruct.Mapper;

@Mapper
public interface OutpayHeaderMapper {

    OutpayHeader OutpayHeaderDtoToOutpayHeader(OutpayHeaderDto outpayHeaderDto);

}
