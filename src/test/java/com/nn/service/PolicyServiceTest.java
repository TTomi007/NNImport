package com.nn.service;

import com.nn.data.Policy;
import com.nn.dto.PolicyDto;
import com.nn.repository.PolicyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ConstraintViolationException;
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
        List<PolicyDto> policyDtos = Collections.emptyList();
        List<Policy> mappedPolicies = Collections.emptyList();
        when(policyRepository.saveAll(mappedPolicies)).thenReturn(mappedPolicies);
        List<Policy> savedPolicies = subject.saveAll(policyDtos);
        assertEquals(0, savedPolicies.size());
    }

    @Test
    void saveAllNullElementInListTest() {
        List<PolicyDto> policyDtos =  new ArrayList<>();
        policyDtos.add(null);
        List<Policy> mappedPolicies = new ArrayList<>();
        mappedPolicies.add(null);
        when(policyRepository.saveAll(mappedPolicies)).thenReturn(mappedPolicies);
        List<Policy> savedPolicies = subject.saveAll(policyDtos);
        assertEquals(1, savedPolicies.size());
        assertNull(savedPolicies.get(0));
    }

    @Test
    void saveAllInvalidDataTest() {
        PolicyDto policyDto = TestObjectInitializer.createPolicyDto();
        List<PolicyDto> policyDtos = List.of(policyDto);
        when(policyRepository.saveAll(anyList())).thenThrow(new ConstraintViolationException("invalid data", null));
        List<Policy> savedPolicies = subject.saveAll(policyDtos);
        assertNull(savedPolicies);
    }

    @Test
    void saveAllTest() {
        PolicyDto policyDto = TestObjectInitializer.createPolicyDto();
        List<PolicyDto> policyDtos = List.of(policyDto);

        Policy mappedPolicy = TestObjectInitializer.createPolicy();
        List<Policy> mappedPolicies = List.of(mappedPolicy);

        Policy savedPolicy = TestObjectInitializer.createSavedPolicy();
        List<Policy> savedPolicies = List.of(savedPolicy);

        when(policyRepository.saveAll(mappedPolicies)).thenReturn(savedPolicies);
        List<Policy> resultPolicies = subject.saveAll(policyDtos);
        assertEquals(policyDtos.size(), resultPolicies.size());
        Policy resultPolicy = resultPolicies.get(0);
        assertEquals(101, resultPolicy.getId());
        assertEquals(policyDto.chdrNum(), resultPolicy.getChdrNum());
        assertEquals(policyDto.cownNum(), resultPolicy.getCownNum());
        assertEquals(policyDto.ownerName(), resultPolicy.getOwnerName());
        assertEquals(policyDto.lifcNum(), resultPolicy.getLifcNum());
        assertEquals(policyDto.lifcName(), resultPolicy.getLifcName());
        assertEquals(policyDto.aracde(), resultPolicy.getAracde());
        assertEquals(policyDto.agntNum(), resultPolicy.getAgntNum());
        assertEquals(policyDto.mailAddress(), resultPolicy.getMailAddress());
    }

}