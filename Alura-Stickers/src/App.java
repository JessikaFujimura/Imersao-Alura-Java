import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        String urlApi = "https://api.nasa.gov/planetary/apod?api_key=5wyZf49PBeVqIXIll0lKlfq2rjdlxTnk4Jpln5BU&start_date=2022-07-01&end_date=2022-07-20";
        // String urlApi = "https://api.mocki.io/v2/549a5d8b";
        // String urlApi = "http://localhost:8080/languages";

        ClientHttp clientHttp = new ClientHttp();
        String data = clientHttp.getData(urlApi);

        ExtractorOfContent extractorOfContent = new ExtractorOfContentNasa();
        // ExtractorOfContent extractorOfContent = new ExtractorOfContentIMDB();
        List<Content> listOfContent = extractorOfContent.listOfContent(data);

        GenerateOfStickers generateOfStickers = new GenerateOfStickers();

        for (Content item : listOfContent) {
             InputStream inputStream = new URL(item.getImageUrl()).openStream();
            String title = item.getTitle();
            System.out.println(title);
            generateOfStickers.create(inputStream, title);

        }

    }
}
