
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtractorOfContentIMDB implements ExtractorOfContent {

    @Override
    public List<Content> listOfContent(String data) {

        JsonParser parser = new JsonParser();
        List<Map<String, String>> listOfData = parser.parse(data);

        List<Content> contents = new ArrayList<>();
        
        for(Map<String, String> item: listOfData){
            String imageUrl = item.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
            String title = item.get("title").replace(":", "-");
            Content content = new Content(title,imageUrl );
            contents.add(content);
        }

        return contents;
    }

}
