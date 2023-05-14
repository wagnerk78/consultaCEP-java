import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner leitura = new Scanner(System.in);
        String busca = " ";

        List<CEP> enderecos = new ArrayList<>();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        while (!(busca.equalsIgnoreCase("sair"))) {
            System.out.println("Digite o Número do CEP");
        busca = leitura.nextLine();

            if ((busca.equalsIgnoreCase("sair"))){
                break;
            }



            String endereco = "https://viacep.com.br/ws/" + busca + "/json";

                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(endereco))
                            .build();
            HttpResponse<String> response = null;
            try {
                response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            CepConsultados cepColhidos = new Gson().fromJson(response.body(), CepConsultados.class);
            //System.out.println(cepColhidos);
            CEP arquivosceps = new CEP(cepColhidos);

            enderecos.add(arquivosceps);

            System.out.println(arquivosceps);

        }
       FileWriter escrita = new FileWriter("endereco9.json");
       escrita.write(gson.toJson(enderecos));
       escrita.close();
        System.out.println(enderecos);
        System.out.println("F  I  M !");
    }
}