import java.util.HashMap;
import java.util.Map;

public class Passports {
    /*
123456 Иванов
321456 Васильев
234561 Петрова
234432 Иванов
654321 Петрова
345678 Иванов
     */

   private Map<String, String> map = new HashMap<>();

   void add (String passNum, String lastName){
       map.put(passNum,lastName);
   }

    String getByPassNum(String passNum){
       return passNum + " : " + map.get(passNum);
    }

    String getBylastName(String lastName){
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry <String, String> entry: map.entrySet()) {
            if (entry.getValue().equals(lastName)){
                stringBuilder.append(entry.getKey()).append(" : ").append(entry.getValue()).append("\n");

            }
        }
        return stringBuilder.toString();
    }

    String getAll(){

       return map.toString();
    }
}
