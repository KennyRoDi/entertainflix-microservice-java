package com.example.microservice.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.UUID;

public class RequestDecisionResponseDTO {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("requestId")
    private String requestId;

    @JsonProperty("cliente")
    private String cliente;

    @JsonProperty("correo")
    private String correo;

    @JsonProperty("servicio")
    private String servicio;

    @JsonProperty("paquete")
    private String paquete;

    @JsonProperty("ofertante")
    private String ofertante;

    @JsonProperty("status")
    private String status;

    @JsonProperty("razon")
    private String razon;

    @JsonProperty("decidedAt")
    private LocalDateTime decidedAt;

    @JsonProperty("decidedBy")
    private String decidedBy;

    public RequestDecisionResponseDTO(
            UUID id,
            String requestId,
            String cliente,
            String correo,
            String servicio,
            String paquete,
            String ofertante,
            String status,
            String razon,
            LocalDateTime decidedAt,
            String decidedBy) {
        this.id = id;
        this.requestId = requestId;
        this.cliente = cliente;
        this.correo = correo;
        this.servicio = servicio;
        this.paquete = paquete;
        this.ofertante = ofertante;
        this.status = status;
        this.razon = razon;
        this.decidedAt = decidedAt;
        this.decidedBy = decidedBy;
    }

    public RequestDecisionResponseDTO() {
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getPaquete() {
        return paquete;
    }

    public void setPaquete(String paquete) {
        this.paquete = paquete;
    }

    public String getOfertante() {
        return ofertante;
    }

    public void setOfertante(String ofertante) {
        this.ofertante = ofertante;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public LocalDateTime getDecidedAt() {
        return decidedAt;
    }

    public void setDecidedAt(LocalDateTime decidedAt) {
        this.decidedAt = decidedAt;
    }

    public String getDecidedBy() {
        return decidedBy;
    }

    public void setDecidedBy(String decidedBy) {
        this.decidedBy = decidedBy;
    }
}

