package com.nn.service;

import com.nn.data.Policy;
import com.nn.dto.PolicyDto;
import com.nn.mapper.PolicyMapper;
import com.nn.repository.PolicyRepository;
import org.apache.commons.collections4.IterableUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyService {

    private final PolicyRepository policyRepository;

    private final PolicyMapper mapper = Mappers.getMapper(PolicyMapper.class);

    public PolicyService(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public List<Policy> saveAll(List<PolicyDto> policyDtos) {
        if (policyDtos != null) {
            List<Policy> policies = policyDtos.stream()
                    .map(mapper::PolicyDtoToPolicy)
                    .toList();
            return IterableUtils.toList(policyRepository.saveAll(policies));
        }
        return null;
    }
}
