package com.server.multipart.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@Slf4j
public class UploadFileService {

    private String dir = "/Users/seojeong/Desktop/test_save_dir/";


    public String uploadFile(MultipartFile file) throws IOException {

        if(file.isEmpty()) {
            return null;
        }
        String originalFilename = file.getOriginalFilename(); // 원래 파일명
        log.info("originalFilename: " + originalFilename);

        // 파일 특정경로에 저장
        String serverUploadFileName = createServerFileName(originalFilename);
        file.transferTo(new File(getFullPath(serverUploadFileName, dir)));

        return "success";
    }
    public String getFullPath(String filename, String fileDir) {
        return fileDir + filename;
    }

    private String createServerFileName(String originalFilename) {
        String uuid = UUID.randomUUID().toString();
        String ext = extractExt(originalFilename);

        return uuid + "." + ext;
    }

    // 원래 파일명에서 확장자 뽑기
    private String extractExt(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos+1);
    }
}
