package com.tinylibrary.dto;

public class BookResponseDTO {

    private String name;
    private Integer agebook;
    private String editorial;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAgebook() {
        return agebook;
    }

    public void setAgebook(Integer agebook) {
        this.agebook = agebook;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
