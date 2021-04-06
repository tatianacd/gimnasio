package com.company;

public class Plan {

  private String nombre;
  private String descripcion;
  private String tipoDePlan;
  private Double precio;
  private Double descuento;


    public Plan(String nombre, String descripcion, String tipoDePlan, Double precio, Double descuento) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoDePlan = tipoDePlan;
        this.precio = precio;
        this.descuento = descuento;
    }

    public Plan() {

        this.nombre = "";
        this.descripcion = "";
        this.tipoDePlan = "";
        this.precio = 0.0;
        this.descuento = 0.0;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipoDePlan(String tipoDePlan) {
        this.tipoDePlan = tipoDePlan;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipoDePlan() {
        return tipoDePlan;
    }

    public Double getPrecio() {
        return precio;
    }

    public Double getDescuento() {
        return descuento;
    }
}
