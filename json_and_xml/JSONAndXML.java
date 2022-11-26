package json_and_xml;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.*;

public class JSONAndXML {

    public static void main(String[] args) throws Exception {
        xmlToJSON();
    }

    public static void jsonToXML() throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("json_and_xml/users.json")), StandardCharsets.UTF_8);
        JSONArray jsonArr = new JSONArray(content);
        String finalXML = "<root>";
        for (int i = 0; i < jsonArr.length(); i++) {
            finalXML += "<user>" + XML.toString(jsonArr.getJSONObject(i)) + "</user>";
        }
        finalXML += "</root>";

        PrintWriter out = new PrintWriter("json_and_xml/output.xml");
        out.print(finalXML);
        out.close();

        System.out.println("XML saved to: output.xml");

    }

    public static void xmlToJSON() throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("json_and_xml/data.xml")), StandardCharsets.UTF_8);

        JSONObject jsonObject = XML.toJSONObject(content);

        PrintWriter out = new PrintWriter("json_and_xml/output.json");
        out.print(jsonObject.toString(4));
        out.close();
        System.out.println("JSON saved to: output.json");

    }

}