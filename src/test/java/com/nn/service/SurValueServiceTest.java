package com.nn.service;

import com.nn.data.SurValue;
import com.nn.dto.SurValueDto;
import com.nn.dto.SurValueDtoBuilder;
import com.nn.repository.SurValueRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class SurValueServiceTest {

    @InjectMocks
    private SurValueService subject;

    @Mock
    private SurValueRepository surValueRepository;

    @Test
    void saveAllNullTest() {
        List<SurValue> savedSurValues = subject.saveAll(null);
        verify(surValueRepository, never()).saveAll(anyList());
        assertNull(savedSurValues);
    }

    @Test
    void saveAllEmptyListTest() {
        List<SurValueDto> surValueDtos = new ArrayList<>();
        List<SurValue> mappedSurValues = new ArrayList<>();
        when(surValueRepository.saveAll(anyList())).thenReturn(mappedSurValues);
        List<SurValue> savedSurValues = subject.saveAll(surValueDtos);
        assertEquals(surValueDtos.size(), savedSurValues.size());
    }

    @Test
    void saveAllTest() {
        SurValueDto surValueDto = SurValueDtoBuilder.aSurValueDto()
                .withChdrnum("42781365")
                .withSurrenderValue(312.34)
                .withCompany("2")
                .withJobTimestamp(LocalDate.parse("2020-10-10"))
                .build();
        List<SurValueDto> surValueDtos = List.of(surValueDto);

        SurValue mappedSurValue = new SurValue();
        mappedSurValue.setChdrNum("42781365");
        mappedSurValue.setSurValue(312.34);
        mappedSurValue.setCompany("2");
        mappedSurValue.setCurrency("HUF");
        mappedSurValue.setValidDate("2020-10-10");

        List<SurValue> mappedSurValues = List.of(mappedSurValue);
        when(surValueRepository.saveAll(anyList())).thenReturn(mappedSurValues);
        List<SurValue> savedSurValues = subject.saveAll(surValueDtos);
        assertEquals(surValueDtos.size(), savedSurValues.size());
        SurValue savedSurValue = savedSurValues.get(0);
        assertEquals(surValueDto.chdrNum(), savedSurValue.getChdrNum());
        assertEquals(surValueDto.surrenderValue(), savedSurValue.getSurValue());
        assertEquals(surValueDto.company(), savedSurValue.getCompany());
        assertEquals("HUF", savedSurValue.getCurrency());
        assertEquals(surValueDto.jobTimestamp(), LocalDate.parse(savedSurValue.getValidDate()));
    }
}