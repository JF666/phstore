package com.jf.crud.bean;

public class Ramrom {
    private Integer rmid;

    private String ram;

    private String rom;

    public Integer getRmid() {
        return rmid;
    }

    public void setRmid(Integer rmid) {
        this.rmid = rmid;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram == null ? null : ram.trim();
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom == null ? null : rom.trim();
    }
}