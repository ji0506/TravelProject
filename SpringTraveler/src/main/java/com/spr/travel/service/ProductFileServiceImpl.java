package com.spr.travel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductFileServiceImpl implements ProductFileService{

    @Override
    public String uploadFile(MultipartFile titleImage) throws Exception {
        return null;
    }

    @Override
    public String uploadHtmlImage(MultipartFile file, List<String> imageNameList) throws Exception {
        return null;
    }

    @Override
    public String updateFile(String originalTitleImage, MultipartFile titleImage) throws Exception {
        return null;
    }

    @Override
    public boolean deleteFileById(int id) throws Exception {
        return false;
    }

    @Override
    public void deleteFile(String fileName) throws Exception {

    }
}
