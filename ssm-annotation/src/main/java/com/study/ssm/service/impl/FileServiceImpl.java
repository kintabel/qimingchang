package com.study.ssm.service.impl;

import cn.hutool.core.io.FileUtil;
import com.study.ssm.bean.Fileses;
import com.study.ssm.dao.FileDao;
import com.study.ssm.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileDao fileDao;

    @Value("${server.port:9090}")
    private String port;

    @Value("${ip:localhost}")
    private String ip;

    private String filePath = "D:\\file_upload"; // 根据实际情况调整

    @Override
    @Transactional
    public void upload(Fileses file) {
        fileDao.insert(file);
    }

    @Transactional
    public void uploadFile(MultipartFile multipartFile, String name) {
        Fileses file = new Fileses();
        file.setUploader(name);

        String originalFilename = multipartFile.getOriginalFilename();
        file.setName(originalFilename);

        String extName = FileUtil.extName(originalFilename);
        file.setType(extName);
        file.setCount(0);

        long flag = System.currentTimeMillis();
        String fileName = flag + "-" + originalFilename;
        file.setFile(fileName);

        java.io.File dirTemp = new java.io.File(filePath + "/" + name);
        if (!dirTemp.exists()) {
            dirTemp.mkdirs();
        }

        try {
            byte[] bytes = multipartFile.getBytes();
            double size = BigDecimal.valueOf(bytes.length)
                    .divide(BigDecimal.valueOf(1024), 3, RoundingMode.HALF_UP)
                    .doubleValue();
            file.setSize(size);

            java.io.File targetFile = new java.io.File(dirTemp, fileName);
            multipartFile.transferTo(targetFile);

            // 保存实际文件路径，而不是URL
            file.setPath(targetFile.getAbsolutePath());
        } catch (Exception e) {
            throw new RuntimeException("文件上传失败", e);
        }

        fileDao.insert(file);
    }

    @Override
    public List<Fileses> searchFilesByCategory(String category, int offset, int limit) {
        return fileDao.searchFilesByCategory(category, offset, limit);
    }

    @Override
    public int getTotalCountByCategory(String category) {
        return fileDao.getTotalCountByCategory(category);
    }

    @Override
    public List<Fileses> searchAllFiles(int offset, int limit) {
        return fileDao.searchAllFiles(offset, limit);
    }

    @Override
    public int getTotalFileCount() {
        return fileDao.getTotalFileCount();
    }

    @Override
    public Fileses getFileById(int id) {
        return fileDao.getFileById(id);
    }

    @Override
    public void download(Fileses file) {
        fileDao.addCount(file.getId());
    }

    @Override
    public List<String> getAllFileTypes() {
        return fileDao.getAllFileTypes();
    }

}
