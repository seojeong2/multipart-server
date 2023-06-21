package com.server.multipart.controller;

import com.server.multipart.service.UploadFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@CrossOrigin({"http://localhost:8081", "http://localhost:8083"})
@RestController
@RequiredArgsConstructor
@Slf4j
public class UploadController {


    private final UploadFileService uploadFileService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(HttpServletRequest request, @RequestParam(value = "image", required = false) MultipartFile file) throws IOException {

        log.info("call uploadFile");
        uploadFileService.uploadFile(file);
        return ResponseEntity.ok(true);
    }

}
