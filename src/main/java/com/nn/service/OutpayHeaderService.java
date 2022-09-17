package com.nn.service;

import com.nn.data.OutpayHeader;
import com.nn.dto.OutpayHeaderDto;
import com.nn.mapper.OutpayHeaderMapper;
import com.nn.repository.OutpayHeaderRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutpayHeaderService {

    private final OutpayHeaderRepository outpayHeaderRepository;

    private OutpayHeaderMapper mapper = Mappers.getMapper(OutpayHeaderMapper.class);

    public OutpayHeaderService(OutpayHeaderRepository outpayHeaderRepository) {
        this.outpayHeaderRepository = outpayHeaderRepository;
    }

    public void saveAll(List<OutpayHeaderDto> outpayHeaderDtos) {
        List<OutpayHeader> outpayHeaders = outpayHeaderDtos.stream()
                .map(surValueDto -> mapper.OutpayHeaderDtoToOutpayHeader(surValueDto))
                .toList();
        outpayHeaderRepository.saveAll(outpayHeaders);
    }
}
