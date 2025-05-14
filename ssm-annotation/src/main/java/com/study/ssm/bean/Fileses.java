package com.study.ssm.bean;

public class Fileses {
    private Integer id;
    private String name;
    private String uploader;
    private Double size;
    private String type;
    private Integer count;
    private String path;
    private String file;

    public Fileses(Integer id, String name, String uploader, Double size, String type, Integer count, String path, String file) {
        this.id = id;
        this.name = name;
        this.uploader = uploader;
        this.size = size;
        this.type = type;
        this.count = count;
        this.path = path;
        this.file = file;
    }

    public Fileses() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
