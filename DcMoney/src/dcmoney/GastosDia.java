package dcmoney;
public class GastosDia extends Cadastro {
    private double gasto;
    private double gastoTotal;

    public double getGasto() {
        return gasto;
    }

    public void setGasto(double gasto) {
        this.gasto = gasto;
    }

    public double getGastoTotal() {
        return gastoTotal;
    }

    public void setGastoTotal() {
        gastoTotal = gastoTotal+gasto;
    }
    
    public void verificarGastoDiario() throws GastoInvalidoException{
        if(gasto<=0){
            throw new GastoInvalidoException("Gasto Inválido");
        }
    }
}
