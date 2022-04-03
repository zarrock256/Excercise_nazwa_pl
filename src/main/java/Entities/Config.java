package Entities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Config extends JSONObject
{
    JSONObject jsonObject;

    public Config(String pathToTheFile) {

        JSONParser jsonParser = new JSONParser();

        try {
            this.jsonObject = (JSONObject) jsonParser.parse(new FileReader(pathToTheFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getAttribute(String attribute) {
        return (String)this.jsonObject.get(attribute);
    }



}