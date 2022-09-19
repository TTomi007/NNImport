package com.nn.service;

import com.nn.data.OutpayHeader;
import com.nn.dto.OutpayHeaderDto;
import com.nn.repository.OutpayHeaderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
        when(outpayHeaderRepository.saveAll(anyList())).thenReturn(mappedOutpayHeaders);
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
    void saveAllTest() {
        OutpayHeaderDto outpayHeaderDto = TestObjectInitializer.createOutpayHeaderDto();
        List<OutpayHeaderDto> outpayHeaderDtos = List.of(outpayHeaderDto);

        OutpayHeader mappedOutpayHeader = TestObjectInitializer.createOutpayHeader();
        List<OutpayHeader> mappedOutpayHeaders = List.of(mappedOutpayHeader);

        when(outpayHeaderRepository.saveAll(anyList())).thenReturn(mappedOutpayHeaders);
        List<OutpayHeader> savedOutpayHeaders = subject.saveAll(outpayHeaderDtos);
        assertEquals(outpayHeaderDtos.size(), savedOutpayHeaders.size());
        OutpayHeader savedOutpayHeader = savedOutpayHeaders.get(0);
        assertEquals(42, savedOutpayHeader.getOutpayHeaderId());
        assertEquals(outpayHeaderDto.clntNum(), savedOutpayHeader.getClntNum());
        assertEquals(outpayHeaderDto.chdrNum(), savedOutpayHeader.getChdrNum());
        assertEquals(outpayHeaderDto.letterType(), savedOutpayHeader.getLetterType());
        assertEquals(outpayHeaderDto.printDate(), savedOutpayHeader.getPrintDate());
        assertEquals(outpayHeaderDto.dataId(), savedOutpayHeader.getDataId());
        assertEquals(outpayHeaderDto.clntName(), savedOutpayHeader.getClntName());
        assertEquals(outpayHeaderDto.clntAddress(), savedOutpayHeader.getClntAddress());
        assertEquals(outpayHeaderDto.benPercent(), savedOutpayHeader.getBenPercent());
        assertEquals(outpayHeaderDto.role1(), savedOutpayHeader.getRole1());
        assertEquals(outpayHeaderDto.role2(), savedOutpayHeader.getRole2());
        assertEquals(outpayHeaderDto.cownNum(), savedOutpayHeader.getCownNum());
        assertEquals(outpayHeaderDto.cownName(), savedOutpayHeader.getCownName());
        assertEquals("Notice01", savedOutpayHeader.getNotice01());
        assertEquals("Notice02", savedOutpayHeader.getNotice02());
        assertEquals("Notice03", savedOutpayHeader.getNotice03());
        assertEquals("Notice04", savedOutpayHeader.getNotice04());
        assertEquals("Notice05", savedOutpayHeader.getNotice05());
        assertEquals("Notice06", savedOutpayHeader.getNotice06());
        LocalDate tp2ProcessDate = LocalDate.parse("20201212", DateTimeFormatter.BASIC_ISO_DATE);
        assertEquals(tp2ProcessDate, savedOutpayHeader.getTp2ProcessDate());
    }

}