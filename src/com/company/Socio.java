package com.company;

public class Socio {

    private String nombre;
    private String telefono;
    private String documento;
    private int sede;
    private int plan;

    public Socio(String nombre, String telefono, String documento, int sede, int plan) throws DatosIncorrectosException{
        this.nombre = nombre;
        this.telefono = telefono;
        this.documento = documento;
        this.sede = sede;
        setPlan(plan);
    }

    public Socio() throws DatosIncorrectosException{
        this.nombre = "";
        this.telefono = "";
        this.documento = "";
        this.sede = 0;
        this.plan = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getSede() {
        return sede;
    }

    public void setSede(int sede) {
        this.sede = sede;
    }

    public int getPlan() {
        return plan;
    }

    public void setPlan(int plan) throws DatosIncorrectosException {
        String nombre = this.getNombre().toUpperCase();

        if(plan == 1 && !(nombre.startsWith("A",0) || nombre.startsWith("B",0) ||
                nombre.startsWith("C",0) || nombre.startsWith("D",0))){
            throw new DatosIncorrectosException("No se puede crear este socio xq su nombre no inicia con ABCD");
        }

        this.plan = plan;
    }
}
