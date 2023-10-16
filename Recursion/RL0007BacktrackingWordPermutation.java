
import java.util.HashMap;
import java.util.Scanner;


//BacktrackingWordPermutation

public class RL0007BacktrackingWordPermutation  {
  // equal char equal position
    public static void wordPermutation1(int currPos , int totalPos , HashMap<Character,Integer> freqMap , String asf){
        // logic here

        if(currPos > totalPos) {
          // if(asf.length() == totalPos) { //not needed as each char will come as same pos & char there
            System.out.println(asf);
          // }
          return;
        }

        for(char key:freqMap.keySet()) {
          if(freqMap.get(key) > 0) {
            freqMap.put(key,freqMap.get(key)-1);
            wordPermutation1(currPos+1,totalPos,freqMap,asf+key);
            freqMap.put(key, freqMap.get(key)+1);
          }
        }
    }

    // object chooses
    public static void wordPermutation2(String word,int idx,HashMap<Character,Integer> lastPosUsed,Character[] position){
      // logic here

      if(idx == position.length) {
        for(char c:position) {
          System.out.print(c);
        }
        System.out.println();
        return;
      }

      char ch = word.charAt(idx);
      int lastIdxUsed = lastPosUsed.get(ch);
      for(int i=lastIdxUsed+1;i<position.length;i++) {
        if(position[i]==null) {
          position[i] = ch;
          lastPosUsed.put(ch, i);
          wordPermutation2(word, idx+1, lastPosUsed, position);
          position[i] = null;
          lastPosUsed.put(ch, lastIdxUsed);
        }
      }

  }

    public static void printPermutations(String word){
        // HashMap<Character,Integer> freqMap = new HashMap<>();

        // for(int i = 0 ; i < word.length() ; i++){
        //     char ch = word.charAt(i);
        //     freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        // }
        // wordPermutation1(1,word.length(),freqMap,"");


        Character position[] = new Character[word.length()];
        HashMap <Character,Integer> lastPosUsed = new HashMap<>();
        for(int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i);
            lastPosUsed.put(ch,-1);
            System.out.print(position[i]+" -> ");
        }
        System.out.println(lastPosUsed);
        wordPermutation2(word,0,lastPosUsed,position);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        printPermutations(scn.next());
    }
}