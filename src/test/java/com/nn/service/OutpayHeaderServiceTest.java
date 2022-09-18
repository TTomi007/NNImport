package com.nn.service;

import com.nn.data.OutpayHeader;
import com.nn.dto.OutpayHeaderDto;
import com.nn.repository.OutpayHeaderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
    void saveAllTest() {
        OutpayHeaderDto outpayHeaderDto = TestObjectInitializer.createOutpayHeaderDto();
        List<OutpayHeaderDto> outpayHeaderDtos = List.of(outpayHeaderDto);

        OutpayHeader mappedOutpayHeader = TestObjectInitializer.createOutpayHeader();
        List<OutpayHeader> mappedOutpayHeaders = List.of(mappedOutpayHeader);

        when(outpayHeaderRepository.saveAll(anyList())).thenReturn(mappedOutpayHeaders);
        List<OutpayHeader> savedOutpayHeaders = subject.saveAll(outpayHeaderDtos);
        assertEquals(outpayHeaderDtos.size(), savedOutpayHeaders.size());
        OutpayHeader savedOutpayHeader = savedOutpayHeaders.get(0);
        assertEquals(outpayHeaderDto.clntNum(), savedOutpayHeader.getClntNum());
        assertEquals(outpayHeaderDto.chdrNum(), savedOutpayHeader.getChdrNum());
        assertEquals(outpayHeaderDto.letterType(), savedOutpayHeader.getLetterType());
        assertEquals(outpayHeaderDto.printDate(), savedOutpayHeader.getPrintDate());
        assertEquals(outpayHeaderDto.dataId(), savedOutpayHeader.getDataId());
        assertEquals(outpayHeaderDto.clntName(), savedOutpayHeader.getClntName());
        assertEquals(outpayHeaderDto.clntAddress(), savedOutpayHeader.getClntAddress());
        assertEquals(outpayHeaderDto.regDate(), savedOutpayHeader.getRegDate());
        assertEquals(outpayHeaderDto.benPercent(), savedOutpayHeader.getBenPercent());
        assertEquals(outpayHeaderDto.role1(), savedOutpayHeader.getRole1());
        assertEquals(outpayHeaderDto.role2(), savedOutpayHeader.getRole2());
        assertEquals(outpayHeaderDto.cownNum(), savedOutpayHeader.getCownNum());
        assertEquals(outpayHeaderDto.cownName(), savedOutpayHeader.getCownName());
        assertEquals(outpayHeaderDto.claimId(), savedOutpayHeader.getClaimId());
        assertNull(savedOutpayHeader.getNotice01());
        assertNull(savedOutpayHeader.getNotice02());
        assertNull(savedOutpayHeader.getNotice03());
        assertNull(savedOutpayHeader.getNotice04());
        assertNull(savedOutpayHeader.getNotice05());
        assertNull(savedOutpayHeader.getNotice06());
        assertNull(savedOutpayHeader.getTp2ProcessDate());
    }

}