package com.contactos.utils;

import com.contactos.models.Contacto;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static List<Contacto> listaContactos = new ArrayList<>(
            List.of(
                    new Contacto("Carlos","carlos.guaita@udla.edu.ec","179845632","0987654321"),
                    new Contacto("Luis","luis.perez@udla.edu.ec","17234567","098644344"),
                    new Contacto("lorena","lorena.gomez@udla.edu.ec","172234232","09453453")
            )
    );
}
