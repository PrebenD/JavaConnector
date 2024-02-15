package com.linknordic;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JavaFilter implements  streamserve.filter.Execute {

    public void invoke(InputStream input, OutputStream output) {
        try {
            String jsonStr = new String(input.readAllBytes(), StandardCharsets.UTF_8);

            ObjectMapper jsonMapper = new ObjectMapper();
            JsonNode node = jsonMapper.readValue(jsonStr, JsonNode.class);

            // Wrap the array in an object
            ObjectNode rootNode = jsonMapper.createObjectNode();
            rootNode.set("root", node);

            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writeValueAsString(rootNode);

            output.write(xml.getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
