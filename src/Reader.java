public class Reader {

    public static void main(String[] args) {
        //change language family
        String language_family = "Reconstruction:Proto-Germanic";
        //XML file of wiki
        String file = "enwiktionary_01_01.xml";
        Read_XML reader = new Read_XML();
        reader.parseFile(file, language_family);
    }
}
