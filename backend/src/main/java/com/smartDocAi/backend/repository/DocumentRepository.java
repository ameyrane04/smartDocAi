package com.smartDocAi.backend.repository;

import com.smartDocAi.backend.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
