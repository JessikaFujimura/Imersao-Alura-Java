
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtractorOfContentNasa implements ExtractorOfContent {

    @Override
    public List<Content> listOfContent(String data) {

        JsonParser parser = new JsonParser();
        List<Map<String, String>> listOfData = parser.parse(data);

        List<Content> contents = new ArrayList<>();
        for (Map<String, String> item : listOfData) {
            String title = item.get("title").replace(":", "-");
            String url = item.get("url");
            Content content = new Content(title, url);
            contents.add(content);
        }

        return contents;
    }

}
