package com.example.microservice.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class RequestDecision {

    private final UUID id;
    private final String requestId;
    private final String cliente;
    private final String correo;
    private final String telefono;
    private final String mensaje;
    private final String ubicacion;
    private final String servicio;
    private final String paquete;
    private final String ofertante;
    private final DecisionStatus status;
    private final String razon;
    private final LocalDateTime decidedAt;
    private final String decidedBy;

    public RequestDecision(
            UUID id,
            String requestId,
            String cliente,
            String correo,
            String telefono,
            String mensaje,
            String ubicacion,
            String servicio,
            String paquete,
            String ofertante,
            DecisionStatus status,
            String razon,
            LocalDateTime decidedAt,
            String decidedBy) {
        this.id = id;
        this.requestId = requestId;
        this.cliente = cliente;
        this.correo = correo;
        this.telefono = telefono;
        this.mensaje = mensaje;
        this.ubicacion = ubicacion;
        this.servicio = servicio;
        this.paquete = paquete;
        this.ofertante = ofertante;
        this.status = status;
        this.razon = razon;
        this.decidedAt = decidedAt;
        this.decidedBy = decidedBy;
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getCliente() {
        return cliente;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getServicio() {
        return servicio;
    }

    public String getPaquete() {
        return paquete;
    }

    public String getOfertante() {
        return ofertante;
    }

    public DecisionStatus getStatus() {
        return status;
    }

    public String getRazon() {
        return razon;
    }

    public LocalDateTime getDecidedAt() {
        return decidedAt;
    }

    public String getDecidedBy() {
        return decidedBy;
    }
}
