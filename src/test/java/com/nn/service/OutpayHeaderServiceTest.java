package com.nn.service;

import com.nn.data.OutpayHeader;
import com.nn.dto.OutpayHeaderDto;
import com.nn.dto.OutpayHeaderDtoBuilder;
import com.nn.repository.OutpayHeaderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
        List<OutpayHeaderDto> outpayHeaderDtos = new ArrayList<>();
        List<OutpayHeader> mappedOutpayHeaders = new ArrayList<>();
        when(outpayHeaderRepository.saveAll(anyList())).thenReturn(mappedOutpayHeaders);
        List<OutpayHeader> savedOutpayHeaders = subject.saveAll(outpayHeaderDtos);
        assertEquals(outpayHeaderDtos.size(), savedOutpayHeaders.size());
    }

    @Test
    void saveAllTest() {
        OutpayHeaderDto outpayHeaderDto = OutpayHeaderDtoBuilder.anOutpayHeaderDto()
                .withClntNum("55555555")
                .withChdrNum("66666666")
                .withLetterType("LET")
                .withPrintDate(LocalDate.parse("20201111", DateTimeFormatter.BASIC_ISO_DATE))
                .withDataId("TEST")
                .withClntName("Teszt Elek")
                .withClntAddress("6666 Pécs Van utca 7.")
                .withRegDate(LocalDate.parse("20201106", DateTimeFormatter.BASIC_ISO_DATE))
                .withBenPercent(88.75)
                .withRole1("Role1")
                .withRole2("Role2")
                .withCownNum("11111111")
                .withCownName("Teszt Nóra")
                .withClaimId("123456789")
                .build();
        List<OutpayHeaderDto> outpayHeaderDtos = List.of(outpayHeaderDto);

        OutpayHeader mappedOutpayHeader = new OutpayHeader();
        mappedOutpayHeader.setClntNum("55555555");
        mappedOutpayHeader.setChdrNum("66666666");
        mappedOutpayHeader.setLetterType("LET");
        mappedOutpayHeader.setPrintDate(LocalDate.parse("20201111", DateTimeFormatter.BASIC_ISO_DATE));
        mappedOutpayHeader.setDataId("TEST");
        mappedOutpayHeader.setClntName("Teszt Elek");
        mappedOutpayHeader.setClntAddress("6666 Pécs Van utca 7.");
        mappedOutpayHeader.setRegDate(LocalDate.parse("20201106", DateTimeFormatter.BASIC_ISO_DATE));
        mappedOutpayHeader.setBenPercent(88.75);
        mappedOutpayHeader.setRole1("Role1");
        mappedOutpayHeader.setRole2("Role2");
        mappedOutpayHeader.setCownNum("11111111");
        mappedOutpayHeader.setCownName("Teszt Nóra");
        mappedOutpayHeader.setClaimId("123456789");

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