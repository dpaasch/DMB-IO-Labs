package lab4;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Dawn Bykowski
 */
public class CsvFileFormatter implements 
        FileFormatStrategy <List<LinkedHashMap<String, String>>,List<String>>{
    
    /* CsvFileFormatter variables */
    private boolean hasHeader;
    private final String LF = "\n";     // Represents a line feed in the data
    private final String COMMA = ",";   // The delimiter/separator in the data
    
    /**
     * encode
     *
     * @param dataFromFile : the data from the file that was read
     * @return
     */
    @Override
    public String encodeData(List<LinkedHashMap<String, String>> dataFromFile) {
        StringBuilder formattedData = new StringBuilder();

        boolean dataHeader = false; // signifies there is not a header row
        Set<String> dataFields = null;
        if (dataHeader) {
            // takes raw data first row and if there is not a header and sets a
            // key value
            dataFields = dataFromFile.get(0).keySet();  
        }        
        // record defines a row (line) of data
        for (int record = 0; record < dataFromFile.size(); record++) {
            if (dataFields != null) {
                for (String dataField : dataFields) {
                    formattedData.append(dataField);
                    formattedData.append(COMMA);
                    formattedData.append(LF);
                }
            }
        }
        return formattedData.toString();
    }

    @Override
    public List<LinkedHashMap<String, String>> 
            decodeData(List<String> dataFromFile) {
        List<LinkedHashMap<String, String>> decodedData =
                new ArrayList<LinkedHashMap<String, String>>();

        int lineCount = 0;
        String[] header = null;
        for (String line : dataFromFile) {
            lineCount++;
            String[] parts = line.split(COMMA);
            if (hasHeader && (lineCount == 1)) {
                header = parts;
            }
            LinkedHashMap<String, String> record =
                        new LinkedHashMap<String, String>();
            for (int i = 0; i < parts.length; i++) {                
                if (hasHeader && (lineCount == 1)) {
                    break;
                } else if (hasHeader) {
                    record.put(header[i], parts[i]);
                } else {
                    record.put("" + i, parts[i]);
                }                
            }
            if (lineCount != 1) {
            decodedData.add(record);
            }
        }
        return decodedData;
    }
}
