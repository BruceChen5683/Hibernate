package ml.battlecall;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.LoadEvent;
import org.hibernate.event.spi.LoadEventListener;

public class TestLoadEventListener implements LoadEventListener {
    @Override
    public void onLoad(LoadEvent loadEvent, LoadType loadType) throws HibernateException {

    }
}
