
import domain.*;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Date;

public class ParseJSON {

    public static <T> T readJSON(File file, Class<T> tClass) throws IOException {
        String items = "";
        items = new String(Files.readAllBytes(file.toPath()));
        return new Gson().fromJson(items, tClass);
    }

    public static <T> String rewriteJSON(T t, File file) {
        String s = new Gson().toJson(t);
        try {
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write(s);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return s;
    }

    public static <T> void writeJSON(T[] item) {
        Arrays.sort(item);
    }


    public static Client findObject(Client[] item, int id) {
        for (Client t: item){
            if (t.getId() == id) return t;
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("Lab2/package.json");
        Item i = ParseJSON.readJSON(file, Item.class);
        System.out.println(i.toString());

        Client client = new Client(1, "John" , new Date());
        Client[] os = new Client[] {new Client(2, "AS", new Date()),client};
        System.out.println(ParseJSON.rewriteJSON(client, new File("Lab2/output.json")));
        System.out.println(ParseJSON.rewriteJSON(os, new File("Lab2/output.json")));

        File file1 = new File("Lab2/output.json");
        Client[] os3 = ParseJSON.readJSON(file1, Client[].class);
        Arrays.asList(os3).forEach(System.out::println);

        ParseJSON.writeJSON(os3);
        Arrays.asList(os3).forEach(System.out::println);

        System.out.println(findObject(os3, 1) + " Пользователь с id 1 найлен");

    }
}
