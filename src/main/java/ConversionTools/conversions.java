package ConversionTools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class Conversions {

    public int conversionForAge(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar currentDate = Calendar.getInstance();
            Date usersDate = sdf.parse(date);

            Calendar calUser = Calendar.getInstance();
            calUser.setTime(usersDate);

            int age = currentDate.get(Calendar.YEAR) - calUser.get(Calendar.YEAR);
            if (currentDate.get(Calendar.DAY_OF_YEAR) < calUser.get(Calendar.DAY_OF_YEAR)) {
                age--;
            }
            return age;
        } 
        catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Formato inserido não é possível ser convertido! Tente um formato válido");
            return 000;
        }
    }
    
    public boolean conversionPregnant(String userChoice){
        boolean pregnant = false;
        userChoice = userChoice.toUpperCase();
        if("SIM".equals(userChoice)){
            pregnant = true;
        }
        return pregnant;
    }
    
    
    public String conversionBoolean(Boolean Pregnant){
        String conversion;
        if(Pregnant == true){
            conversion = "Sim";
        }
        else{
            conversion = "Não";
        }
        return conversion;
    }
    

}
