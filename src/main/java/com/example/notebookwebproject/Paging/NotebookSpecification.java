package com.example.notebookwebproject.Paging;

import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class NotebookSpecification {
    public static Specification<Notebook> returnDefault(){
        return new Specification<Notebook>() {
            @Override
            public Predicate toPredicate(Root<Notebook> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return null;
            }
        };
    }
    public static Specification<Notebook> brandFilter(final String keyword) {
        return new Specification<Notebook>() {
            @Override
            public Predicate toPredicate(Root<Notebook> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("searchbrand"), "%" + keyword + "%");
            }
        };
    }
    public static Specification<Notebook> modelFilter(final String keyword) {
        return new Specification<Notebook>() {
            @Override
            public Predicate toPredicate(Root<Notebook> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("searchmodel"), "%" + keyword + "%");
            }
        };
    }
    public static Specification<Notebook> allFilter(final String keyword) {
        return new Specification<Notebook>() {
            @Override
            public Predicate toPredicate(Root<Notebook> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("searchall"), "%" + keyword + "%");
            }
        };
    }
    public static Specification<Notebook> searchBrand(final String[] brand){
     return new Specification<Notebook>() {
         @Override
         public Predicate toPredicate(Root<Notebook> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
             Predicate brandsList = criteriaBuilder.equal(root.get("brand"),brand[0]);
             for(int i=0; i<brand.length; i++){
                 if(i==0) {
                     System.out.println(brand[i]);
                     brandsList = criteriaBuilder.equal(root.get("brand"), brand[i]);
                 }
                 else{
                     System.out.println(brand[i]);
                     brandsList = criteriaBuilder.or(brandsList, criteriaBuilder.equal(root.get("brand"),brand[i]));
                 }
             }
             return brandsList;
         }
       };
    }

    public static Specification<Notebook> searchOS(final String[] os){
        return new Specification<Notebook>() {
            @Override
            public Predicate toPredicate(Root<Notebook> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate brandsList = criteriaBuilder.equal(root.get("os"),os[0]);
                for(int i=0; i<os.length; i++){
                    if(i==0) {
                        os[i] = ifThereisBlank(os[i]);
                        System.out.println(os[i]);
                        brandsList = criteriaBuilder.equal(root.get("os"), os[i]);
                    }
                    else{
                        os[i] = ifThereisBlank(os[i]);
                        System.out.println(os[i]);
                        brandsList = criteriaBuilder.or(brandsList, criteriaBuilder.equal(root.get("os"),os[i]));
                    }
                }
                return brandsList;
            }

            public String ifThereisBlank(String os){
                if (os.equals("MacOS"))
                    return "Mac OS";
                else if (os.equals("MacOSX"))
                    return "Mac OS X";
                else if (os.equals("MacOSSierra"))
                    return "Mac OS Sierra";
                else if (os.equals("운영체제미포함"))
                    return "운영체제 미포함";
                else
                    return os;
            }
        };
    }
    public static Specification<Notebook> searchMemorySize(final int [] memorysize){
        return new Specification<Notebook>() {
            @Override
            public Predicate toPredicate(Root<Notebook> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate memorysizeList = criteriaBuilder.equal(root.get("memorysize"),memorysize[0]);
                System.out.println("search memorysize");
                for(int i=0; i<memorysize.length; i++){
                    if(i==0) {
                        System.out.println(memorysize[i]);
                        memorysizeList = criteriaBuilder.equal(root.get("memorysize"), memorysize[i]);
                    }
                    else{
                        System.out.println(memorysize[i]);
                        memorysizeList = criteriaBuilder.or(memorysizeList, criteriaBuilder.equal(root.get("memorysize"),memorysize[i]));
                    }
                }
                return memorysizeList;
            }
        };
    }

    public static Specification<Notebook> searchMemorySizeGreater(final int memorysizegreater){
        return new Specification<Notebook>() {
            @Override
            public Predicate toPredicate(Root<Notebook> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("memorysize"), memorysizegreater);
            }
        };
    }

    public static Specification<Notebook> searchCPU(final String [] cpukind){
        return new Specification<Notebook>() {
            @Override
            public Predicate toPredicate(Root<Notebook> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                System.out.println("search cpukind");
                Predicate cpukindList = criteriaBuilder.equal(root.get("cpukind"),cpukind[0]);
                for(int i=0; i<cpukind.length; i++){
                    if(i==0) {
                        cpukind[i] = ifThereisBlank(cpukind[i]);
                        System.out.println(cpukind[i]);
                        cpukindList = criteriaBuilder.equal(root.get("cpukind"), cpukind[i]);
                    }
                    else{
                        cpukind[i] = ifThereisBlank(cpukind[i]);
                        System.out.println(cpukind[i]);
                        cpukindList = criteriaBuilder.or(cpukindList, criteriaBuilder.equal(root.get("cpukind"),cpukind[i]));
                    }
                }
                return cpukindList;
            }

            public String ifThereisBlank(String cpukind){
                if (cpukind.equals("펜티엄골드"))
                    return "펜티엄 골드";
                else if (cpukind.equals("라이젠3"))
                    return "라이젠 3";
                else if (cpukind.equals("라이젠7"))
                    return "라이젠 7";
                else
                    return cpukind;
            }
        };
    }
    public static Specification<Notebook> searchPrice(final String [] pricerange){
        return new Specification<Notebook>() {
            @Override
            public Predicate toPredicate(Root<Notebook> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                System.out.println("search price");
                Predicate pricerangeList = WhereisRange(root,criteriaBuilder,pricerange[0]);
                for(int i=0; i<pricerange.length; i++){
                    if(i==0) {
                        System.out.println(pricerange[i]);
                        pricerangeList = WhereisRange(root,criteriaBuilder,pricerange[i]);
                    }
                    else{
                        System.out.println(pricerange[i]);
                        pricerangeList = criteriaBuilder.or(pricerangeList, WhereisRange(root,criteriaBuilder,pricerange[i]));
                    }
                }
                    return pricerangeList;
            }

            public Predicate WhereisRange(Root<Notebook> root, CriteriaBuilder criteriaBuilder , String pricerange){
                if (pricerange.equals("range1"))
                    return criteriaBuilder.lessThanOrEqualTo(root.get("price"), 500000);
                else if (pricerange.equals("range2"))
                    return criteriaBuilder.between(root.get("price"), 500000,1000000);
                else if (pricerange.equals("range3"))
                    return criteriaBuilder.between(root.get("price"),1000000,1500000);
                else if (pricerange.equals("range4"))
                    return criteriaBuilder.between(root.get("price"),1500000,2000000);
                else if (pricerange.equals("range5"))
                    return criteriaBuilder.greaterThan(root.get("price"),2000000);
                else
                    System.out.println("exception");
                return criteriaBuilder.between(root.get("price"), 0, 5000000);
            }
        };
    }

    public static Specification<Notebook> searchSize(final int [] sizeinch){
        return new Specification<Notebook>() {
            @Override
            public Predicate toPredicate(Root<Notebook> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate sizeinchList = criteriaBuilder.equal(root.get("sizeinch"),sizeinch[0]);
                System.out.println("search sizeinch");
                for(int i=0; i<sizeinch.length; i++){
                    if(i==0) {
                        System.out.println(sizeinch[i]);
                        sizeinchList = criteriaBuilder.equal(root.get("sizeinch"), sizeinch[i]);
                    }
                    else{
                        System.out.println(sizeinch[i]);
                        sizeinchList = criteriaBuilder.or(sizeinchList, criteriaBuilder.equal(root.get("sizeinch"),sizeinch[i]));
                    }
                }
                return sizeinchList;
            }
        };
    }

    public static Specification<Notebook> searchWeight(final String [] weight){
        return new Specification<Notebook>() {
            @Override
            public Predicate toPredicate(Root<Notebook> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                System.out.println("search weight");
                Predicate weightList = WhereisRange(root,criteriaBuilder,weight[0]);
                for(int i=0; i<weight.length; i++){
                    if(i==0) {
                        System.out.println(weight[i]);
                        weightList = WhereisRange(root,criteriaBuilder,weight[i]);
                    }
                    else{
                        System.out.println(weight[i]);
                        weightList = criteriaBuilder.or(weightList, WhereisRange(root,criteriaBuilder,weight[i]));
                    }
                }
                return weightList;
            }

            public Predicate WhereisRange(Root<Notebook> root, CriteriaBuilder criteriaBuilder, String weight){
                if (weight.equals("range1"))
                    return criteriaBuilder.lessThanOrEqualTo(root.get("weight"), 1000);
                else if (weight.equals("range2"))
                    return criteriaBuilder.between(root.get("weight"), 1000,1500);
                else if (weight.equals("range3"))
                    return criteriaBuilder.between(root.get("weight"), 1500,2000);
                else if (weight.equals("range4"))
                    return criteriaBuilder.greaterThan(root.get("weight"),2000);
                else
                    System.out.println("exception");
                return criteriaBuilder.between(root.get("weight"), 0,5000);
            }
        };
    }

    public static Specification<Notebook> searchDisksize(final String [] disksize){
        return new Specification<Notebook>() {
            @Override
            public Predicate toPredicate(Root<Notebook> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                System.out.println("search disksize");
                Predicate disksizeList = WhereisRange(root,criteriaBuilder,disksize[0]);
                for(int i=0; i<disksize.length; i++){
                    if(i==0) {
                        System.out.println(disksize[i]);
                        disksizeList = WhereisRange(root,criteriaBuilder,disksize[i]);
                    }
                    else{
                        System.out.println(disksize[i]);
                        disksizeList = criteriaBuilder.or(disksizeList, WhereisRange(root,criteriaBuilder,disksize[i]));
                    }
                }
                return disksizeList;
            }

            public Predicate WhereisRange(Root<Notebook> root, CriteriaBuilder criteriaBuilder, String weight){
                if (weight.equals("range1"))
                    return criteriaBuilder.lessThan(root.get("disksize"), 128);
                else if (weight.equals("range2"))
                    return criteriaBuilder.between(root.get("disksize"), 128,255);
                else if (weight.equals("range3"))
                    return criteriaBuilder.between(root.get("disksize"), 256,511);
                else if (weight.equals("range4"))
                    return criteriaBuilder.between(root.get("disksize"), 512,1023);
                else if (weight.equals("range5"))
                    return criteriaBuilder.greaterThan(root.get("disksize"),1024);
                else
                    System.out.println("exception");
                return criteriaBuilder.between(root.get("disksize"), 0,5000);
            }
        };
    }

    public static Specification<Notebook> searchCPURankingGreater(final int cpurankinggreater){
        return new Specification<Notebook>() {
            @Override
            public Predicate toPredicate(Root<Notebook> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                System.out.println("search cpurakinggreater" + cpurankinggreater);
                return criteriaBuilder.greaterThanOrEqualTo(root.get("cpuranking"),cpurankinggreater);
            }
        };
    }

    public static Specification<Notebook> searchCPURankingLess(final int cpurankingless){
        return new Specification<Notebook>() {
            @Override
            public Predicate toPredicate(Root<Notebook> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                System.out.println("search cpurakingless");
                return criteriaBuilder.lessThanOrEqualTo(root.get("cpuranking"),cpurankingless);
            }
        };
    }

    public static Specification<Notebook> searchGPURankingLess(final int gpurankingless){
        return new Specification<Notebook>() {
            @Override
            public Predicate toPredicate(Root<Notebook> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                System.out.println("search gpurakingless");
                return criteriaBuilder.lessThanOrEqualTo(root.get("gpuranking"),gpurankingless);
            }
        };
    }

    public static Specification<Notebook> searchKeyboard(final String[] keyboard){
        return new Specification<Notebook>() {
            @Override
            public Predicate toPredicate(Root<Notebook> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate keyboardList = WhatKeyboard(root,criteriaBuilder,keyboard[0]);
                for(int i=0; i<keyboard.length ; i++){
                    if(i==0) {
                        System.out.println(keyboard[i]);
                        keyboardList = WhatKeyboard(root,criteriaBuilder,keyboard[i]);
                    }
                    else{
                        System.out.println(keyboard[i]);
                        keyboardList = criteriaBuilder.or(keyboardList, WhatKeyboard(root,criteriaBuilder,keyboard[i]));
                    }
                }
                return keyboardList;
            }

            public Predicate WhatKeyboard(Root<Notebook> root, CriteriaBuilder criteriaBuilder,String keyboard){
                Predicate keyboardList = criteriaBuilder.equal(root.get("id"),0);
                if(keyboard.equals("numkb")) {
                    System.out.println("숫자");
                    keyboardList = criteriaBuilder.equal(root.get("numkb"), 1);
                }
                if(keyboard.equals("blockkb")) {
                    System.out.println("블록");
                    keyboardList = criteriaBuilder.or(keyboardList, criteriaBuilder.equal(root.get("blockkb"), 1));
                }
                if(keyboard.equals("machinekb")) {
                    System.out.println("기계");
                    keyboardList = criteriaBuilder.or(keyboardList, criteriaBuilder.equal(root.get("machinekb"), 1));
                }
                if(keyboard.equals("rgblight")) {
                    System.out.println("rgb");
                    keyboardList = criteriaBuilder.or(keyboardList, criteriaBuilder.equal(root.get("rgblight"), 1));
                }
                if(keyboard.equals("kblight")) {
                    System.out.println("키보드빛");
                    keyboardList = criteriaBuilder.or(keyboardList, criteriaBuilder.equal(root.get("kblight"), 1));
                }
                if(keyboard.equals("waterproofkb")) {
                    System.out.println("방수");
                    keyboardList = criteriaBuilder.or(keyboardList, criteriaBuilder.equal(root.get("waterproofkb"), 1));
                }
                return keyboardList;
            }
        };
    }
    public static Specification<Notebook> searchETC(final String[] etc){
        return new Specification<Notebook>() {
            @Override
            public Predicate toPredicate(Root<Notebook> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate etcList = WhatETC(root,criteriaBuilder,etc[0]);
                for(int i=0; i<etc.length ; i++){
                    if(i==0) {
                        System.out.println(etc[i]);
                        etcList = WhatETC(root,criteriaBuilder,etc[i]);
                    }
                    else{
                        System.out.println(etc[i]);
                        etcList = criteriaBuilder.or(etcList, WhatETC(root,criteriaBuilder,etc[i]));
                    }
                }
                return etcList;
            }
            public Predicate WhatETC(Root<Notebook> root, CriteriaBuilder criteriaBuilder,String etc){
                Predicate etcList = criteriaBuilder.equal(root.get("id"),0);
                if(etc.equals("face")) {
                    System.out.println("얼굴인식");
                    etcList = criteriaBuilder.equal(root.get("face"), 1);
                }
                if(etc.equals("fingerprint")) {
                    System.out.println("지문인식");
                    etcList = criteriaBuilder.or(etcList, criteriaBuilder.equal(root.get("fingerprint"), 1));
                }
                if(etc.equals("tpm")) {
                    System.out.println("TPM");
                    etcList = criteriaBuilder.or(etcList, criteriaBuilder.equal(root.get("tpm"), 1));
                }
                return etcList;
            }
        };
    }
    public static Specification<Notebook> searchFace(final int face){
        return new Specification<Notebook>() {
            @Override
            public Predicate toPredicate(Root<Notebook> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("face"), face);
            }
        };
    }
    public static Specification<Notebook> searchFingerprint(final int fingerprint){
        return new Specification<Notebook>() {
            @Override
            public Predicate toPredicate(Root<Notebook> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("fingerprint"), fingerprint);
            }
        };
    }

}
