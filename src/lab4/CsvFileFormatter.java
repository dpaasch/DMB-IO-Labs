/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 */
public class CsvFileFormatter {
 
    public List<String> decode(List<String> rawData) {
        List<String> decodedData = new ArrayList<String>();
 
        for (String dataItem : rawData) {
            String[] dataPoints = dataItem.split(",");
            for(String point : dataPoints) {
                decodedData.add(point);
            }
        }
        return decodedData;
    }
 
    public static void main(String[] args) {
        List<String> rawData = new ArrayList<String>();
        rawData.add("21.45,31.75");
 
        CsvFileFormatter testApp = new CsvFileFormatter();
        List<String> dataPoints = testApp.decode(rawData);
        System.out.println(dataPoints);
    }
} 

