package com.example.image.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Attachement {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private String id;
    private String fileName;
    private String filType;
    private byte[] data;
    public Attachement() {
    }
    public Attachement(String fileName, String filType, byte[] data) {
        this.fileName = fileName;
        this.filType = filType;
        this.data = data;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getFilType() {
        return filType;
    }
    public void setFilType(String filType) {
        this.filType = filType;
    }
    public byte[] getData() {
        return data;
    }
    public void setData(byte[] data) {
        this.data = data;
    }

    

    

    
    
}
