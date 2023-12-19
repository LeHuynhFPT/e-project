package com.example.eproject.service;

import com.example.eproject.entity.Gif;
import com.example.eproject.entity.User;
import com.example.eproject.repository.GifRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public interface GifService {
    String uploadFile(MultipartFile multipartFile);

    File convertMultiPartToFile(MultipartFile file) throws IOException;

    LinkedHashMap<String, Object> modifyJsonResponse(String requestType, String url);

    Gif findGifByIdAndUser(Long id, User currentUser);

    void deleteGif(Gif gif, User currentUser);

    Gif findGifById(Long id);

    void saveGifToDB(String url, String title, User currentUser);

    List<Gif> findGifByUser(User currentUser);
}
