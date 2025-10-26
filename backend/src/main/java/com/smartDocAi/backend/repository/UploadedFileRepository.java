package com.smartDocAi.backend.repository;


import com.smartDocAi.backend.model.UploadedFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadedFileRepository extends JpaRepository<UploadedFile, Long> {
}
