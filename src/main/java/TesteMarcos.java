
import br.com.dasa.wsecosistemasclient.EcoSistemas;
import br.com.dasa.wsecosistemasclient.EcosistemasSqlDao;
import br.com.dasa.wsecosistemasclient.RetornoStatus;
import java.math.BigDecimal;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author f12684146896
 */
public class TesteMarcos {

    public static void main(String[] args) {
        
        RetornoStatus retornoStatus = new RetornoStatus("1349515493", "HEM","01", "", "", "", BigDecimal.ZERO, "", BigDecimal.ONE, "01", Boolean.TRUE, "");

        EcosistemasSqlDao.updateEnviados(retornoStatus);
        
        
    }
}
