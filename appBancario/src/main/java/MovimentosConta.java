import java.math.BigDecimal;

public interface MovimentosConta {
    BigDecimal sacar(BigDecimal saque);

    BigDecimal depositar(BigDecimal deposito);

    BigDecimal transferir(BigDecimal transfere);
}
