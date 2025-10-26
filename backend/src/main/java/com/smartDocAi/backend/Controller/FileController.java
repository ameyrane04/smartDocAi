package com.smartDocAi.backend.Controller;

import com.smartDocAi.backend.model.Document;
import com.smartDocAi.backend.service.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/api/files")
//@CrossOrigin(origins = "http://localhost:5173")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService){
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public ResponseEntity<Document> uploadFile (@RequestParam("file") MultipartFile file){
        try{
            Document savedDoc = fileService.saveFile(file);
            return ResponseEntity.ok(savedDoc);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
