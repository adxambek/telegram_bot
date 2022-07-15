package uz.pdp.model;

// PROJECT NAME shop_bot
// TIME 14:15
// MONTH 04
// DAY 12


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class  Order {
    //  UserId  |  FirstName  |  LastName  |  PhoneNumber  |  GeneralOrder  |  TotalPrice  \\
    private Integer id;
    private String  user_id;
    private String first_name;
    private String last_name;
    private String phone_number;
    private String user_order;
    private Double totalprice;

    private String localDateTime;

    public Order(String user_id, String first_name, String last_name,
                 String phone_number, String user_order,
                 Double totalprice,String localDateTime) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.user_order = user_order;
        this.totalprice = totalprice;
        this.localDateTime = localDateTime;
    }
}

