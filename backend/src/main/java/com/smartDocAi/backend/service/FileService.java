package com.smartDocAi.backend.service;


import com.smartDocAi.backend.model.Document;
import com.smartDocAi.backend.model.UploadedFile;
import com.smartDocAi.backend.repository.DocumentRepository;
import com.smartDocAi.backend.repository.UploadedFileRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FileService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private final UploadedFileRepository uploadedFileRepository;
//    private final DocumentRepository documentRepository;

    public FileService(UploadedFileRepository uploadedFileRepository){
        this.uploadedFileRepository = uploadedFileRepository;
    }
//    public FileService(DocumentRepository documentRepository){
//        this.documentRepository = documentRepository;
//    }

    public UploadedFile saveFile(MultipartFile file) throws IOException {
        String filePath = uploadDir + File.separator + file.getOriginalFilename();
        File dest = new File(filePath);
        // Create directory if it doesn't exist
        dest.getParentFile().mkdirs();
        // Save file to local folder
        file.transferTo(dest);

        UploadedFile uploadedFile = new UploadedFile(
                file.getOriginalFilename(),
                filePath,
                file.getContentType(),
                file.getSize(),
                LocalDateTime.now()
        );

//        Document doc = new Document(file.getOriginalFilename(), filePath, LocalDateTime.now());
        return uploadedFileRepository.save(uploadedFile);

    }

    public List<UploadedFile> getAllFiles(){
        return  uploadedFileRepository.findAll();
    }
}
