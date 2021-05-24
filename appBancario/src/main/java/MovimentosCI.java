import java.math.BigDecimal;

public interface MovimentosCI {
    BigDecimal aplicar(BigDecimal deposito, int tempo);

    BigDecimal resgatar(BigDecimal valorResgate);
}

