package com.example.notebookwebproject.Paging;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NotebookDAO extends JpaRepository<Notebook, Integer>, JpaSpecificationExecutor<Notebook> {

}
