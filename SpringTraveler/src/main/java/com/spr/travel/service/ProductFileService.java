package com.spr.travel.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Service
public interface ProductFileService {

    String uploadFile(MultipartFile titleImage) throws Exception;

    String uploadHtmlImage(MultipartFile file, List<String> imageNameList) throws Exception;

    public String updateFile(String originalTitleImage, MultipartFile titleImage) throws Exception;

    boolean deleteFileById(int id) throws Exception;

    void deleteFile(String fileName) throws Exception;

}
