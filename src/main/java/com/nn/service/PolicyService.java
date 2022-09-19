package com.nn.service;

import com.nn.data.Policy;
import com.nn.dto.PolicyDto;
import com.nn.mapper.PolicyMapper;
import com.nn.repository.PolicyRepository;
import org.apache.commons.collections4.IterableUtils;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.List;

@Service
public class PolicyService {

    private final PolicyRepository policyRepository;

    private final PolicyMapper mapper = Mappers.getMapper(PolicyMapper.class);

    private static final Logger log = LoggerFactory.getLogger(PolicyService.class);

    public PolicyService(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public List<Policy> saveAll(List<PolicyDto> policyDtos) {
        if (policyDtos != null) {
            List<Policy> policies = policyDtos.stream()
                    .map(mapper::PolicyDtoToPolicy)
                    .toList();
            try {
                return IterableUtils.toList(policyRepository.saveAll(policies));
            } catch (ConstraintViolationException e) {
                log.error(e.toString());
                System.out.printf("Invalid data in policy file, error message: %s%n", e.getMessage());
            }
        }
        return null;
    }
}
