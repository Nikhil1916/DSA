public class RL0008 {
  public static void main(String args[]) {
    int totalPersons = 4;
    peopleAttendPartyInWhatWay(1, totalPersons, new boolean[totalPersons+1], "");
  }

  public static void peopleAttendPartyInWhatWay(int currPerson , int totalPerson ,boolean availPersons[] , String asf) {

    if(currPerson > totalPerson) {
      System.out.println(asf);
      return;
    }
    // System.out.println(currPerson);
    if(availPersons[currPerson] == false) {
      availPersons[currPerson] = true;
      peopleAttendPartyInWhatWay(currPerson+1, totalPerson, availPersons, asf+currPerson+"_");
      for(int i=1;i<availPersons.length;i++) {
        if(availPersons[i] == false) {
          availPersons[i] = true;
          peopleAttendPartyInWhatWay(currPerson+1, totalPerson, availPersons, asf+currPerson+i+"_");
          availPersons[i] = false;
        }
      }
      availPersons[currPerson] = false;
    } else {
      peopleAttendPartyInWhatWay(currPerson+1, totalPerson, availPersons, asf);
    }

  }
}
