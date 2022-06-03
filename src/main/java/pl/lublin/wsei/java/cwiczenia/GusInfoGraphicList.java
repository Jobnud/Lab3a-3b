package pl.lublin.wsei.java.cwiczenia;

import pl.lublin.wsei.java.cwiczenia.Infografika;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class GusInfoGraphicList {
    public ArrayList<Infografika> Infografiki;

    public GusInfoGraphicList(String gusFileName){
        Infografiki = new ArrayList<>();
        String contents;
        try {
            contents = new String(Files.readAllBytes(Paths.get(gusFileName)));
        }
        catch (IOException e){
            System.out.println("Bląd wczytywania pliku gusInfoGraphic.xml => " + e.getLocalizedMessage());
            e.printStackTrace();
            contents = "";
        }
        String[] items = contents.split("<item>");
        for (int i = 1; i < items.length; i++){
           Infografiki.add(new Infografika(items[i]));
        }
    }
}
