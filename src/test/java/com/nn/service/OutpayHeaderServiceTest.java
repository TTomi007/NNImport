package com.nn.service;

import com.nn.data.OutpayHeader;
import com.nn.dto.OutpayHeaderDto;
import com.nn.repository.OutpayHeaderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
class OutpayHeaderServiceTest {

    @InjectMocks
    private OutpayHeaderService subject;

    @Mock
    private OutpayHeaderRepository outpayHeaderRepository;

    @Test
    void saveAllNullTest() {
        List<OutpayHeader> savedOutpayHeaders = subject.saveAll(null);
        verify(outpayHeaderRepository, never()).saveAll(anyList());
        assertNull(savedOutpayHeaders);
    }

    @Test
    void saveAllEmptyListTest() {
        List<OutpayHeaderDto> outpayHeaderDtos = Collections.emptyList();
        List<OutpayHeader> mappedOutpayHeaders = Collections.emptyList();
        when(outpayHeaderRepository.saveAll(mappedOutpayHeaders)).thenReturn(mappedOutpayHeaders);
        List<OutpayHeader> savedOutpayHeaders = subject.saveAll(outpayHeaderDtos);
        assertEquals(0, savedOutpayHeaders.size());
    }

    @Test
    void saveAllNullElementInListTest() {
        List<OutpayHeaderDto> outpayHeaderDtos = new ArrayList<>();
        outpayHeaderDtos.add(null);
        List<OutpayHeader> mappedOutpayHeaders = new ArrayList<>();
        mappedOutpayHeaders.add(null);
        when(outpayHeaderRepository.saveAll(mappedOutpayHeaders)).thenReturn(mappedOutpayHeaders);
        List<OutpayHeader> savedOutpayHeaders = subject.saveAll(outpayHeaderDtos);
        assertEquals(1, savedOutpayHeaders.size());
        assertNull(savedOutpayHeaders.get(0));
    }

    @Test
    void saveAllInvalidDataTest() {
        OutpayHeaderDto outpayHeaderDto = TestObjectInitializer.createOutpayHeaderDto();
        List<OutpayHeaderDto> outpayHeaderDtos = List.of(outpayHeaderDto);
        when(outpayHeaderRepository.saveAll(anyList())).thenThrow(new ConstraintViolationException("invalid data", null));
        List<OutpayHeader> savedOutpayHeaders = subject.saveAll(outpayHeaderDtos);
        assertNull(savedOutpayHeaders);
    }

    @Test
    void saveAllTest() {
        OutpayHeaderDto outpayHeaderDto = TestObjectInitializer.createOutpayHeaderDto();
        List<OutpayHeaderDto> outpayHeaderDtos = List.of(outpayHeaderDto);

        OutpayHeader mappedOutpayHeader = TestObjectInitializer.createOutpayHeader();
        List<OutpayHeader> mappedOutpayHeaders = List.of(mappedOutpayHeader);

        OutpayHeader savedOutpayHeader = TestObjectInitializer.createSavedOutpayHeader();
        List<OutpayHeader> savedOutpayHeaders = List.of(savedOutpayHeader);

        when(outpayHeaderRepository.saveAll(mappedOutpayHeaders)).thenReturn(savedOutpayHeaders);
        List<OutpayHeader> resultOutpayHeaders = subject.saveAll(outpayHeaderDtos);
        assertEquals(outpayHeaderDtos.size(), resultOutpayHeaders.size());
        OutpayHeader resultOutpayHeader = resultOutpayHeaders.get(0);
        assertEquals(42, resultOutpayHeader.getOutpayHeaderId());
        assertEquals(outpayHeaderDto.clntNum(), resultOutpayHeader.getClntNum());
        assertEquals(outpayHeaderDto.chdrNum(), resultOutpayHeader.getChdrNum());
        assertEquals(outpayHeaderDto.letterType(), resultOutpayHeader.getLetterType());
        assertEquals(outpayHeaderDto.printDate(), resultOutpayHeader.getPrintDate());
        assertEquals(outpayHeaderDto.dataId(), resultOutpayHeader.getDataId());
        assertEquals(outpayHeaderDto.clntName(), resultOutpayHeader.getClntName());
        assertEquals(outpayHeaderDto.clntAddress(), resultOutpayHeader.getClntAddress());
        assertEquals(outpayHeaderDto.benPercent(), resultOutpayHeader.getBenPercent());
        assertEquals(outpayHeaderDto.role1(), resultOutpayHeader.getRole1());
        assertEquals(outpayHeaderDto.role2(), resultOutpayHeader.getRole2());
        assertEquals(outpayHeaderDto.cownNum(), resultOutpayHeader.getCownNum());
        assertEquals(outpayHeaderDto.cownName(), resultOutpayHeader.getCownName());
        assertEquals("Notice01", resultOutpayHeader.getNotice01());
        assertEquals("Notice02", resultOutpayHeader.getNotice02());
        assertEquals("Notice03", resultOutpayHeader.getNotice03());
        assertEquals("Notice04", resultOutpayHeader.getNotice04());
        assertEquals("Notice05", resultOutpayHeader.getNotice05());
        assertEquals("Notice06", resultOutpayHeader.getNotice06());
        LocalDate tp2ProcessDate = LocalDate.parse("20201212", DateTimeFormatter.BASIC_ISO_DATE);
        assertEquals(tp2ProcessDate, resultOutpayHeader.getTp2ProcessDate());
    }

}