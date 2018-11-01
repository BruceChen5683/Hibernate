package ml.battlecall;

import ml.battlecall.h3.Category;
import ml.battlecall.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;

/**
 * Created by chenjianliang on 2018/10/31.
 */
public class HibernateTest3 {
    public static void main(String[] args) {

        Session session = HibernateUtils.openSession();
        Transaction transaction = null;

        try{

            transaction = session.beginTransaction();

            Category category1 = new Category("level 01",null,new HashSet<Category>());

            Category category2 = new Category("level 11",null,new HashSet<Category>());
            Category category3 = new Category("level 12",null,new HashSet<Category>());

            Category category4 = new Category("level 21",null,new HashSet<Category>());
            Category category5 = new Category("level 22",null,new HashSet<Category>());
            Category category6 = new Category("level 23",null,new HashSet<Category>());
            Category category7 = new Category("level 24",null,new HashSet<Category>());


            category2.setParentCategory(category1);
            category3.setParentCategory(category1);
            category1.getChildCategories().add(category2);
            category1.getChildCategories().add(category3);

            category4.setParentCategory(category2);
            category5.setParentCategory(category2);
            category2.getChildCategories().add(category4);
            category2.getChildCategories().add(category5);

            category6.setParentCategory(category3);
            category7.setParentCategory(category3);
            category3.getChildCategories().add(category6);
            category3.getChildCategories().add(category7);
//
//
            Long l = (Long) session.save(category1);//保存
            transaction.commit();
            HibernateUtils.close(session);

            Session session1 = HibernateUtils.openSession();
            Transaction transaction1 = session1.beginTransaction();

//            Category category222 = session1.get(Category.class,l);
//
//            if (category222 == category1){
//                System.out.println("HibernateTest3.main true");
//            }else {
//                System.out.println("HibernateTest3.main "+category222.getName());
//                System.out.println("HibernateTest3.main "+category1.getName());
//                System.out.println("HibernateTest3.main false");
//            }
            category1.setName("new name");
            session1.update(category1);
            category1.setName("new name 2");

            transaction1.commit();

            HibernateUtils.close(session1);



//            Category category = session.get(Category.class,new Long(1));

//            session.delete(category);//删除
//            System.out.println("HibernateTest3.main "+category.getChildCategories().iterator().next().getName());  //查询

//            Category category = session.get(Category.class,l);
//            Category category8 = session.get(Category.class,l);
//
//            System.out.println("HibernateTest3.main "+(category == category8?  true:false));
//
//
//            transaction.commit();




        }catch (Exception e){
            e.printStackTrace();
//            if (null != transaction){
//                transaction.rollback();
//            }
        }finally {
//            HibernateUtils.close(session);

        }
    }
}
