package com.contactos.views.usuarios;

import com.contactos.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Lista Usuarios")
@Route(value = "lista-usuarios", layout = MainLayout.class)
@RouteAlias(value = "lista-usuarios", layout = MainLayout.class)
@Uses(Icon.class)
public class ListaUsuariosView extends Composite<VerticalLayout> {

    public ListaUsuariosView() {
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
    }
}
