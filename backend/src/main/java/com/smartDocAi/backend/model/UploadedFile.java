package com.smartDocAi.backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "uploaded_files")
public class UploadedFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String filePath;
    private String fileType;
    private Long size;
    private LocalDateTime uploadedAt;

    public UploadedFile(){}

    public UploadedFile(String fileName, String filePath, String fileType, Long size, LocalDateTime uploadedAt) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileType = fileType;
        this.size = size;
        this.uploadedAt = uploadedAt;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getFileName() { return fileName; }
    public String getFilePath() { return filePath; }
    public String getFileType() { return fileType; }
    public Long getSize() { return size; }
    public LocalDateTime getUploadedAt() { return uploadedAt; }

    public void setId(Long id) { this.id = id; }
    public void setFileName(String fileName) { this.fileName = fileName; }
    public void setFilePath(String filePath) { this.filePath = filePath; }
    public void setFileType(String fileType) { this.fileType = fileType; }
    public void setSize(Long size) { this.size = size; }
    public void setUploadedAt(LocalDateTime uploadedAt) { this.uploadedAt = uploadedAt; }
}
