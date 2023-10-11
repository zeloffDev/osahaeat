package com.zeloff.osahaeat.service;

import com.zeloff.osahaeat.service.imp.FilesStorageServiceImp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;


@Service
public class FilesStorageService implements FilesStorageServiceImp {
    private Path root = null;
    @Value("${fileUpload.rootPath}")
    private String rootPath;

    public void init() {
        try {
            root = Paths.get(rootPath);
            if (Files.notExists(root)) {
                Files.createDirectories(root);
            }
        } catch (IOException e) {
            System.out.println("Could not initialize folder for upload! " + e);
        }
    }

    @Override
    public boolean save(MultipartFile file) {
        try {
            init();
            Files.copy(file.getInputStream(), this.root.resolve(Objects.requireNonNull(file.getOriginalFilename())), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Resource load(String filename) {
        try {
            init();
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
        } catch (MalformedURLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}
