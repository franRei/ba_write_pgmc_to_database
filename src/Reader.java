public class Reader {

    public static void main(String[] args) {
        //Database_Writer writer = new Database_Writer();
        String file = "enwiktionary_01_01.xml";
        Read_XML reader = new Read_XML();
        reader.parseFile(file);
    }
}
