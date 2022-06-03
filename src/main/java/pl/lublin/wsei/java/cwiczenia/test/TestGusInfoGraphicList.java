package pl.lublin.wsei.java.cwiczenia.test;

import pl.lublin.wsei.java.cwiczenia.GusInfoGraphicList;
import pl.lublin.wsei.java.cwiczenia.Infografika;

public class TestGusInfoGraphicList {
    public static void main(String[] args){
        GusInfoGraphicList list = new GusInfoGraphicList("gusInfographic.xml");
        for (Infografika ig: list.Infografiki) ig.print();
    }
}
