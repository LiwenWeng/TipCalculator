import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Receipt {
    private double totalCostBeforeTip;
    private int tipPercentage;
    private int numberOfPeople;
    private double totalTip;
    private double totalCostWithTip;
    private double costPerPersonBeforeTip;
    private double tipPerPerson;
    private double totalCostPerPerson;
    String name;
    private ArrayList<String[]> items;

    public Receipt(String name, ArrayList<String[]> items, double totalCostBeforeTip, int tipPercentage, int numberOfPeople) {
        this.name = name;
        this.items = items;

        this.totalCostBeforeTip = totalCostBeforeTip;
        this.tipPercentage = tipPercentage;
        this.numberOfPeople = numberOfPeople;
        totalTip = this.totalCostBeforeTip * this.tipPercentage * 0.01;
        totalCostWithTip = this.totalCostBeforeTip + totalTip;
        costPerPersonBeforeTip = this.totalCostBeforeTip / this.numberOfPeople;
        tipPerPerson = totalTip / this.numberOfPeople;
        totalCostPerPerson = costPerPersonBeforeTip + tipPerPerson;
    }

    private String getItems() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n   Qty    |    Item    |     Price\n");

        for (String[] item : items) {
            stringBuilder.append("   " + item[2] + "   " + item[0] + "   " + item[1] + "\n");
        }

        return stringBuilder.toString();
    }

    private String getTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EE      MM/dd/yy      HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public String getReceipt() {
        return String.format("""     
          MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM 
                      
                      McDonald's            
              Address: 139 Flatbush Ave     
                 Telp. (718) 230-0176       
                                            
           * * * * * * * * * * * * * * * *  
           
                     CASH RECEIPT           
           %1$s                           
           %11$s 
           
           * * * * * * * * * * * * * * * *  
           %2$s
           * * * * * * * * * * * * * * * *  
           
           Number of people: %3$d
           Total bill before tip: $%4$.2f
           Total percentage: %5$d%%
           Total tip: $%6$.2f
           Total bill with tip: $%7$.2f
           Per person cost before tip: $%8$.2f
           Tip per person: $%9$.2f
           Total cost per person: $%10$.2f
           
           * * * * * * * * * * * * * * * *  
                                            
                     THANK YOU!             
                           
          WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW               
        """,
                name,
                getItems(),
                numberOfPeople,
                totalCostBeforeTip,
                tipPercentage,
                totalTip,
                totalCostWithTip,
                costPerPersonBeforeTip,
                tipPerPerson,
                totalCostPerPerson,
                getTime());
    }
}
