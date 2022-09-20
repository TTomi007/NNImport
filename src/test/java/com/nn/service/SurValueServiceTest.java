package com.nn.service;

import com.nn.data.SurValue;
import com.nn.dto.SurValueDto;
import com.nn.repository.SurValueRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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
        List<SurValueDto> surValueDtos = Collections.emptyList();
        List<SurValue> mappedSurValues = Collections.emptyList();
        when(surValueRepository.saveAll(mappedSurValues)).thenReturn(mappedSurValues);
        List<SurValue> savedSurValues = subject.saveAll(surValueDtos);
        assertEquals(0, savedSurValues.size());
    }

    @Test
    void saveAllNullElementInListTest() {
        List<SurValueDto> surValueDtos = new ArrayList<>();
        surValueDtos.add(null);
        List<SurValue> mappedSurValues = new ArrayList<>();
        mappedSurValues.add(null);
        when(surValueRepository.saveAll(mappedSurValues)).thenReturn(mappedSurValues);
        List<SurValue> savedSurValues = subject.saveAll(surValueDtos);
        assertEquals(1, savedSurValues.size());
        assertNull(savedSurValues.get(0));
    }

    @Test
    void saveAllInvalidDataTest() {
        SurValueDto surValueDto = TestObjectInitializer.createSurValueDto();
        List<SurValueDto> surValueDtos = List.of(surValueDto);
        when(surValueRepository.saveAll(anyList())).thenThrow(new ConstraintViolationException("invalid data", null));
        List<SurValue> savedSurValues = subject.saveAll(surValueDtos);
        assertNull(savedSurValues);
    }

    @Test
    void saveAllTest() {
        SurValueDto surValueDto = TestObjectInitializer.createSurValueDto();
        List<SurValueDto> surValueDtos = List.of(surValueDto);

        SurValue mappedSurValue = TestObjectInitializer.createSurValue();
        List<SurValue> mappedSurValues = List.of(mappedSurValue);

        SurValue savedSurValue = TestObjectInitializer.createSavedSurValue();
        List<SurValue> savedSurValues = List.of(savedSurValue);

        when(surValueRepository.saveAll(mappedSurValues)).thenReturn(savedSurValues);
        List<SurValue> resultSurValues = subject.saveAll(surValueDtos);
        assertEquals(surValueDtos.size(), resultSurValues.size());
        SurValue resultSurValue = resultSurValues.get(0);
        assertEquals(1, resultSurValue.getId());
        assertEquals(surValueDto.chdrNum(), resultSurValue.getChdrNum());
        assertEquals(surValueDto.surrenderValue(), resultSurValue.getSurValue());
        assertEquals(surValueDto.company(), resultSurValue.getCompany());
        assertEquals("HUF", resultSurValue.getCurrency());
        assertEquals(surValueDto.jobTimestamp(), LocalDate.parse(resultSurValue.getValidDate()));
    }
}