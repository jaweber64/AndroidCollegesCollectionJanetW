package com.example;
// Janet Weber  DUE 10/5/2015
// Critical Thinking Exercise (week 7)  Collections
// Write the code to organize and extract some data from a collection of items
//   you have at home. Use at least one dictionary and one array

// I chose to theme this around the colleges my kids and nieces/nephews attended
//    or currently attend.  I did this same assignment for iOS Swift class

import java.util.*;

public class MyClass {
    public static void main (String[] args) {
        final String[] MAJORS = {"nursing", "music", "electrical engineering",
                "marketing", "graphic design", "chemistry", "economics",
                "social work", "physician assistant studies", "aviation",
                "business mgmt"};
        final String[] FAMILIES = {"Dawson", "Glaser", "Stutzman", "Weber"};

        Map studentSchool = new HashMap();
        studentSchool.put("Sarah (Stutzman) Leitz","Valparaiso University");
        studentSchool.put("Jennifer Dawson", "St. Elizabeth's School of Nursing");
        studentSchool.put("Gregory Stutzman", "Valparaiso University");
        studentSchool.put("Adam Stutzman", "St. Joseph's College");
        studentSchool.put("Christopher Dawson", "Indiana University South Bend");
        studentSchool.put("Jacob Stutzman", "University of Saint Francis");
        studentSchool.put("Christian Weber", "Roosevelt University");
        studentSchool.put("Joseph Weber", "Seton Hill University");
        studentSchool.put("Aaron Weber", "Quincy University");
        studentSchool.put("Hannah Weber", "Lewis University");
        studentSchool.put("Andrew Glaser", "Holy Cross College");
        studentSchool.put("Elizabeth Glaser", "St. Mary's College");
        studentSchool.put("Melissa Dawson", "Ball State University");

        String[] studentName = {"Sarah (Stutzman) Leitz", "Jennifer Dawson",
                "Gregory Stutzman", "Adam Stutzman", "Christopher Dawson", "Jacob Stutzman",
                "Christian Weber", "Joseph Weber", "Aaron Weber", "Hannah Weber",
                "Andrew Glaser", "Elizabeth Glaser", "Melissa Dawson"};
        String [] schoolLoc = {"Valparaiso, IN", "Lafayette, IN", "Valparaiso, IN",
                "Renssellaer, IN", "South Bend, IN", "Fort Wayne, IN", "Chicago, IL",
                "Greensburg, PA", "Quincy, IL", "Romeoville, IL", "Notre Dame, IN",
                "Notre Dame, IN", "Muncie, IN"};
        String[] major = {"music", "nursing", "electrical engineering", "marketing",
                "graphic design", "music technology", "economics", "physician assistant studies",
                "aviation", "nursing", "business mgmt", "chemistry (forensic science)",
                "social work"};
        int[] gradYear = {2009, 2009, 2010, 2013, 2015, 2017, 2013, 2017, 2017, 2018,
                2017, 2019, 2017};

        int currentMin, length, i, j, k, tmpInt, maxIndex, cmpVal, currentCmpVal;
        String currentStr, nextStr, tmpStr;  // used to swap and compare string array elements
        int[] tallyArr = {0,0,0,0,0,0,0,0,0,0,0}; // used to track majors - parrallel to MAJORS above
        // ************************************************
        //  Sort by state and display
        // ************************************************
        System.out.println("Data sorted by State location:");  // display intentions to oconsole
        System.out.println("");
        for (i=0; i<studentSchool.size(); i++) {               // perform a sort of school location
            currentMin = i;                                    // get first element and compare to the
            for (j=i+1; j<studentSchool.size(); j++) {         //    rest, keeping minimum found, then
                length = schoolLoc[currentMin].length();       //    swapping if necessary. Then move on
                currentStr = schoolLoc[currentMin].substring(length-2);// to next element.
                length = schoolLoc[j].length();
                nextStr = schoolLoc[j].substring(length-2);
                if (currentStr.compareTo(nextStr) > 0) {
                    currentMin = j;
                }
            }

            if (currentMin != i) {                      // swap ALL parallel arrays
                tmpStr = schoolLoc[i];
                schoolLoc[i] = schoolLoc[currentMin];   // school location array
                schoolLoc[currentMin] = tmpStr;

                tmpStr = studentName[i];
                studentName[i] = studentName[currentMin];// student name array
                studentName[currentMin] = tmpStr;

                tmpStr = major[i];
                major[i] = major[currentMin];           // major array
                major[currentMin] = tmpStr;

                tmpInt = gradYear[i];
                gradYear[i] = gradYear[currentMin];     // grad year array
                gradYear[currentMin] = tmpInt;
            }
        }
        // Display school location, student name, and school name
        //   Use two arrays (schoolLoc & studentName) and the map
        //   with the studentName[i] as the key
        for (i=0; i<studentSchool.size(); i++) {
            System.out.println(schoolLoc[i] + ":  " + studentName[i] +
                "   " + studentSchool.get(studentName[i]));
        }
        // *************************************************************************
        // Display most popular major
        // **************************************************************************
        for (i=0; i<studentSchool.size(); i++) {        // get first major and find it in the
            for (j=0; j<MAJORS.length; j++) {           //   constant MAJORS array.  Increment
                if (major[i].indexOf(MAJORS[j]) > 0) {  //   the corresponding index in a tally
                    tallyArr[j] += 1;                   //   array to keep track
                }
            }
        }
        // See which has the most tallies
        maxIndex = 0;                           // initialize index
        for (i=1; i<tallyArr.length; i++) {     // go thru tally array to find greatest
            if (tallyArr[i] > tallyArr[maxIndex]) { // value and thus the index to that
                maxIndex = i;                   //  major in the MAJORS array
            }
        }
        // Display output
        System.out.println("");
        System.out.println("The most popular major of the Weber kids/cousins: " +
            MAJORS[maxIndex]);

        // *************************************************************
        // Display sorted by family
        // **************************************************************

        for (i=0; i<studentName.length-1; i++) {        // iterate thru name array
            currentMin = i;                             // Initialize
            currentStr = "";
            currentCmpVal = 0;
            for (k=0; k<FAMILIES.length; k++) {         // Find family "name" belongs to
                if (studentName[currentMin].contains(FAMILIES[k])) {
                    currentStr = FAMILIES[k];
                }
            }
            for (j=i+1; j<studentName.length; j++) {    // get next name in name array
                nextStr = "";                           // initialize
                for (k=0; k<FAMILIES.length; k++) {     // Find family "next name" belongs to
                    if (studentName[j].contains(FAMILIES[k])) {
                        nextStr = FAMILIES[k];
                    }
                }

                cmpVal = currentStr.compareTo(nextStr); // compare both names
                if ((cmpVal > 0) &&                     // + value means nextStr comes first
                        (cmpVal > currentCmpVal)) {     // you want the greater value
                    currentMin = j;                     // keep index of current first
                    currentCmpVal = cmpVal;             // keep value of greatest comparison
                }
            }

            if (currentMin != i) {                      // Swap ALL parallel arrays
                tmpStr = schoolLoc[i];
                schoolLoc[i] = schoolLoc[currentMin];   // School location array
                schoolLoc[currentMin] = tmpStr;

                tmpStr = studentName[i];
                studentName[i] = studentName[currentMin];// student name array
                studentName[currentMin] = tmpStr;

                tmpStr = major[i];
                major[i] = major[currentMin];           // major array
                major[currentMin] = tmpStr;

                tmpInt = gradYear[i];
                gradYear[i] = gradYear[currentMin];     // grad year array
                gradYear[currentMin] = tmpInt;
            }
        }
        // Display student name, school, grad year - sorted by family (last name)
        System.out.println("");
        System.out.println("By Family: ");
        System.out.println("");
        for (i=0; i<studentName.length; i++) {
            System.out.println(studentName[i] + "   " +
                    studentSchool.get(studentName[i]) + "   " +
                    gradYear[i]);
        }
    }
}
