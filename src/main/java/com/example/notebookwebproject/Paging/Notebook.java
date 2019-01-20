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
    private String imgurlf, imgurlb, longimgurl,price_string, note;

    private int price, weight, memory_size;
    private float battery, sizeint;

    private int adapter, sizecm, resolution, hddsize, ssd_size, afterservice, cpu_ranking, gpu_ranking;
    private float thick;
    private String brand, cpu_code, cpu_number, cpu_core, memory_type,
            gpu_manufact, gpu_kind, ssd, os, recommend_group;

    private Boolean pantoscopic, lan_cable, lan_radio, bluetooth, hdmitwo, hdmi, minidp, dp, dsub, webcam,
            usb_typectrd, usb_typec, usb_trdone, usb_trd, usb_snd, thunderbolt, esata, ieee, serialport, expresscard,
            multireader, numkb, blockkb, machinekb, rgblight, kblight, waterproofkb, milstd, face, fingerprint, tpm,
            worldwarranty;
}
