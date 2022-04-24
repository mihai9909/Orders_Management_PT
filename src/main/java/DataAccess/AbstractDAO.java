package DataAccess;

import Connection.ConnectionFactory;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        System.out.println(type.getSimpleName());
    }

    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName().toLowerCase(Locale.ROOT)).append("s");
        sb.append(" WHERE ").append(field).append(" =?");
        return sb.toString();
    }

    private String createSelectQuery(){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName().toLowerCase(Locale.ROOT)).append("s");
        return sb.toString();
    }

    public List<T> findAll() {
        // TODO:
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            return createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }

        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException | IllegalAccessException | SecurityException | IntrospectionException | SQLException | InvocationTargetException | IllegalArgumentException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(resultSet);
        }
        return list;
    }

    public T insert(T t) {
        // TODO:
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            StringBuilder query = new StringBuilder("INSERT INTO " + type.getSimpleName().toLowerCase(Locale.ROOT) + "s VALUE(");
            for (Field field : type.getDeclaredFields()) {
                String fieldName = field.getName();
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                Method getter = propertyDescriptor.getReadMethod();
                Object res = getter.invoke(t);
                if("String".equals(field.getType().getSimpleName())) {
                    query.append('\'' + res.toString() + "',");
                }else{
                    query.append(res.toString()+',');
                }
            }
            query.setCharAt(query.length() - 1, ')');
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query.toString());
            statement.execute();
            return t;
        } catch (SQLException | IntrospectionException | InvocationTargetException | IllegalAccessException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return t;
    }

    public T update(T t) {
        // TODO:
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            String id=null;
            StringBuilder query = new StringBuilder("UPDATE " + type.getSimpleName().toLowerCase(Locale.ROOT) + "s SET ");
            for (Field field : type.getDeclaredFields()) {  //set object t
                String fieldName = field.getName();
                query.append(fieldName).append("=");
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                Method getter = propertyDescriptor.getReadMethod();
                Object res = getter.invoke(t);
                if("id".equals(fieldName)){
                    id=res.toString();
                }
                if("String".equals(field.getType().getSimpleName())) {
                    query.append('\'' + res.toString() + "',");
                }else{
                    query.append(res.toString()+',');
                }
            }
            query.setCharAt(query.length() - 1, ' ');
            query.append("WHERE ");
            query.append("id=").append(id);

            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query.toString());
            statement.executeUpdate();
            return t;
        } catch (SQLException | IntrospectionException | InvocationTargetException | IllegalAccessException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    public void deleteById(int id){
        String query = "DELETE FROM " + type.getSimpleName().toLowerCase(Locale.ROOT) + "s WHERE id=" + id;
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.execute(query);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    public String[] getHeader(){
        List<String> al = new ArrayList<>();
        int i = 0;
        for (Field field : type.getDeclaredFields()) {
            String fieldName = field.getName();
            al.add(fieldName);
        }
        String []res = new String[al.size()];
        return al.toArray(res);
    }

    public String[][] getData() {
        List<T> objects = findAll();
        String [][]data = new String[objects.size()][getHeader().length];
        int i = 0;
        try {
            for (Object obj : objects) {
                int j = 0;
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method getter = propertyDescriptor.getReadMethod();
                    Object res = getter.invoke(obj);
                    data[i][j] = res.toString();
                    j++;
                }
                i++;
            }
        } catch (IntrospectionException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return data;
    }
}
