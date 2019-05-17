package com.jf.crud.bean;

public class Cpuinfo {
    private Integer cpuid;

    private String cpuname;

    private String cputech;

    private String cpufqu;

    public Integer getCpuid() {
        return cpuid;
    }

    public void setCpuid(Integer cpuid) {
        this.cpuid = cpuid;
    }

    public String getCpuname() {
        return cpuname;
    }

    public void setCpuname(String cpuname) {
        this.cpuname = cpuname == null ? null : cpuname.trim();
    }

    public String getCputech() {
        return cputech;
    }

    public void setCputech(String cputech) {
        this.cputech = cputech == null ? null : cputech.trim();
    }

    public String getCpufqu() {
        return cpufqu;
    }

    public void setCpufqu(String cpufqu) {
        this.cpufqu = cpufqu == null ? null : cpufqu.trim();
    }
}