package com.example.notebookwebproject.Paging;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class Notebook {

    @Id
    private int id;

    private String model, cpukind, cpumanufact;

    @Column(columnDefinition = "text")
    private String imgurlf, imgurlb, longimgurl,pricestring, note, searchbrand, searchmodel, searchall;

    private int price, weight, memorysize, sizeinch;
    private float battery, sizeint;

    private int adapter, sizecm, resolution, hddsize, ssdsize, afterservice, cpuranking, gpuranking, disksize,
            tablet, school;
    private float thick;
    private String brand, cpucode, cpunumber, cpucore, memorytype,
            gpumanufact, gpukind, ssd, os, recommendgroup, grade;

    private Boolean pantoscopic, lancable, lanradio, bluetooth, hdmitwo, hdmi, minidp, dp, dsub, webcam,
            usbtypectrd, usbtypec, usbtrdone, usbtrd, usbsnd, thunderbolt, esata, ieee, serialport, expresscard,
            multireader, numkb, blockkb, machinekb, rgblight, kblight, waterproofkb, milstd, face, fingerprint, tpm,
            worldwarranty;
}
