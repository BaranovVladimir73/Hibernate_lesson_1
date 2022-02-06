package ru.gb.dao.product;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.gb.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

//@Component
@RequiredArgsConstructor
public class JdbcTemplateProductDao implements ProductDao{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Iterable<Product> findAll() {

        String sql = "select product.id, product.title, product.cost, product.manufacture_date, manufacturer.name AS manufacturer\n" +
                "from product\n" +
                "inner join manufacturer\n" +
                "on product.manufacturer_id = manufacturer.id;";


        return jdbcTemplate.query(sql, new ProductMapper());
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

    private static class ProductMapper implements RowMapper<Product> {

        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Product.builder()
                    .id(rs.getLong("id"))
                    .title(rs.getString("title"))
                    .cost(rs.getBigDecimal("cost"))
                    .date(rs.getDate("manufacture_date").toLocalDate())
                    .manufacturer(rs.getString("manufacturer"))
                    .build();
        }
    }
}
