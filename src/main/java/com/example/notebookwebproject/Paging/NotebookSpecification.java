package com.example.notebookwebproject.Paging;

import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.Predicate;

public class NotebookSpecification {
   public static Specification<Notebook> searchNotebook(Map<String, Object> filter){
       return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList();
            filter.forEach((key,value)->{
              String likeValue = "%" + value + "%";
              switch (key){
                  case "brand":
                      predicates.add(criteriaBuilder.like(root.get(key).as(String.class), likeValue));
                      break;
              }
            });

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
       });
   }
}
