/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.elmakers.mine.bukkit.plugins.CTF;

import java.util.Enumeration;
import java.util.Vector;


public class CTFUtil {
    public static String [] wrapText (String text, int len)
    {
      // return empty array for null text
      if (text == null)
      return new String [] {};

      // return text if len is zero or less
      if (len <= 0)
      return new String [] {text};

      // return text if less than length
      if (text.length() <= len)
      return new String [] {text};

      char [] chars = text.toCharArray();
      Vector lines = new Vector();
      StringBuffer line = new StringBuffer();
      StringBuffer word = new StringBuffer();

      for (int i = 0; i < chars.length; i++) {
        word.append(chars[i]);

        if (chars[i] == ' ') {
          if ((line.length() + word.length()) > len) {
            lines.add(line.toString());
            line.delete(0, line.length());
          }

          line.append(word);
          word.delete(0, word.length());
        }
      }

      // handle any extra chars in current word
      if (word.length() > 0) {
        if ((line.length() + word.length()) > len) {
          lines.add(line.toString());
          line.delete(0, line.length());
        }
        line.append(word);
      }

      // handle extra line
      if (line.length() > 0) {
        lines.add(line.toString());
      }

      String [] ret = new String[lines.size()];
      int c = 0; // counter
      for (Enumeration e = lines.elements(); e.hasMoreElements(); c++) {
        ret[c] = (String) e.nextElement();
      }

      return ret;
    }
}
