/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab2.Punto2.Sources;

/**
 *
 * @author CristianCamilo
 */

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class JSONPrueba {

    public static int PRETTY_PRINT_INDENT_FACTOR = 4;
    public static void main(String[] args) {
        
        Vendedor v1 = new Vendedor();
        v1.setNombre("Juan");
        v1.setApellido("Perez");
        v1.setEdad(10);
        
        Cliente c1 = new Cliente();
        c1.setNombre("HIVYMAR");
        c1.setDireccion("Victor Emilio Estrada 204");
        c1.setTelefono("5020800");
        
        Cliente c2 = new Cliente();
        c2.setNombre("PROMESA");
        c2.setDireccion("Via. Daule KM 5.5");
        c2.setTelefono("5013604");
        
        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(c1);
        clientes.add(c2);
        
        //CREAMOS EL OBJETO JSON
        JSONObject objVendedor = new JSONObject(v1);
        JSONArray objClientes = new JSONArray();
        
        try {
            for (Cliente cliente : clientes) {
                JSONObject objCliente = new JSONObject();
                objCliente.put("nombre", cliente.getNombre());
                objCliente.put("direccion", cliente.getDireccion());
                objCliente.put("telefono", cliente.getTelefono());
                objClientes.put(objCliente);
            }
            JSONObject objVendedorClientes = new JSONObject();
            objVendedorClientes.put("vendedor", objVendedor);
            objVendedorClientes.put("clientes", objClientes);
            String jsonPrettyPrintString = objVendedorClientes.toString(PRETTY_PRINT_INDENT_FACTOR);
            System.out.println(jsonPrettyPrintString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
