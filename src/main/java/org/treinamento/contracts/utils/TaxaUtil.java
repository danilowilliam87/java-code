package org.treinamento.contracts.utils;

public class TaxaUtil {

    public static double definirTaxa(Double pagamento){
        return pagamento < 100.0 ? 0.2 : 0.15;
    }
}
