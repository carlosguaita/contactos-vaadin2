package com.contactos.views.listacontactos;

import com.contactos.models.Contacto;
import com.contactos.utils.Util;
import com.contactos.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import java.util.List;

@PageTitle("Lista Contactos")
@Route(value = "", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class ListaContactosView extends Composite<VerticalLayout> {

    List<Contacto> contactos;
    Grid<Contacto> grid;

    Button botonNuevoContacto;

    public ListaContactosView() {
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        botonNuevoContacto=new Button("Nuevo Contacto");
        botonNuevoContacto.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        botonNuevoContacto.addClickListener(e->onClickNuevoContacto());
        grid = new Grid<>(Contacto.class, false);
        grid.addColumn(Contacto::getNombre).setHeader("Nombre").setAutoWidth(true);
        grid.addColumn(Contacto::getCedula).setHeader("Cedula").setAutoWidth(true);
        grid.addColumn(Contacto::getTelefono).setHeader("Teléfono").setAutoWidth(true);
        grid.addColumn(Contacto::getCorreo).setHeader("Correo").setAutoWidth(true);
        grid.addColumn(
                new ComponentRenderer<>(contacto -> {
                    Button botonBorrar = new Button();
                    botonBorrar.addThemeVariants(ButtonVariant.LUMO_ERROR);
                    botonBorrar.addClickListener(e -> onClickBorrarContacto(contacto));
                    botonBorrar.setIcon(new Icon(VaadinIcon.TRASH));

                    Button botonEditar = new Button();
                    botonEditar.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
                    botonEditar.addClickListener(e -> {

                    });
                    botonEditar.setIcon(new Icon(VaadinIcon.EDIT));

                    HorizontalLayout buttons = new HorizontalLayout(botonBorrar,botonEditar);
                    return buttons;
                })).setHeader("Manage").setAutoWidth(true);
        contactos = Util.listaContactos;
        grid.setItems(contactos);
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        getContent().add(botonNuevoContacto,grid);
    }

    public void onClickBorrarContacto(Contacto contacto){
        contactos.remove(contacto);
        grid.getDataProvider().refreshAll();
    }

    public void onClickNuevoContacto(){
        botonNuevoContacto.getUI().ifPresent(ui -> ui.navigate("nuevo-contacto"));
    }



}
