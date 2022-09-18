package com.nn.service;

import com.nn.dto.OutpayHeaderDto;
import com.nn.dto.PolicyDto;
import com.nn.dto.SurValueDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.nio.file.Path;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ImportServiceTest {

    @InjectMocks
    private ImportService subject;

    @Mock
    private TextService textService;

    @Mock
    private SurValueService surValueService;

    @Mock
    private OutpayHeaderService outpayHeaderService;

    @Mock
    private PolicyService policyService;

    @Test
    void importFromFilesNullPathArgsTest() {
        subject.importFromFiles(TestObjectInitializer.createArgs(null, null, null));
        verifyNoInteractions(textService, surValueService, outpayHeaderService, policyService);
    }

    @Test
    void importFromFilesEmptyPathArgsTest() {
        subject.importFromFiles(TestObjectInitializer.createArgs("", "", ""));
        verifyNoInteractions(textService, surValueService, outpayHeaderService, policyService);
    }

    @Test
    void importFromFilesZtpspfArgsTest() {
        List<SurValueDto> surValueDtos = List.of(TestObjectInitializer.createSurValueDto());
        when(textService.readSurValues(eq(Path.of("ztpspf.txt")))).thenReturn(surValueDtos);
        subject.importFromFiles(TestObjectInitializer.createArgs("ztpspf.txt", "", ""));
        verify(surValueService).saveAll(surValueDtos);
        verifyNoInteractions(outpayHeaderService, policyService);
    }

    @Test
    void importFromFilesOutphArgsTest() {
        List<OutpayHeaderDto> outpayHeaderDtos = List.of(TestObjectInitializer.createOutpayHeaderDto());
        when(textService.readOutpayHeader(eq(Path.of("outph.txt")))).thenReturn(outpayHeaderDtos);
        subject.importFromFiles(TestObjectInitializer.createArgs("", "outph.txt", ""));
        verify(outpayHeaderService).saveAll(outpayHeaderDtos);
        verifyNoInteractions(surValueService, policyService);
    }

    @Test
    void importFromFilesPolicyArgsTest() {
        List<PolicyDto> policyDtos = List.of(TestObjectInitializer.createPolicyDto());
        when(textService.readPolicy(eq(Path.of("policy.txt")))).thenReturn(policyDtos);
        subject.importFromFiles(TestObjectInitializer.createArgs("", "", "policy.txt"));
        verify(policyService).saveAll(policyDtos);
        verifyNoInteractions(surValueService, outpayHeaderService);
    }

    @Test
    void importFromFilesAllArgsTest() {
        List<SurValueDto> surValueDtos = List.of(TestObjectInitializer.createSurValueDto());
        List<OutpayHeaderDto> outpayHeaderDtos = List.of(TestObjectInitializer.createOutpayHeaderDto());
        List<PolicyDto> policyDtos = List.of(TestObjectInitializer.createPolicyDto());
        when(textService.readSurValues(eq(Path.of("ztpspf.txt")))).thenReturn(surValueDtos);
        when(textService.readOutpayHeader(eq(Path.of("outph.txt")))).thenReturn(outpayHeaderDtos);
        when(textService.readPolicy(eq(Path.of("policy.txt")))).thenReturn(policyDtos);
        subject.importFromFiles(TestObjectInitializer.createArgs("ztpspf.txt", "outph.txt", "policy.txt"));
        InOrder inOrder = inOrder(surValueService, outpayHeaderService, policyService);
        inOrder.verify(surValueService).saveAll(surValueDtos);
        inOrder.verify(outpayHeaderService).saveAll(outpayHeaderDtos);
        inOrder.verify(policyService).saveAll(policyDtos);
    }

}