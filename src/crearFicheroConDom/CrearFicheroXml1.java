
package crearFicheroConDom;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author alumnotd
 */
public class CrearFicheroXml1 {
    public static void main(String[] args) {
        
        File f= new File("coches.xml");//el fichero coche se crea en carpeta raiz del programa
        
        ArrayList<Coche> listaCoches = new ArrayList();
        //creamos los objetos que contendran los datos, previamente se ha creado la clase coche
        Coche coche1 = new Coche(1, "Renault", "Megane", 16000);
        Coche coche2 = new Coche(2, "Seat", "Toledo", 12000);
        Coche coche3 = new Coche(3, "Suzuki", "Vitara", 15000);
        
        //añadimos los alementos al arraylist
        listaCoches.add(coche1);
        listaCoches.add(coche2);
        listaCoches.add(coche3);
        
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            //elemento raiz
            Element raiz = doc.createElement("Coches");
            doc.appendChild(raiz);
            
            for (int i = 0; i < listaCoches.size(); i++) {
            //creamos el elemento del cual van a colgar las propiedades
            Element coche = doc.createElement("coche");
            raiz.appendChild(coche);
            
            //atributo
            Attr atributo = doc.createAttribute("id");
            atributo.setValue(String.valueOf(listaCoches.get(i).getId()));
            coche.setAttributeNode(atributo);
            
            //propiedad marca
            Element marca = doc.createElement("marca");
            marca.setTextContent(listaCoches.get(i).getMarca());
            coche.appendChild(marca);
            
            //propiedad modelo
            Element modelo = doc.createElement("modelo");
            modelo.setTextContent(listaCoches.get(i).getModelo());
            coche.appendChild(modelo);
            
            //propiedad precio
            Element precio = doc.createElement("precio");
            precio.setTextContent(String.valueOf(listaCoches.get(i).getPrecio()));
            coche.appendChild(precio);
            
            //fin del bucle para que creer los elementos tantos como objetos haya en el arraylist
            }
            
            
            
            Source source = new DOMSource(doc);
            Result result = new StreamResult(f);
            Transformer transformer  = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty("indent", "yes");
            transformer.transform(source, result);
            
            System.out.println("Datos y fichero creado con exito");
            
            
            
         } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
        }catch(TransformerException  t){
            System.out.println(t.getMessage());
        }
        
    }
            
}
