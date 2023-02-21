
import Servicios.ServicioAutor;
import Servicios.ServicioLibreria;



/**
 *
 * @author Tonna/SA FR34K
 *
 */

/**/
public class Libreria {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception{
        
        //ServicioLibreria serv = new ServicioLibreria();
        //serv.Menu();
        
        ServicioAutor sa = new ServicioAutor();
        sa.buscarunautor();
        
    }
}
