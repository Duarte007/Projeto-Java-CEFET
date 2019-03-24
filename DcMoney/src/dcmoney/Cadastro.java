package dcmoney;
public class Cadastro {
    private String nome;
    private double conta=0;
    private double Agencia=0;
    private double salario=0;
    private double limite=0;
    private String senha;
    private String login;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getLogin(){
        return login;
    }
    
    public void setLogin(String login){
        this.login=login;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public void setSenha(String senha){
        this.senha=senha;
    }

    public double getConta() {
        return conta;
    }

    public void setConta(double conta) {
        this.conta = conta;
    }

    public double getAgencia() {
        return Agencia;
    }

    public void setAgencia(double Agencia) {
        this.Agencia = Agencia;
    }
    
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    
    public void verificarSalario() throws SalarioInvalidoException{
        if(salario<=0){
            throw new SalarioInvalidoException("\nSalario Inválido");
        }
    }
    
    public void verificarCadastroLimite() throws LimiteInvalidoException{
        if(limite<=0){
            throw new LimiteInvalidoException("\nLimite Inválido");
        }
    }
    
}
