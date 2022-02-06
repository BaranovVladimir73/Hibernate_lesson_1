package ru.gb.dao.product;

import lombok.RequiredArgsConstructor;
import ru.gb.entity.Product;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.jdbc.support.JdbcUtils.closeConnection;

//@Component
@RequiredArgsConstructor
public class SpringJDBCProductDao implements ProductDao{

    private final DataSource dataSource;

    @Override
    public Iterable<Product> findAll() {
        Connection connection = null;
        Set<Product> result = new HashSet<>();

        try {
            connection = dataSource.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement("select product.id, product.title, product.cost, product.manufacture_date, manufacturer.name AS manufacturer\n" +
                            "from product\n" +
                            "inner join manufacturer\n" +
                            "on product.manufacturer_id = manufacturer.id;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                final Product product = Product.builder()
                        .id(resultSet.getLong("id"))
                        .title(resultSet.getString("title"))
                        .cost(resultSet.getBigDecimal("cost"))
                        .date(resultSet.getDate("manufacture_date").toLocalDate())
                        .manufacturer(resultSet.getString("manufacturer"))
                        .build();
                result.add(product);
            }
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }

        return result;

    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public String findNameById(Long id) {
        return null;
    }

    @Override
    public void insert(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
