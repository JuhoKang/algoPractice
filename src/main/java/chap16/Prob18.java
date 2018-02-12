package chap16;

import java.util.HashMap;
import java.util.Map;

public class Prob18 {

  public boolean patternMatch(String target, String pattern) {
    int total = target.length();
    char[] targetChars = target.toCharArray();
    char[] patternChars = pattern.toCharArray();
    Map<Character, Integer> patternInfo = getPatternInfo(pattern);
    int aCount = 0;
    if(patternInfo.containsKey('a')) {
      aCount = patternInfo.get('a');
    }
    int bCount = 0;
    if(patternInfo.containsKey('b')) {
      bCount = patternInfo.get('b');
    }
    int aVal = 1;
    int bVal = 1;
    boolean isOnlyOne = false;
    System.out.println(total);
    System.out.println("aCount:"+aCount+"/bCount:"+bCount);
    while (bVal > 0 || aVal > total || bVal > total) {
      boolean canCalc = false;
      if(bCount > 0  && aCount > 0) {
        bVal = (total - (aVal * aCount)) / bCount;
        if((total - (aVal * aCount)) % bCount == 0) {
          canCalc = true;
        }
      } else {
        if(aCount == 0) {
          bVal = total / bCount;
        } else {
          aVal = total / aCount;
        }
        isOnlyOne = true;
        canCalc = true;
      }
      System.out.println("aVal:"+aVal+"/bVal:"+bVal);
      int targetPointer = 0;
      String compA = "";
      String compB = "";
      int diffA = 0;
      int diffB = 0;
      if (canCalc) {
        for (int i = 0; i < patternChars.length; i++) {
          if(patternChars[i] == 'a') {
            String tempComp = target.substring(targetPointer, targetPointer+aVal);
            System.out.println("compA:"+compA +"/// tempComp:"+tempComp);
            if(!compA.equals(tempComp)) {
              diffA++;
            }
            compA = tempComp;
            targetPointer = targetPointer + aVal;
          } else {
            String tempComp = target.substring(targetPointer, targetPointer+bVal);
            System.out.println("compB:"+compB +"/// tempComp:"+tempComp);
            if(!compB.equals(tempComp)) {
              diffB++;
            }
            compB = tempComp;
            targetPointer = targetPointer + bVal;
          }
        }
        if(diffA < 2 && diffB < 2) {
          return true;
        }
      }
      aVal++;
      if(isOnlyOne == true) {
        return false;
      }
    }
    return false;
  }

  public Map<Character, Integer> getPatternInfo(String pattern) {
    char[] cArr = pattern.toCharArray();
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < cArr.length; i++) {
      if (map.containsKey(cArr[i])) {
        map.put(cArr[i], map.get(cArr[i]) + 1);
      } else {
        map.put(cArr[i], 1);
      }
    }
    return map;
  }
}
