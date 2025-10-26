package com.smartDocAi.backend.service;


import com.smartDocAi.backend.model.Document;
import com.smartDocAi.backend.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class FileService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private final DocumentRepository documentRepository;

    public FileService(DocumentRepository documentRepository){
        this.documentRepository = documentRepository;
    }

    public Document saveFile(MultipartFile file) throws IOException {
        String filePath = uploadDir + File.separator + file.getOriginalFilename();

        File dest = new File(filePath);

        // Create directory if it doesn't exist
        dest.getParentFile().mkdirs();

        // Save file to local folder
        file.transferTo(dest);

        Document doc = new Document(file.getOriginalFilename(), filePath, LocalDateTime.now());
        return documentRepository.save(doc);

    }
}
