package com.company;

public class Main {

    public static void main(String[] args) throws DatosIncorrectosException {
	/*
	*
	* Sistema para gestión de socios en un gimnasio

Se require armar un sistema que permita dar de alta a un nuevo socio con sus datos personales, el plan y
* la sede en la que entrenará.

Los datos necesarios son: documento, nombre, telefono.

Por favor -> no escribir documentos o telefonos reales en las bases de datos de prueba. NUNCA.

Existe un listado de 10 sedes disponibles:
capital, calamuchita, tucuman, santa fe, tigre, mendoza, siete, belgrano, nuñez, palermo

Cada sede tiene su dirección y teléfono.

Los planes disponibles son: mensual, anual, promo
El promo tiene un 20% de descuento de por vida.
El costo mensual es de $10
El costo anual es de $100
El plan promo es anual y sólo se otorga a los socios cuyo nombre empieza con A, B, C o D.

Consignas de prueba:
1) Listar todos los socios de una sede.
2) Listar todos los socios de un plan.
3) Permitir agregar un nuevo socio.

	*
	* */

        Gimnasio gimnasio = new Gimnasio();
        Socio socio = null;


            socio = new Socio("Francini", "9080-1090","123456789",7,1);
            gimnasio.agregarSocio(socio);



       //gimnasio.listarSociosDeSede(1);
      //gimnasio.listarSociosDePlan(1);
    }
}
