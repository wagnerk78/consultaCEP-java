public class CEP implements Comparable<CEP> {

    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public CEP(CepConsultados cepColhidos) {
        this.logradouro = cepColhidos.logradouro();
        this.complemento = cepColhidos.complemento();
        this.bairro = cepColhidos.bairro();
        this.localidade = cepColhidos.localidade();
        this.uf = cepColhidos.uf();
    }


    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String Logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public int compareTo(CEP o) {
        return this.getLogradouro().compareTo(o.getLogradouro());
    }
    @Override
    public String toString() {
        return "Logradouro: " + logradouro;
    }


}
