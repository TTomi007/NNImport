package com.nn;

import com.beust.jcommander.Parameter;

public class Args {

    @Parameter(names = { "-z", "-ztpspf" }, description = "ZTPSPF file path")
    private String ztpspf;

    @Parameter(names = { "-o", "-outph" }, description = "OUTPH file path")
    private String outph;

    @Parameter(names = { "-p", "-policy" }, description = "Policy file path")
    private String policy;

    public String getZtpspf() {
        return ztpspf;
    }

    public void setZtpspf(String ztpspf) {
        this.ztpspf = ztpspf;
    }

    public String getOutph() {
        return outph;
    }

    public void setOutph(String outph) {
        this.outph = outph;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }
}
