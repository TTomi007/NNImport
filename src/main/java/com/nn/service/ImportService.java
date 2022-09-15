package com.nn.service;

import com.nn.Args;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ImportService {

    private static final Logger log = LoggerFactory.getLogger(ImportService.class);

    public void importFromFiles(Args args) {
        if (!StringUtils.isEmpty(args.getZtpspf())) {
            log.info("Ztpspf file: {}", args.getZtpspf());
        }
        if (!StringUtils.isEmpty(args.getOutph())) {
            log.info("Outpay header file: {}", args.getOutph());
        }
        if (!StringUtils.isEmpty(args.getPolicy())) {
            log.info("Policy file: {}", args.getPolicy());
        }
    }
}
