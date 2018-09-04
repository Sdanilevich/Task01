package by.htp.catalognews.dao;

import by.htp.catalognews.dao.impl.NewsDaoImpl;
import by.htp.catalognews.entity.CatalogNews;

import java.util.Date;

public final class DAOFactory {
    private static final DAOFactory instance= new DAOFactory();
    private final NewsDao newsDao = new NewsDaoImpl();
    private final CatalogNews catalogNews = new CatalogNews();

    private DAOFactory(){};

    public NewsDao getNewsDao(){
        return newsDao;
    }

    public static DAOFactory getInstance(){
        return instance;
    }

    public CatalogNews getCatalogNews() {
        return catalogNews;
    }
}
