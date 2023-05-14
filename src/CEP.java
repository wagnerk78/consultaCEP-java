public class CEP {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public CEP(CepConsultados cepColhidos) {
        this.cep=cepColhidos.cep();
        this.logradouro = cepColhidos.logradouro();
        this.complemento = cepColhidos.complemento();
        this.bairro = cepColhidos.bairro();
        this.localidade = cepColhidos.localidade();
        this.uf = cepColhidos.uf();
    }

    @Override
    public String toString() {
        return "CEP: " + cep + " Logradouro: " + logradouro + " Complemento: " + complemento + " Bairro: " + bairro +
                " Cidade: " + localidade + " Estado: " + uf;
    }


}
