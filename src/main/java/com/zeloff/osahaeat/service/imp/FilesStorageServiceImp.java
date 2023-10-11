package com.zeloff.osahaeat.service.imp;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FilesStorageServiceImp {
    public boolean save(MultipartFile file);
    public Resource load(String filename);
}
