package com.nn.service;

import com.nn.data.SurValue;
import com.nn.dto.SurValueDto;
import com.nn.mapper.SurValueMapper;
import com.nn.repository.SurValueRepository;
import org.apache.commons.collections4.IterableUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurValueService {

    private final SurValueRepository surValueRepository;

    private final SurValueMapper mapper = Mappers.getMapper(SurValueMapper.class);

    public SurValueService(SurValueRepository surValueRepository) {
        this.surValueRepository = surValueRepository;
    }

    public List<SurValue> saveAll(List<SurValueDto> surValueDtos) {
        if (surValueDtos != null) {
            List<SurValue> surValues = surValueDtos.stream()
                    .map(mapper::SurValueDtoToSurValue)
                    .toList();
            return IterableUtils.toList(surValueRepository.saveAll(surValues));
        }
        return null;
    }
}
