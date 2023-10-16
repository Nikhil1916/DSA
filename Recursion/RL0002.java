import java.util.ArrayList;
// revision
public class RL0002 {
  public static void main(String args[]) {
    printMazePath(0,0,2,2,"");
    System.out.println(getMazePath(0, 0, 2, 2));
  }


  // psf = path so far
  static void printMazePath(int sr, int sc, int nr, int nc, String psf) {
    if(sr>nr || sc>nc) {
      return;
    }
    if(sr == nc && sc == nc) {
      System.out.println(psf);
      return;
    }
    printMazePath(sr, sc+1, nr, nc, psf+'h');
    printMazePath(sr+1, sc, nr, nc, psf+'v'); 
  }

  public static ArrayList<String> getMazePath(int sr,int sc,int nr,int nc) {
    ArrayList<String> ans = new ArrayList<>();
    if(sr>nr || sc>nc) {
      return ans;
    }

    if(sr == nr && sc == nc) {
      ans.add(" ");
      return ans;
    }

    ArrayList<String> hCall = getMazePath(sr, sc+1, nr, nc);
    for(String str: hCall) {
      ans.add('h'+str);
    }

    ArrayList<String> vCall = getMazePath(sr+1, sc, nr, nc);
    for(String str: vCall) {
      ans.add('v'+str);
    }
    return ans;
  }
}
