package com.zeloff.osahaeat.controller;

import com.zeloff.osahaeat.payload.ResponseData;
import com.zeloff.osahaeat.service.imp.FilesStorageServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FilesController {
    @Autowired
    FilesStorageServiceImp filesStorageServiceImp;

    @PostMapping()
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file)  {
        ResponseData responseData = new ResponseData();
        boolean isSuccessSaveFile = filesStorageServiceImp.save(file);
        if(isSuccessSaveFile){
            responseData.setData(file.getOriginalFilename());
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/{filename:.+}")
    @ResponseBody
    public ResponseEntity<?> getFile(@PathVariable String filename) {
        Resource file = filesStorageServiceImp.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

}
