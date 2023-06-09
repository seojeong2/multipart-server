package com.server.multipart.controller;

import com.server.multipart.service.UploadFileService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class UploadController {


    private final UploadFileService uploadFileService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {

        uploadFileService.uploadFile(file);
        return ResponseEntity.ok(true);
    }

}
