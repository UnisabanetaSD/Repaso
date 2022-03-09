package co.edu.unisabaneta.mifactura.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {

    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] items;
    private static final int MAX_ITEMS = 10;
    private int indiceItems;

    public Factura(){}

    public Factura(int folio, String descripcion, Cliente cliente) {
        this.folio = folio;
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.fecha = new Date();
        this.items = new ItemFactura[MAX_ITEMS];
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemFactura[] getItems() {
        return items;
    }

    public void setItems(ItemFactura[] items) {
        this.items = items;
    }

    public float calcularTotal() {
        float total = 0;
/*
        for(int i=0;i<items.length;i++){
        }
*/
        for (ItemFactura item : this.items) {
            if (item == null) {
                continue;
            }
            total = total + item.calcularImporte();
        }
        return total;
    }

    public String verDetalle() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        StringBuilder sb = new StringBuilder("Factura N°: ");
        sb.append(this.folio)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\nNIT: ")
                .append(this.cliente.getNit())
                .append("\nDescripcion: ")
                .append(this.descripcion)
                .append("\nFecha Emision: ")
                .append(dateFormat.format(this.fecha))
                .append("\n")
                .append("\nItem\tNombre\tPrecio\tCanti\tTotal\n");
        for (ItemFactura item : this.items) {
            if (item == null) {
                continue;
            }
            sb.append(item.getProducto().getCodigo())
                    .append("\t")
                    .append(item.getProducto().getNombre())
                    .append("\t")
                    .append(item.getProducto().getPrecio())
                    .append("\t")
                    .append(item.getCantidad())
                    .append("\t")
                    .append(item.calcularImporte())
                    .append("\n");
        }
        sb.append("\nGran Total: ")
                .append(calcularTotal());
        return sb.toString();
    }

    public void addItemFactura(ItemFactura item) {
        if (indiceItems < MAX_ITEMS) {
            this.items[indiceItems++] = item;
        }
    }

}
