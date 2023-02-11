/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ipc1.s12023_practica1_202201947;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Pablo Rodriguez
 * // este si es el codigo
 */

class Venta{
    String cliente;
    String producto;
    double prec;
    int creporte;
    int cfactura;
}

class Cdescuento{
    String Codigo;
    double cantdescuento;
}


public class IPC1S12023_PRACTICA1_202201947 {

    public static Scanner scannernumerico = new Scanner(System.in);
    public static Scanner scannercadenas = new Scanner(System.in);
    public static Venta[] product = new Venta[1000];
    public static Venta[] preci = new Venta[1000];
    public static Cdescuento[] pordes = new Cdescuento[1000];
    
    
    
        public static void cliente(){
            System.out.println("INGRESE SU NOMBRE:");
            String client = scannercadenas.nextLine();
            
    }
    // METODO CASE 1
    public static void AgregarProducto(){
    
            
                System.out.println("--------------------------------------------------------------");
                int a=0;
                int creport=0, cfactur=0;
                
                System.out.println("INGRESE EL PRODUCTO: ");
                String producto = scannercadenas.nextLine();
                Venta productos = new Venta();
                productos.producto = producto;
                
                for(int i=0; i< product.length;i++){
                    if(product[i]==null){
                        break;
                    }
                    else{
                        while(product[i].producto.equals(producto)==true){
                            System.out.println("PRODUCTO REPETIDO, INGRESE UNO NUEVO; ");
                            producto = scannercadenas.nextLine();
                            productos.producto = producto;

                        }
                            
                    }
                }                

                System.out.println("INGRESE EL PRECIO DEL PRODUCTO: ");
                double precio = scannernumerico.nextDouble();
                if (precio>0){
                Venta prec = new Venta();
                prec.prec = precio;
                
                for(int i=0; i< product.length;i++){
                    if(product[i] == null){ 
                        product[i]= productos;
                        prec.creporte = creport;
                        
                        break;
                    }
                }
                
                
                for(int i=0; i< preci.length;i++){
                    if(preci[i] == null){ 
                        preci[i]= prec;
                        prec.cfactura = cfactur;
                        
                        break;
                    }
                }
                
             for(int i=0; i< product.length;i++){
                if(product[i]==null){
                    System.out.println("");
                    break;
                }
            System.out.println(product[i].producto +" - "+ preci[i].prec);
            
        }
                }
                else{
                    System.out.println("PRECIO INVALIDO DEBE SER MAYOR A 0");
                }
                
              
                
    }
    
    // METODO CASE 2
    public static void AgregarCupones(){
            String Codigo;
            double cantdescuento;
            long contadorletras;
            System.out.println("INGRESE SU CODIGO PARA VALIDAR SU DESCUENTO: ");
            Codigo = scannercadenas.nextLine();
            Cdescuento peras = new Cdescuento();
            peras.Codigo = Codigo;
            
            
            
            for(int i=0; i< pordes.length;i++){
                    if(pordes[i]==null){
                        break;
                    }
                    else{
                        while(pordes[i].Codigo.equals(Codigo)==true){
                            System.out.println("CODIGO REPETIDO, INGRESE UNO NUEVO; ");
                            Codigo = scannercadenas.nextLine();
                            peras.Codigo = Codigo;

                        }
                            
                    }
                }
            
            
            contadorletras = Codigo.chars().filter(ch -> ch!= ' ').count();
            System.out.println("SU CODIGO CONSTA DE : "+contadorletras+ " CARACTERES");
            
            while(contadorletras !=4){
                System.out.println("SU CODIGO NO ES VALIDO DEBE TENER 4 LETRAS INTENTE DE NUEVO");
                contadorletras = Codigo.chars().filter(ch -> ch!= ' ').count();
                
                System.out.println(contadorletras);
                break;
            }
            
            if(contadorletras==4){
                System.out.println("SU CODIGO CONTIENE 4 LETRAS, ES VALIDO");
                System.out.println("INGRESE LA CANTIDAD DE DESCUENTO QUE POSEE (1-99)%");
                cantdescuento= scannernumerico.nextDouble();
                
                if(cantdescuento>0 && cantdescuento<100){
                    
                    Cdescuento cantdescuentos = new Cdescuento();
                    
                    cantdescuentos.Codigo = Codigo;
                    cantdescuentos.cantdescuento = cantdescuento;
                    
                    for(int i=0; i<pordes.length;i++){
                        if(pordes[i]==null){
                        pordes[i] = cantdescuentos;
                        break;
                        }
                    }
                    for(int i=0; i<pordes.length;i++){
                        if(pordes[i]==null){
                        break;
                        }
                        System.out.println(pordes[i].Codigo + " con descuento de: " + pordes[i].cantdescuento);
                    }
                    
                }else{
                    System.out.println("CODIGO INVALIDO INTENTE DE NUEVO"); 
                }
                
            }
            
            
    }
    //METODO CASE 3
    public static void EditarProductoFactura(){
        //variables locales
        String producto, co;
        double subtotal=0, total=0;
        long nit;
        int cantarticulos=0;
        double cantdescuento=0;
        int hola=0;
        
        System.out.println("BIENVENIDO A PROCESO DE COMPRA");
        System.out.println("INGRESE SU NOMBRE:");
        String client = scannercadenas.nextLine();
        
        for(int mayo=0; mayo<product.length;mayo++){
            if(product[mayo]==null){
                break;
            }
            else
            {
                product[mayo].cfactura=0;
                product[mayo].creporte=0;
            }
        }
        System.out.println("DECEA AGREGAR NIT? 1=si   0=no");
        int numnit = scannernumerico.nextInt();
        if(numnit!=1 && numnit!=0){
            System.out.println("ingreso uno incorrecto");
            System.out.println("");
        }
        else if (numnit == 1)
        {
                    
            System.out.println("INGRESE SU NIT: ");
            nit=scannernumerico.nextInt();
            for (int i=0; i<product.length;i++){
                if(product[i]==null){
                    break;
                }
                else{
                   product[i].cfactura=0;
                }
            }
            System.out.println("LOS PRODUCTOS EN LA BASE DE DATOS SON: ");
            
            for(int i=0;i <product.length;i++){
                if(product[i]==null){
                break;
                }
                System.out.println(product[i].producto +" - "+ preci[i].prec);
            }
                
            do{
                System.out.println("SELECCIONE LOS PRODUCTOS QUE DECEA COMPRAR(ESCRIBA EL NOMBRE DEL PRODUCTO IGUALQUE EN LA BASE DE DATOS)");
                producto = scannercadenas.nextLine();
                
                
                
                System.out.println("CUANTOS ARTICULOS DECEA LLEVAR");
                cantarticulos = scannernumerico.nextInt();
                if(cantarticulos>0){
                for(int i=0; i<product.length; i++){
                        if(product[i]==null){
                            break;
                        }else if(product[i].producto.equals(producto)==true){
                            product[i].cfactura = product[i].cfactura+cantarticulos;
                            product[i].creporte = product[i].creporte+cantarticulos;
                            subtotal = subtotal +(cantarticulos * preci[i].prec);
                            System.out.println(subtotal);
                        }
                        }
                for(int i=0; i<product.length;i++){
                    if(product[i]==null){
                        break;
                    }
                    System.out.println( product[i].producto +"      Q."+ preci[i].prec + " "  );
                }
                System.out.println("DECEA COMPRAR OTRO ARTICULO? 1=si, 0=no");
                hola = scannernumerico.nextInt();

                
                }
                else{
                    System.out.println("LA CANTIDAD SELECCIONADA ES INCORRECTA, SE LE COLOCARA LA CANTIDAD DE '1' POR DEFECTO");
                    cantarticulos = 1;
                    for(int i=0; i<product.length; i++){
                        if(product[i]==null){
                            break;
                        }else if(product[i].producto.equals(producto)==true){
                            product[i].cfactura = product[i].cfactura+cantarticulos;
                            product[i].creporte = product[i].creporte+cantarticulos;
                            subtotal = subtotal +(cantarticulos * preci[i].prec);
                            System.out.println(subtotal);
                        }
                        }
                for(int i=0; i<product.length;i++){
                    if(product[i]==null){
                        break;
                    }
                    System.out.println( product[i].producto +"      Q."+ preci[i].prec + " "  );
                }
                System.out.println("DECEA COMPRAR OTRO ARTICULO? 1=si, 0=no");
                hola = scannernumerico.nextInt();
                    
                    
                    
                    
                }
                
                
            }while(hola!=0);
            
            int op;
            System.out.println("SU SUBTOTAL ES: " + subtotal);
            System.out.println("TIENE ALGUN CODIGO DE DESCUENTO? 1=si, 0=no");
            op = scannernumerico.nextInt();
            
            if(op==1){
                System.out.println("INGRESE EL CODIGO DE DESCUENTO");
                co = scannercadenas.nextLine();
                for(int i = 0;i<pordes.length;i++){
                    if(pordes[i]==null){
                        break;
                    }
                    else if(pordes[i].Codigo.equals(co)==true){
                        double pollo;
                        pollo = subtotal;
                        
                        subtotal = pordes[i].cantdescuento * subtotal *0.01;
                        cantdescuento=(pordes[i].cantdescuento);
                        total = pollo - subtotal;
                        
                        
                        System.out.println("---------------------------------------");
                        System.out.println("FACTURA");
                        System.out.println("SUPER 25 --------- FACTURA NO.001");
                        System.out.println("ATENIDO POR: PABLO RODRIGUEZ LIMA");
                        DateTimeFormatter hora = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");
                        System.out.println("DIRECCION: CIUDAD" +"  "+ hora.format(LocalDateTime.now()) );
                        System.out.println("CLIENTE: " + client);
                        System.out.println("NIT: " + nit);
                        
                        for(int r=0; r<product.length; r++){
                            if(product[r]==null){
                                break;
                            }
                            else if (product[r].cfactura>0){
                             System.out.println("Cantidad ---- Producto ---- Precio");
                             System.out.println("    "+product[r].creporte +"          "+ product[r].producto +"           "+ preci[r].prec);   
                                
                            }
                        }
                        System.out.println("EL SUBTOTAL ES: " +  pollo);
                        System.out.println("SU CODIGO TIENE UN DESCUENTO DE: " + cantdescuento + "%");
                        System.out.println("EL TOTAL ES: " + total);
                        System.out.println("---------------------------------------");
                        
                    }
                }
            }
            else if (op==0){
        
                        System.out.println("---------------------------------------");
                        System.out.println("FACTURA");
                        System.out.println("SUPER 25 --------- FACTURA NO.001");
                        System.out.println("ATENIDO POR: PABLO RODRIGUEZ LIMA");
                        DateTimeFormatter hora = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");
                        System.out.println("DIRECCION: CIUDAD" + hora.format(LocalDateTime.now()) );
                        System.out.println("CLIENTE: " + client);
                        System.out.println("NIT: " + nit);
                        
                        for(int r=0; r<product.length; r++){
                            if(product[r]==null){
                                break;
                            }
                            else if (product[r].cfactura>0){
                             System.out.println("Cantidad ---- Producto ---- Precio");
                             System.out.println("    "+product[r].creporte +"          "+ product[r].producto +"        "+ preci[r].prec);   
                                
                            }
                        }
                        System.out.println("EL TOTAL ES: " +  subtotal);
                        System.out.println("---------------------------------------");
                        
                    }
                }
   
            
            
        else
        {
            {
            System.out.println("SU NIT SERÁ C/F");
            
            for (int i=0; i<product.length;i++){
                if(product[i]==null){
                    break;
                }
                else{
                   product[i].cfactura=0;
                }
            }
            System.out.println("LOS PRODUCTOS EN LA BASE DE DATOS SON: ");
            
            for(int i=0;i <product.length;i++){
                if(product[i]==null){
                break;
                }
                System.out.println(product[i].producto +" - "+ preci[i].prec);
            }
                
            do{
                System.out.println("SELECCIONE LOS PRODUCTOS QUE DECEA COMPRAR(ESCRIBA EL NOMBRE DEL PRODUCTO IGUALQUE EN LA BASE DE DATOS)");
                producto = scannercadenas.nextLine();
                
                
                
                
                
                
                System.out.println("CUANTOS ARTICULOS DECEA LLEVAR");
                cantarticulos = scannernumerico.nextInt();
                
                
                if(cantarticulos>0){
                    
                
                for(int i=0; i<product.length; i++){
                        if(product[i]==null){
                            break;
                        }else if(product[i].producto.equals(producto)==true){
                            product[i].cfactura = product[i].cfactura+cantarticulos;
                            product[i].creporte = product[i].creporte+cantarticulos;
                            subtotal = subtotal +(cantarticulos * preci[i].prec);
                            System.out.println(subtotal);
                        }
                        }
                for(int i=0; i<product.length;i++){
                    if(product[i]==null){
                        break;
                    }
                    System.out.println( product[i].producto +"      Q."+ preci[i].prec + " "  );
                }
                System.out.println("DECEA COMPRAR OTRO ARTICULO? 1=si, 0=no");
                hola = scannernumerico.nextInt();
                }
                
                else{
                    System.out.println("LA CANTIDAD SELECCIONADA ES INCORRECTA, SE LE COLOCARA LA CANTIDAD DE '1' POR DEFECTO");
                    cantarticulos = 1;
                    for(int i=0; i<product.length; i++){
                        if(product[i]==null){
                            break;
                        }else if(product[i].producto.equals(producto)==true){
                            product[i].cfactura = product[i].cfactura+cantarticulos;
                            product[i].creporte = product[i].creporte+cantarticulos;
                            subtotal = subtotal +(cantarticulos * preci[i].prec);
                            System.out.println(subtotal);
                        }
                        }
                for(int i=0; i<product.length;i++){
                    if(product[i]==null){
                        break;
                    }
                    System.out.println( product[i].producto +"      Q."+ preci[i].prec + " "  );
                }
                System.out.println("DECEA COMPRAR OTRO ARTICULO? 1=si, 0=no");
                hola = scannernumerico.nextInt();
                    
                    
                    
                    
                }
                
            }while(hola!=0);
            
            
            int op;
            System.out.println("SU SUBTOTAL ES: " + subtotal);
            System.out.println("TIENE ALGUN CODIGO DE DESCUENTO? 1=si, 0=no");
            op = scannernumerico.nextInt();
            
            if(op==1){
                System.out.println("INGRESE EL CODIGO DE DESCUENTO");
                co = scannercadenas.nextLine();
                for(int i = 0;i<pordes.length;i++){
                    if(pordes[i]==null){
                        break;
                    }
                    else if(pordes[i].Codigo.equals(co)==true){
                        double pollo;
                        pollo = subtotal;
                        
                        subtotal = pordes[i].cantdescuento * subtotal *0.01;
                        cantdescuento=(pordes[i].cantdescuento);
                        total = pollo - subtotal;
                        
                        
                        System.out.println("---------------------------------------");
                        System.out.println("FACTURA");
                        System.out.println("SUPER 25 --------- FACTURA NO.001");
                        System.out.println("ATENIDO POR: PABLO RODRIGUEZ LIMA");
                        DateTimeFormatter hora = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");
                        System.out.println("DIRECCION: CIUDAD" +"  "+ hora.format(LocalDateTime.now()) );
                        System.out.println("CLIENTE: " + client);
                        System.out.println("NIT: C/F");
                        
                        for(int r=0; r<product.length; r++){
                            if(product[r]==null){
                                break;
                            }
                            else if (product[r].cfactura>0){
                             System.out.println("Cantidad ---- Producto ---- Precio");
                             System.out.println("    "+product[r].creporte +"          "+ product[r].producto +"           "+ preci[r].prec);   
                                
                            }
                        }
                        System.out.println("EL SUBTOTAL ES: " +  pollo);
                        System.out.println("SU CODIGO TIENE UN DESCUENTO DE: " + cantdescuento + "%");
                        System.out.println("EL TOTAL ES: " + total);
                        System.out.println("---------------------------------------");
                        break;
                    }
                }
            }
            else if (op==0){
        
                        System.out.println("---------------------------------------");
                        System.out.println("FACTURA");
                        System.out.println("SUPER 25 --------- FACTURA NO.001");
                        System.out.println("ATENIDO POR: PABLO RODRIGUEZ LIMA");
                        DateTimeFormatter hora = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");
                        System.out.println("DIRECCION: CIUDAD" + hora.format(LocalDateTime.now()) );
                        System.out.println("CLIENTE: " + client);
                        System.out.println("NIT: C/F" );
                        
                        for(int r=0; r<product.length; r++){
                            if(product[r]==null){
                                break;
                            }
                            else if (product[r].cfactura>0){
                             System.out.println("Cantidad ---- Producto ---- Precio");
                             System.out.println("    "+product[r].creporte +"          "+ product[r].producto +"        "+ preci[r].prec);   
                                
                            }
                        }
                        System.out.println("EL TOTAL ES: " +  subtotal);
                        System.out.println("---------------------------------------");
                        
                        
                    }
            
                }
            
            
        }
    
            
            
            System.out.println("GRACIAS POR SU COMPRA");
            for (int i = 0; i < 5; i++) {
                              System.out.println();
                          }
            
    }   
        
        
    
    //METODO CASE 4
    public static void Reporte(){
        System.out.println("-------------------------------------------------------------");
        
        System.out.println(" REPORTE DE LOS PRODUCTOS VENDIDOS (ORDENADOS POR EL PRECIO)");
        for(int i=0; i < product.length; i++){
            for(int j=0; j < product.length-1;j++){
                if(product[j]==null || product[j+1]==null){
                    break;
                }
                Venta productoactual = product[j+1];
                Venta productosiguiente = product[j];
                if(productoactual.creporte>productosiguiente.creporte){
                    product[j+1]=productosiguiente;
                    product[j]=productoactual;
                    
                }
            }
            
        }
        for(int i=0; i<product.length; i++){
            if(product[i]==null)
            {
                break;
            }
            System.out.println("Cantidad ---- Producto ---- Precio");
            System.out.println("    "+product[i].creporte +"          "+ product[i].producto +"        "+ preci[i].prec);
            
        }
        
    }
    
    public static void menuprincipal(){
        int opcion = 0;
        do{
            
        System.out.println("MENU");
        System.out.println("1. AGREGAR PRODUCTOS PARA COMPRAR (BASE DE DATOS)");
        System.out.println("2. AGREGAR CUPONES DE DESCUENTO");
        System.out.println("3. EDITAR / CONFIRMAR VENTA -FACTURA- ");
        System.out.println("4. REPORTE");
        System.out.println("5. SALIR");
            System.out.println("INGRESE UNA OPCION");
            opcion = scannernumerico.nextInt();
            switch(opcion){
                case 1:
                    
                    AgregarProducto();
                    break;
                case 2:
                    AgregarCupones();
                    break;
                case 3:
                    EditarProductoFactura();
                    break;
                case 4:
                    Reporte();
                    break;
                case 5:
                    System.out.println("ESTA SALIENDO DEL PROGRAMA");
                    break;
                    
                default: 
                        System.out.println("NO INGRESO UNA OPCION CORRECTA");
            }
        }while(opcion!=5);
    }
    public static void main(String[] args) {
        
        // variables locales
        int a;
        //LOGIN
        //---------------------------LOG IN ---------------------------------
        
        System.out.println("BIENVENIDO A SUPER 25");
        System.out.println("-----------------------------------------------------------------");
        
         
        do{
           System.out.println("INGRESE SU USUARIO");
           Scanner usuario = new Scanner(System.in);
           String USUARIO = usuario.nextLine();
            //cajero_202201947
            if (USUARIO.equals("cajero_202201947"))
            {
                System.out.println("INGRESE SU CONTRASEÑA");
                //ipc1_202201947
                Scanner contraseña = new Scanner(System.in);
                String CONTRASEÑA = contraseña.nextLine();
                if (CONTRASEÑA.equals("ipc1_202201947"))
                  {
                      System.out.println("BIENVENIDO: " + USUARIO);
                      a=0;
                      
                     for (int i = 0; i < 100; i++) {
                              System.out.println();
                          }
                      System.out.println("------------------------------------------------------------");
                      System.out.println("BIENVENIDO " + USUARIO);
                    }
                else{
                   System.out.println("CONTRASEÑA INCORRECTA, INTENTE DE NUEVO");
                   a=1;
                }
            }
            else {
                  System.out.println("USUARIO INCORRECTO INGRESE DE NUEVO");
                 a=1;
              }
            } while(a!=0);
        //MENUPRINCIPAL
        menuprincipal();
        
        
        
        
        //SI SE PUDO :)
    }
       
}
