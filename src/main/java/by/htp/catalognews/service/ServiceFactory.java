package by.htp.catalognews.service;

import by.htp.catalognews.service.impl.NewsServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final NewsService newsService = new NewsServiceImpl();

    private ServiceFactory() {}


    public  NewsService getNewsService(){return  newsService;}
    public static ServiceFactory getInstance() {
        return instance;
    }


}
