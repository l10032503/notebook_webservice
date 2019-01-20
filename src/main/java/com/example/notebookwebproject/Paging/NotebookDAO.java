package com.example.notebookwebproject.Paging;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotebookDAO extends JpaRepository<Notebook, Integer> {
}
