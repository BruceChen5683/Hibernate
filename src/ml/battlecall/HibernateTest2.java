package ml.battlecall;

import ml.battlecall.reflect.Customer;
import ml.battlecall.reflect.Order;
import ml.battlecall.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenjianliang on 2018/10/29.
 */
public class HibernateTest2 {

    public static void main(String[] args) {
        Session session = HibernateUtils.openSession();
        Transaction transaction = null;

        /*
        *  查询
        * */
        Order order = null;
        try{
            transaction = session.beginTransaction();


            order = session.get(Order.class,new Long(1));
            System.out.println("HibernateTest2.main "+order.getOrderName());


        }catch (Exception e){
            if (null != transaction){
                transaction.rollback();
            }
        }finally {
            HibernateUtils.close(session);

            order.getCustomer().getName();
        }

//        Customer customer = null;
//
//        try {
//
//            transaction = session.beginTransaction();
//
//            customer = session.get(Customer.class,new Long(4));
//
//            System.out.println("HibernateTest2.main  "+customer.getName());
//
////            customer.getOrders();
////            System.out.println("HibernateTest2.main "+customer.getOrders());
//
//
//            transaction.commit();
//
//
//
//
//        }catch (Exception e){
//            if (null != transaction){
//                transaction.rollback();
//            }
//        }finally {
//            HibernateUtils.close(session);
//
//
//
//            for (Order order:customer.getOrders()){
//                System.out.println("HibernateTest2.main "+order.getOrderName());
//            }
//        }
       /*  增

        try{

            transaction = session.beginTransaction();

            Customer customer = new Customer();
            customer.setName("haha");
            customer.setOrders(new HashSet<>());

            Order  order1 = new Order();
            order1.setOrderName("order4");
            Order  order2 = new Order();
            order2.setOrderName("order5");
            Order  order3 = new Order();
            order3.setOrderName("order6");

            order1.setCustomer(customer);
            order2.setCustomer(customer);
            order3.setCustomer(customer);

            customer.getOrders().add(order1);
            customer.getOrders().add(order2);
            customer.getOrders().add(order3);


//            只保存customer
            session.save(customer);
            transaction.commit();


        }catch (Exception e){
            System.out.println("HibernateTest2.main e "+e.toString());
            if (null != transaction){
                transaction.rollback();
            }
        }finally {
            HibernateUtils.close(session);
        }

        */

    }
}
