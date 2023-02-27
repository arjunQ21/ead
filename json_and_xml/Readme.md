# JSON and XML Conversion

## Objective

- To convert from json to xml and vice versa


## Theory

- JSON and XML are widely used information sharing methodologies. In this lab, we convert json data to xml and vice versa.

## Steps to Convert JSON to XML

- First import org.json package
- Use JSONArray class to convert json data in string to xml data
- Wrap Converted array of xml data in some root element
- Save output in ./output.xml file

```java
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

```

## Steps to Convert XML to JSON

- First import org.json package
- Use XML.toJSONObject class to convert xml data in string to json data
- Save Output in ./output.json file

```java
   public static void xmlToJSON() throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("json_and_xml/data.xml")), StandardCharsets.UTF_8);

        JSONObject jsonObject = XML.toJSONObject(content);

        PrintWriter out = new PrintWriter("json_and_xml/output.json");
        out.print(jsonObject.toString(4));
        out.close();
        System.out.println("JSON saved to: output.json");

    }

```

## Output

Input File [https://github.com/arjunQ21/ead/blob/main/json_and_xml/users.json]
Output JSON File [https://github.com/arjunQ21/ead/blob/main/json_and_xml/output.json]
Output xml File [https://github.com/arjunQ21/ead/blob/main/json_and_xml/output.xml]