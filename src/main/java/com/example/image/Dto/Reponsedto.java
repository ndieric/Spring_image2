package com.example.image.Dto;

public class Reponsedto {
    private String fileName;
    private String downloadurl;
    private String fileType;
    private Long fileSizer;
    public Reponsedto() {
    }
    public Reponsedto(String fileName, String downloadurl, String fileType, long l) {
        this.fileName = fileName;
        this.downloadurl = downloadurl;
        this.fileType = fileType;
       
    }
    
    public Reponsedto(Long fileSizer) {
        this.fileSizer = fileSizer;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getDownloadurl() {
        return downloadurl;
    }
    public void setDownloadurl(String downloadurl) {
        this.downloadurl = downloadurl;
    }
    public String getFileType() {
        return fileType;
    }
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    public Long getFileSizer() {
        return fileSizer;
    }
    public void setFileSizer(Long fileSizer) {
        this.fileSizer = fileSizer;
    }
    

    

    
}
