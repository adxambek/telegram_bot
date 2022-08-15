package uz.pdp.container;

import uz.pdp.Noutuz;
import uz.pdp.enums.AdminStatus;
import uz.pdp.enums.CustomerStatus;
import uz.pdp.model.Customer;
import uz.pdp.model.Order;
import uz.pdp.model.Product;

import java.util.HashMap;
import java.util.Map;

public abstract class ComponentContainer {

    public static final String BOT_TOKEN = "";
    public static final String BOT_NAME = "";

    public static final String ADMIN_ID = "";

    public static Noutuz MY_TELEGRAM_BOT;

    public static String PATH = "src/main/resources/";




    public static Map<String, Product> productMap = new HashMap<>();
    public static Map<String, AdminStatus> productStepMap = new HashMap<>();
    public static Map<String, Product> crudStepMap = new HashMap<>();
    public static Map<String, Customer> customerMap = new HashMap<>();

    public static Map<String, CustomerStatus> customerStepMap = new HashMap<>();
    public static Map<String, Order> orderMap = new HashMap<>();

}
