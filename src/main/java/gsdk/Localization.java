package gsdk;

import java.util.*;

public class Localization {


    private final String[] localizationFiles;
    public HashMap<String, HashMap<String, String>> allLocalizations = new HashMap<>();
    private String fileContent;

    private int position = 0;

    public Localization(String localizationFolder, String[] localizationFiles) {
        this.localizationFiles = localizationFiles;

        for (String localizationFile : localizationFiles) {
            parseLjsonFile(localizationFolder + localizationFile, localizationFile);
        }
    }

    public String getLocalizedText(String language, String keyName) {

        return allLocalizations.get(language).get(keyName);
    }

    public void parseLjsonFile(String path, String lang) {
        HashMap<String, String> currentLocalization = new HashMap<>();
        fileContent = Resource.readDataFromStream(Resource.getAsStream(path));

        position = 0;

        String value = "", key = "";

        while (position < fileContent.length()) {


            if (Character.isLetterOrDigit(current())) {
                key = "";
                while (current() != ':') {
                    key += current();
                    position++;
                }
            }

            if (current() == '"') {
                position++;
                value = "";
                while (position < fileContent.length() && current() != '"') {
                    value += current();
                    position++;
                }

            }

            position++;

            currentLocalization.put(key, value);
        }

        position = 0;
        String langName = "";

        while (lang.charAt(position) != '.'){
            langName += lang.charAt(position);
            position ++;
        }

        allLocalizations.put(langName, currentLocalization);

    }

    private char current() {
        return fileContent.charAt(position);
    }

}
