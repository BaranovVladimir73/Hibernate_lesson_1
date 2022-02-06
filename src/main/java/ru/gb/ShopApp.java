package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.gb.config.HibernateConfig;
import ru.gb.dao.ManufacturerDao;
import ru.gb.dao.OldJdbcManufacturerDao;
import ru.gb.dao.product.ProductDao;
import ru.gb.entity.Manufacturer;

public class ShopApp {

    public static void main(String[] args) {
//        OldJdbcManufacturerDao oldJdbcManufacturerDao = new OldJdbcManufacturerDao();
//
//
//        for (Manufacturer manufacturer : oldJdbcManufacturerDao.findAll()) {
//            System.out.println(manufacturer);
//        }

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
//        ManufacturerDao manufacturerDao = context.getBean(ManufacturerDao.class);
//        System.out.println(manufacturerDao.findById(3L));
//        System.out.println(manufacturerDao.findNameById(5L));
//        for (Manufacturer manufacturer : manufacturerDao.findAll()) {
//            System.out.println(manufacturer);
//        }

//        OldJDBCProductDao oldJDBCProductDao = new OldJDBCProductDao();

//        for (Product product: oldJDBCProductDao.findAll()) {
//            System.out.println(product);
//        }

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        ProductDao productDao = context.getBean(ProductDao.class);
        System.out.println(productDao.findNameById(4L));
        System.out.println(productDao.findById(4L));
//        for (Product product : productDao.findAll()) {
//            System.out.println(product);
//       }
    }
}
