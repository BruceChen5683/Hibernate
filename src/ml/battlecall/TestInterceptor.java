package ml.battlecall;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import java.io.Serializable;

public class TestInterceptor extends EmptyInterceptor {
    @Override
    public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        System.out.println("TestInterceptor.onLoad");

        for (String s:
             propertyNames) {
            System.out.println("TestInterceptor.onLoad s:"+s);
        }
        return super.onLoad(entity, id, state, propertyNames, types);
    }

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        for (String s:
                propertyNames) {
            System.out.println("TestInterceptor.onSave s:"+s);
        }
        return super.onSave(entity, id, state, propertyNames, types);
    }
}
