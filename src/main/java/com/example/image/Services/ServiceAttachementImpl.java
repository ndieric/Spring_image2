package com.example.image.Services;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.image.Entity.Attachement;
import com.example.image.Repository.AttechementRepository;

@Service
public class ServiceAttachementImpl implements ServiceAttachement {

     private AttechementRepository attechementRepository;
     

    public ServiceAttachementImpl(AttechementRepository attechementRepository) {
        this.attechementRepository = attechementRepository;
    }


    @Override
    public Attachement saveAttachement(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try{
            if(fileName.contains("..")){
                throw new Exception("fileName contians invalid sequece"+fileName);
            }
            Attachement attachement 
                 =new Attachement(fileName,
                 file.getContentType(),
                 file.getBytes());
            return attechementRepository.save(attachement);

        }catch(Exception e){
            throw new Exception("could not save file"+fileName);

        }

        
    }

    public Attachement getAttachement(Long id) throws Exception{
        return attechementRepository
        .findById(id).orElseThrow(() -> new Exception("file not found with "+id));
    }


    @Override
    public Attachement getAttachement(String id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
