import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String busca = " ";
        while (!(busca.equalsIgnoreCase("sair"))) {
            System.out.println("Digite o Número do CEP");
        busca = leitura.nextLine();

            if ((busca.equalsIgnoreCase("sair"))){
                break;
            }



            String endereco = "http://viacep.com.br/ws/" + busca + "/json/";

                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(endereco))
                            .build();
                    HttpResponse<String> response = client
                            .send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());

        }

        System.out.println("F  I M !");
    }
}