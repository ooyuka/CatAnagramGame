/*
 * Copyright (c) 2010, Oracle.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  * Neither the name of Oracle nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT 
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, 
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED 
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. 
 */

/* Anagram Game Application */

package com.toy.anagrams.lib;

import java.util.Random;

/**
 * Implementation of the logic for the Anagram Game application.
 */
final class StaticWordLibrary extends WordLibrary {

    private static final String[] WORD_LIST = {
        "apple",
        "banana",
        "exciting",
        "dog",
        "happy",
        "abstraction",
        "ambiguous",
        "arithmetic",
        "backslash",
        "book",
        "circumstance",
        "combination",
        "consequently",
        "consortium",
        "decrementing",
        "dependency",
        "disambiguate",
        "dynamic",
        "encapsulation",
        "equivalent",
        "expression",
        "facilitate",
        "fragment",
        "hexadecimal",
        "implementation",
        "indistinguishable",
        "inheritance",
        "cat",
        "java",
        "localization",
        "microprocessor",
        "navigation",
        "optimization",
        "parameter",
        "patrick",
        "pickle",
        "polymorphic",
        "rigorously",
        "simultaneously",
        "specification",
        "structure",
        "lexical",
        "likewise",
        "management",
        "manipulate",
        "mathematics",
        "hotjava",
        "vertex",
        "unsigned",
        "traditional"};

    private static final String[] SCRAMBLED_WORD_LIST = {
        "plpea",
        "ananba",
        "ctiigexnc",
        "odg",
        "yahpp",
        "batsartcoin",
        "maibuguos",
        "ratimhteci",
        "abkclssha",
        "kobo",
        "iccrmutsnaec",
        "ocbmnitaoni",
        "ocsnqeeutnyl",
        "ocsnroitmu",
        "edrcmeneitgn",
        "edepdnneyc",
        "idasbmgiauet",
        "ydanicm",
        "neacsplutaoni",
        "qeiuaveltn",
        "xerpseisno",
        "aficilatet",
        "rfgaemtn",
        "ehaxedicalm",
        "milpmeneatitno",
        "niidtsniugsiahleb",
        "niehiratcen",
        "atc",
        "ajav",
        "olacilazitno",
        "imrcpoorecssro",
        "anivagitno",
        "poitimazitno",
        "aparemert",
        "aprtcki",
        "ipkcel",
        "opylomprich",
        "irogorsuyl",
        "isumtlnaoesuyl",
        "psceficitaoni",
        "tsurtcreu",
        "elixalc",
        "ilekiwse",
        "amanegemtn",
        "aminupalet",
        "amhtmetacsi",
        "ohjtvaa",
        "evtrxe",
        "nuisngde",
        "rtdatioialn"
    };
    
    final static WordLibrary DEFAULT = new StaticWordLibrary();

    /**
     * Singleton class.
     */
 
    

    private StaticWordLibrary() {
    }

    /**
     * Gets the word at a given index.
     * @param idx index of required word
     * @return word at that index in its natural form
     */
    public String getWord(int idx) {
        return WORD_LIST[idx];
    }

    /**
     * Gets the word at a given index in its scrambled form.
     * @param idx index of required word
     * @return word at that index in its scrambled form
     */
    public String getScrambledWord(int idx) {
       String word = WORD_LIST[idx];
       char[] shuffle = new char[word.length()];
       Random rnd = new Random();
       int ran2 = rnd.nextInt(word.length() -1);
       int ran = 0;
       
       for(int i=0; i<word.length(); i++){
           shuffle[i]=word.charAt(i);
       }
      
        /*
         for(int i = 0; i< getCount(); i++){
         Random rand = new Random();
         ran2 = 0;
         ran = rand.nextInt(word.length() -1);
         */

        boolean flag = true;

        while (flag) {
            ran = rnd.nextInt(word.length() - 1);
            if (ran == ran2 || String.valueOf(shuffle[ran]).equals(String.valueOf(shuffle[ran2]))) {
                flag = true;
            } else {
                flag = false;
            }
        }

       char x = shuffle[ran];
       shuffle[ran] = shuffle[ran2];
       shuffle[ran2] = x;
       String answer = "";
      
        for (int i = 0; i < word.length(); i++) {
            answer = answer + String.valueOf(shuffle[i]);
        }
        return answer;
    }

    /**
     * Gets the number of words in the library.
     * @return the total number of plain/scrambled word pairs in the library
     */
    public int getSize() {
        return WORD_LIST.length;
    }

    /**
     * Checks whether a user's guess for a word at the given index is correct.
     * @param idx index of the word guessed
     * @param userGuess the user's guess for the actual word
     * @return true if the guess was correct; false otherwise
     */
    public boolean isCorrect(int idx, String userGuess) {
        return userGuess.equals(getWord(idx));
    }

}
