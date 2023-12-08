public class GB_les2_hw_sql {
    public static void main(String[] args) {

        String QUERY = "select * from students where ";
        String PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
        System.out.println(answer(QUERY, PARAMS));

    }
    public static StringBuilder answer(String QUERY, String PARAMS){


        String paramsNew = PARAMS.replace('{',' ').replace('}', ' ');// убираем скобки
        String[] params = paramsNew.split(","); //создаём массив со строковыми значениями
        /*
        вывод массива params
         "name":"Ivanov"
         "country":"Russia"
         "city":"Moscow"
         "age":"null"
         */

        StringBuilder stringBuilder = new StringBuilder(QUERY);
        for (int i = 0; i < params.length; i++){
            String[] elements = params[i].replace('"', ' ').split(":"); // добавляет каждый элемент в новый массив

            // Вывод: name Ivanov country  Russia city Moscow age null
            if(!"null".equals(elements[1].trim())){
                stringBuilder.append(elements[0].trim()).append("=").append("'").append(elements[1].trim()).append("'");
                if (i < params.length - 2) stringBuilder.append(" and ");
            }
        }
        return stringBuilder;
    }
}
