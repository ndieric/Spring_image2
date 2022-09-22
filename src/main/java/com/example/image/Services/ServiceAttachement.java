package com.example.image.Services;

import org.springframework.web.multipart.MultipartFile;

import com.example.image.Entity.Attachement;

public interface ServiceAttachement {

    Attachement saveAttachement(MultipartFile file) throws Exception;

    Attachement getAttachement(String id);



    
    
}


