package com.example.microservice.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public class RequestDecisionRequestDTO {

    @NotBlank(message = "requestId is required")
    @JsonProperty("requestId")
    private String requestId;

    @NotBlank(message = "cliente is required")
    @JsonProperty("cliente")
    private String cliente;

    @NotBlank(message = "correo is required")
    @JsonProperty("correo")
    private String correo;

    @JsonProperty("telefono")
    private String telefono;

    @JsonProperty("mensaje")
    private String mensaje;

    @JsonProperty("ubicacion")
    private String ubicacion;

    @NotBlank(message = "servicio is required")
    @JsonProperty("servicio")
    private String servicio;

    @JsonProperty("paquete")
    private String paquete;

    @NotBlank(message = "ofertante is required")
    @JsonProperty("ofertante")
    private String ofertante;

    @NotBlank(message = "decision is required (ACCEPTED or DENIED)")
    @JsonProperty("decision")
    private String decision;

    @JsonProperty("razon")
    private String razon;

    // Constructors
    public RequestDecisionRequestDTO() {
    }

    public RequestDecisionRequestDTO(
            String requestId,
            String cliente,
            String correo,
            String telefono,
            String mensaje,
            String ubicacion,
            String servicio,
            String paquete,
            String ofertante,
            String decision,
            String razon) {
        this.requestId = requestId;
        this.cliente = cliente;
        this.correo = correo;
        this.telefono = telefono;
        this.mensaje = mensaje;
        this.ubicacion = ubicacion;
        this.servicio = servicio;
        this.paquete = paquete;
        this.ofertante = ofertante;
        this.decision = decision;
        this.razon = razon;
    }

    // Getters and Setters
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
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

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }
}
