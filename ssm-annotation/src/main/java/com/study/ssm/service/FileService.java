package com.study.ssm.service;

import com.study.ssm.bean.Fileses;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    void upload(Fileses file);
    List<Fileses> searchFilesByCategory(String category, int offset, int limit);
    int getTotalCountByCategory(String category);
    List<Fileses> searchAllFiles(int offset, int limit);
    int getTotalFileCount();
    Fileses getFileById(int id);
    void download(Fileses file);
    void uploadFile(MultipartFile multipartFile, String name);
    List<String> getAllFileTypes();
}