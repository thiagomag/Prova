import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;

public class Calendario {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date d = Date.from(Instant.parse("2018-06-25T15:42:07Z"));

        System.out.println(sdf.format(d));

        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.HOUR_OF_DAY, 4);
        d = cal.getTime();

        int minutes = cal.get(Calendar.MINUTE);
        int month = 1 + cal.get(Calendar.MONTH); //o month começa no 0

        System.out.println(sdf.format(d));
        System.out.println(minutes);
        System.out.println(month);

    }
}
