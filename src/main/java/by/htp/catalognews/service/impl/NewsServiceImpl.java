package by.htp.catalognews.service.impl;

import by.htp.catalognews.dao.DAOFactory;
import by.htp.catalognews.dao.NewsDao;
import by.htp.catalognews.entity.criteria.Criteria;
import by.htp.catalognews.entity.News;
import by.htp.catalognews.service.NewsService;
import by.htp.catalognews.service.validation.Validator;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public class NewsServiceImpl implements NewsService {
    public List<News> find(Criteria criteria) throws IOException, JAXBException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        NewsDao newsDao = daoFactory.getNewsDao();

        List<News> newsList= newsDao.find(criteria);

        return newsList;
    }

    public News add(Criteria criteria) {
        if (Validator.isNotEmpty(criteria)){
            DAOFactory daoFactory = DAOFactory.getInstance();
            NewsDao newsDao = daoFactory.getNewsDao();
            News news = (News) newsDao.create(criteria);

            return news;
        }
        return null;
    }
}
