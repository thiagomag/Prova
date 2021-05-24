import java.math.BigDecimal;

public interface MovimentosPO {
    BigDecimal sacarPO(BigDecimal saque);

    BigDecimal depositarPO(BigDecimal deposito);

    BigDecimal trasferirPO(BigDecimal transfere);
}
