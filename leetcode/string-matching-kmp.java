/*
Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[]. You may assume that n > m.
*/
class Main {
  private static int[] computeLongestPrefixSuffix(String pat) {
    int[] lps = new int[pat.length()]; 
    int j = 0;
    int i = 1; 
    lps[0] = 0;
    while (i < pat.length()) { 
      if (pat.charAt(i) == pat.charAt(j)) { 
        lps[i] = j + 1; 
        j++;
        i++; 
      } else {
        if (j == 0) { 
          lps[i] = 0;
          i++;
        } else {
          // j jumps to the previous value lps[j-1]
          j = lps[j - 1];  
        }
      }
    }
    return lps;
  }

  private static void stringMatch(String text, String pattern) {
    int[] lps = computeLongestPrefixSuffix(pattern);
    int i = 0;
    int j = 0;
    while (i < text.length()) {
      if (text.charAt(i) == pattern.charAt(j)) {
        j++;
        if (j == pattern.length()) {
          System.out.format("(%d , %d)\n", i - j + 1, i);
          j = lps[j - 1];
        }
        i++;
        continue;
      }
      if (j == 0) {
        i++;
      } else {
        j = lps[j - 1];
      }
    }
  }

  public static void main(String[] args) {
    stringMatch("AABAACAADAABAABA", "AABA");
  }
}
