package com.nn.service;

import com.nn.data.Policy;
import com.nn.dto.PolicyDto;
import com.nn.dto.PolicyDtoBuilder;
import com.nn.repository.PolicyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PolicyServiceTest {

    @InjectMocks
    private PolicyService subject;

    @Mock
    private PolicyRepository policyRepository;

    @Test
    void saveAllNullTest() {
        List<Policy> savedPolicies = subject.saveAll(null);
        verify(policyRepository, never()).saveAll(anyList());
        assertNull(savedPolicies);
    }

    @Test
    void saveAllEmptyListTest() {
        List<PolicyDto> policyDtos = new ArrayList<>();
        List<Policy> mappedPolicies = new ArrayList<>();
        when(policyRepository.saveAll(anyList())).thenReturn(mappedPolicies);
        List<Policy> savedPolicies = subject.saveAll(policyDtos);
        assertEquals(policyDtos.size(), savedPolicies.size());
    }

    @Test
    void saveAllTest() {
        PolicyDto policyDto = PolicyDtoBuilder.aPolicyDto()
                .withChdrNum("22222222")
                .withCownNum("11111111")
                .withOwnerName("Teszt Elek")
                .withLifcNum("33333333")
                .withLifcName("Teszt Elek")
                .withAracde("14R")
                .withAgntNum("11111")
                .withMailAddress("4444 Baja Teszt utca 1.")
                .build();
        List<PolicyDto> policyDtos = List.of(policyDto);

        Policy mappedPolicy = new Policy();
        mappedPolicy.setChdrNum("22222222");
        mappedPolicy.setCownNum("11111111");
        mappedPolicy.setOwnerName("Teszt Elek");
        mappedPolicy.setLifcNum("33333333");
        mappedPolicy.setLifcName("Teszt Elek");
        mappedPolicy.setAracde("14R");
        mappedPolicy.setAgntNum("11111");
        mappedPolicy.setMailAddress("4444 Baja Teszt utca 1.");

        List<Policy> mappedPolicies = List.of(mappedPolicy);
        when(policyRepository.saveAll(anyList())).thenReturn(mappedPolicies);
        List<Policy> savedPolicies = subject.saveAll(policyDtos);
        assertEquals(policyDtos.size(), savedPolicies.size());
        Policy savedPolicy = savedPolicies.get(0);
        assertEquals(policyDto.chdrNum(), savedPolicy.getChdrNum());
        assertEquals(policyDto.cownNum(), savedPolicy.getCownNum());
        assertEquals(policyDto.ownerName(), savedPolicy.getOwnerName());
        assertEquals(policyDto.lifcNum(), savedPolicy.getLifcNum());
        assertEquals(policyDto.lifcName(), savedPolicy.getLifcName());
        assertEquals(policyDto.aracde(), savedPolicy.getAracde());
        assertEquals(policyDto.agntNum(), savedPolicy.getAgntNum());
        assertEquals(policyDto.mailAddress(), savedPolicy.getMailAddress());
    }

}