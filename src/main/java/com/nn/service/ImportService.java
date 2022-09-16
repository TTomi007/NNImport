package com.nn.service;

import com.nn.Args;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
public class ImportService {

    private final TextService textService;

    private static final Logger log = LoggerFactory.getLogger(ImportService.class);

    public ImportService(TextService textService) {
        this.textService = textService;
    }

    public void importFromFiles(Args args) {
        if (!StringUtils.isEmpty(args.getZtpspf())) {
            log.info("Ztpspf file: {}", args.getZtpspf());
            textService.readSurValues(Path.of(args.getZtpspf())).forEach(
                    surValuesDto -> log.info("Surrender values object: {}", surValuesDto));
        }
        if (!StringUtils.isEmpty(args.getOutph())) {
            log.info("Outpay header file: {}", args.getOutph());
            textService.readOutpayHeader(Path.of(args.getOutph())).forEach(
                    outpayHeaderDto -> log.info("Outpay header object: {}", outpayHeaderDto));
        }
        if (!StringUtils.isEmpty(args.getPolicy())) {
            log.info("Policy file: {}", args.getPolicy());
            textService.readPolicy(Path.of(args.getPolicy())).forEach(
                    policyDto -> log.info("Policy object: {}", policyDto));
        }
    }
}
