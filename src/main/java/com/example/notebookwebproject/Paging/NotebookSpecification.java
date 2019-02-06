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

}
