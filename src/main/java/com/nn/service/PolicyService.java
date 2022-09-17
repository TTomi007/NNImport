package com.nn.service;

import com.nn.data.Policy;
import com.nn.dto.PolicyDto;
import com.nn.mapper.PolicyMapper;
import com.nn.repository.PolicyRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyService {

    private final PolicyRepository policyRepository;

    private PolicyMapper mapper = Mappers.getMapper(PolicyMapper.class);

    public PolicyService(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public void saveAll(List<PolicyDto> policyDtos) {
        List<Policy> policies = policyDtos.stream()
                .map(surValueDto -> mapper.PolicyDtoToPolicy(surValueDto))
                .toList();
        policyRepository.saveAll(policies);
    }
}
