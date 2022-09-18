package com.nn.service;

import com.nn.Args;
import com.nn.dto.OutpayHeaderDto;
import com.nn.dto.PolicyDto;
import com.nn.dto.SurValueDto;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;

@Service
public class ImportService {

    private final TextService textService;

    private final SurValueService surValueService;

    private final OutpayHeaderService outpayHeaderService;

    private final PolicyService policyService;

    private static final Logger log = LoggerFactory.getLogger(ImportService.class);

    public ImportService(TextService textService, SurValueService surValueService, OutpayHeaderService outpayHeaderService, PolicyService policyService) {
        this.textService = textService;
        this.surValueService = surValueService;
        this.outpayHeaderService = outpayHeaderService;
        this.policyService = policyService;
    }

    public void importFromFiles(Args args) {
        if (!StringUtils.isEmpty(args.getZtpspf())) {
            log.info("Ztpspf file: {}", args.getZtpspf());
            List<SurValueDto> surValueDtos = textService.readSurValues(Path.of(args.getZtpspf()));
            surValueDtos.forEach(surValuesDto -> log.debug("Surrender values object: {}", surValuesDto));
            surValueService.saveAll(surValueDtos);
        }
        if (!StringUtils.isEmpty(args.getOutph())) {
            log.info("Outpay header file: {}", args.getOutph());
            List<OutpayHeaderDto> outpayHeaderDtos = textService.readOutpayHeader(Path.of(args.getOutph()));
            outpayHeaderDtos.forEach(outpayHeaderDto -> log.debug("Outpay header object: {}", outpayHeaderDto));
            outpayHeaderService.saveAll(outpayHeaderDtos);
        }
        if (!StringUtils.isEmpty(args.getPolicy())) {
            log.info("Policy file: {}", args.getPolicy());
            List<PolicyDto> policyDtos = textService.readPolicy(Path.of(args.getPolicy()));
            policyDtos.forEach(policyDto -> log.debug("Policy object: {}", policyDto));
            policyService.saveAll(policyDtos);
        }
    }
}
