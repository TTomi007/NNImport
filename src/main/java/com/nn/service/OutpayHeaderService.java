package com.nn.service;

import com.nn.data.OutpayHeader;
import com.nn.dto.OutpayHeaderDto;
import com.nn.mapper.OutpayHeaderMapper;
import com.nn.repository.OutpayHeaderRepository;
import org.apache.commons.collections4.IterableUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutpayHeaderService {

    private final OutpayHeaderRepository outpayHeaderRepository;

    private final OutpayHeaderMapper mapper = Mappers.getMapper(OutpayHeaderMapper.class);

    public OutpayHeaderService(OutpayHeaderRepository outpayHeaderRepository) {
        this.outpayHeaderRepository = outpayHeaderRepository;
    }

    public List<OutpayHeader> saveAll(List<OutpayHeaderDto> outpayHeaderDtos) {
        if (outpayHeaderDtos != null) {
            List<OutpayHeader> outpayHeaders = outpayHeaderDtos.stream()
                    .map(mapper::OutpayHeaderDtoToOutpayHeader)
                    .toList();
            return IterableUtils.toList(outpayHeaderRepository.saveAll(outpayHeaders));
        }
        return null;
    }
}
