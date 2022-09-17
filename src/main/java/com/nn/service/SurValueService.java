package com.nn.service;

import com.nn.data.SurValue;
import com.nn.dto.SurValueDto;
import com.nn.mapper.SurValueMapper;
import com.nn.repository.SurValueRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurValueService {

    private final SurValueRepository surValueRepository;

    private SurValueMapper mapper = Mappers.getMapper(SurValueMapper.class);

    public SurValueService(SurValueRepository surValueRepository) {
        this.surValueRepository = surValueRepository;
    }

    public void saveAll(List<SurValueDto> surValueDtos) {
        List<SurValue> surValues = surValueDtos.stream()
                .map(surValueDto -> mapper.SurValueDtoToSurValue(surValueDto))
                .toList();
        surValueRepository.saveAll(surValues);
    }
}
