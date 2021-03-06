package by.htp.catalognews.main;

import by.htp.catalognews.dao.xml.JaxbParser;
import by.htp.catalognews.entity.CatalogNews;
import by.htp.catalognews.entity.criteria.Criteria;
import by.htp.catalognews.entity.News;
import by.htp.catalognews.service.Constant;
import by.htp.catalognews.service.NewsService;
import by.htp.catalognews.service.ServiceFactory;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException, JAXBException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsService newsService = serviceFactory.getNewsService();

        HashMap<String, Object> parametersForCreate = InputData.readFromConsole();
        Criteria criteriaForCreate = new Criteria();
        criteriaForCreate.setCriteria(parametersForCreate);

        News news = newsService.add(criteriaForCreate);
        CatalogNews catalogFromXML = JaxbParser.readXML(Constant.getFullPathFileXML());
        catalogFromXML.add(news);

        //OutputData.printCatalogNews(catalogFromXML);
        JaxbParser.saveFile(catalogFromXML);

        OutputData.printCatalogNews(catalogFromXML);

        HashMap<String, Object> parametersForFind = new HashMap<String, Object>();
        parametersForFind.put("providerName","tut.by");
        parametersForFind.put("country","Беларусь");
        Criteria criteriaFind = new Criteria();
        criteriaFind.setCriteria(parametersForFind);
        List<News> newsList = newsService.find(criteriaFind);

        OutputData.printCatalogNews("Найденные новости "+criteriaFind, newsList);

    }

}
