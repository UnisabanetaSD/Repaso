package co.edu.unisabaneta.mifactura;

import co.edu.unisabaneta.mifactura.modelo.Cliente;
import co.edu.unisabaneta.mifactura.modelo.Factura;
import co.edu.unisabaneta.mifactura.modelo.ItemFactura;
import co.edu.unisabaneta.mifactura.modelo.Producto;

import java.util.Scanner;

public class EjemploFactura {

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNit("544555-5");
        cliente.setNombre("UniSabaneta");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una descripcion de la Factura: ");
        String desc = scanner.nextLine();
        Factura factura = new Factura(1000, desc, cliente);

        Producto producto;
        String nombre;
        float precio;
        int cantidad;
        int codigo;

        System.out.println("");

        for (int i = 0; i < 3; i++) {

            producto = new Producto();
            System.out.print("Ingrese codigo producto n° " + (i + 1) + ":");
            codigo = scanner.nextInt();
            producto.setCodigo(codigo);

            System.out.print("Ingrese nombre producto n° " + (i + 1) + ":");
            nombre = scanner.next();
            producto.setNombre(nombre);

            System.out.print("Ingrese cantidad del producto: ");
            cantidad = scanner.nextInt();

            System.out.print("Ingrese precio del producto: ");
            precio = scanner.nextFloat();
            producto.setPrecio(precio);

            /*
            ItemFactura item = new ItemFactura();
            item.setCantidad(cantidad);
            item.setProducto(producto);
             */
            ItemFactura item = new ItemFactura(cantidad,producto);
            factura.addItemFactura(item);
            System.out.println();
        }
        System.out.println(factura.verDetalle());
    }
}
