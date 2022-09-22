package com.example.image.Controller;

import java.net.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.image.Dto.Reponsedto;
import com.example.image.Entity.Attachement;
import com.example.image.Services.ServiceAttachement;

@RestController
public class AttachementController {


    private ServiceAttachement serviceAttachement;

    public AttachementController(ServiceAttachement serviceAttachement) {
        this.serviceAttachement = serviceAttachement;
    }

    @PostMapping("/upload")
    public Reponsedto uploadfile(@RequestParam("file") MultipartFile file){
        Attachement attachement =null;
        String downloadurl;
        try {
            attachement = serviceAttachement.saveAttachement(file);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        downloadurl = ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/download/")
        .path(attachement.getId())
        .toUriString();


    return new Reponsedto(attachement.getFileName(),
    downloadurl,
    file.getContentType(),
    file.getSize());

    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String id){
            Attachement attachement = null;
            attachement = serviceAttachement.getAttachement(id);
            return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(attachement.getFilType()))
            .header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION,
            "attachement; fileName=\"" +attachement.getFileName()
            +"\"")
            .body(new ByteArrayResource(attachement.getData()));
    }
    
    
}
