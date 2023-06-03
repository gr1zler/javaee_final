package DB;

import jakarta.servlet.http.HttpSession;
import servlet.Sign_in;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dbconnection {
    private static Connection connection;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:8889/bitlabee_final","root","root");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<users> getusers(){
        ArrayList<users>users=new ArrayList<>();
        try{
            PreparedStatement statement=connection.prepareStatement(
                    "Select * from users");
            ResultSet resultSet= statement.executeQuery();
            while (resultSet.next()){
                users user=new users();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFull_name(resultSet.getString("full_name"));
                user.setRole_id(resultSet.getInt("role_id"));
                users.add(user);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }
    public static ArrayList<news_categories> getnews_categories(){
        ArrayList<news_categories>newsCategories=new ArrayList<>();
        try{
            PreparedStatement statement=connection.prepareStatement(
                    "Select * from news_categories");
            ResultSet resultSet= statement.executeQuery();
            while (resultSet.next()){
               news_categories newsCategory=new news_categories();
               newsCategory.setId(resultSet.getInt("id"));
               newsCategory.setName(resultSet.getString("name"));
               newsCategories.add(newsCategory);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return newsCategories;
    }
    public static ArrayList<news> getnew(){
        ArrayList<news>newster=new ArrayList<>();
        try{
            PreparedStatement statement=connection.prepareStatement(
                    "Select ne.id as idler,ne.post_date,ne.category_id,ne.title,ne.content,newcat.* " +
                            "from news as ne " +
                            "inner join news_categories as newcat on ne.category_id=newcat.id");
            ResultSet resultSet= statement.executeQuery();
            while (resultSet.next()){
                news newsbir=new news();
                newsbir.setId(resultSet.getInt("idler"));
                newsbir.setPost_date(resultSet.getTimestamp("post_date"));
                newsbir.setTitle(resultSet.getString("title"));
                newsbir.setContent(resultSet.getString("content"));
                news_categories categories=new news_categories();
                categories.setId(resultSet.getInt("category_id"));
                categories.setName(resultSet.getString("name"));
                newsbir.setCategory(categories);
                newster.add(newsbir);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return newster;
    }
    public static ArrayList<comment> getcomment(){
        ArrayList<comment>comments=new ArrayList<>();
        try{
            PreparedStatement statement=connection.prepareStatement(
                    "SELECT com.*,us.*,ne.*,newcat.*,ne.post_date as post_date_news " +
                            "FROM comments as com " +
                            "inner join users as us on com.user_id=us.id " +
                            "inner join news as ne on com.news_id=ne.id " +
                            "inner join news_categories as newcat on ne.category_id=newcat.id;");
            ResultSet resultSet= statement.executeQuery();
            while (resultSet.next()){
                comment comment=new comment();
                comment.setId(resultSet.getInt("id"));
                comment.setComment(resultSet.getString("comment"));
                comment.setPost_date(resultSet.getTimestamp("post_date"));
                users user =new users();
                user.setId(resultSet.getInt("user_id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFull_name(resultSet.getString("full_name"));
                user.setRole_id(resultSet.getInt("role_id"));
                comment.setUser(user);
                news newsbir=new news();
                newsbir.setId(resultSet.getInt("news_id"));
                newsbir.setPost_date(resultSet.getTimestamp("post_date_news"));
                newsbir.setTitle(resultSet.getString("title"));
                newsbir.setContent(resultSet.getString("content"));
                news_categories categories=new news_categories();
                categories.setId(resultSet.getInt("category_id"));
                categories.setName(resultSet.getString("name"));
                newsbir.setCategory(categories);
                comment.setNews(newsbir);
                comments.add(comment);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return comments;
    }
    public static void add_category(news_categories newcat) throws SQLException {
        PreparedStatement statement =connection.prepareStatement(
                "Insert into news_categories(name)" +
                        "values (?)");
        statement.setString(1,newcat.getName());
        statement.executeUpdate();
        statement.close();
    }
    public static void add_news(news newster) throws SQLException {
        PreparedStatement statement =connection.prepareStatement(
                "Insert into news(post_date,category_id,title,content)" +
                        "values (NOW(),? ,?,?)");
        statement.setInt(1,(int)newster.getCategory().getId());
        statement.setString(2,newster.getTitle());
        statement.setString(3,newster.getContent());

        statement.executeUpdate();
        statement.close();
    }
    public static users  check_user(String email,String password) throws SQLException {

        PreparedStatement statement =connection.prepareStatement(
                "SELECT * from users where email=?"+
                "and password=?");
        statement.setString(1,email);
        statement.setString(2,password);
        ResultSet resultSet= statement.executeQuery();
         users user =new users();
        if(resultSet.next()){
            user.setEmail(resultSet.getString("email"));
            user.setId(resultSet.getInt("id"));
            user.setPassword(resultSet.getString("password"));
            user.setFull_name(resultSet.getString("full_name"));
            user.setRole_id(resultSet.getInt("role_id"));

        }
        statement.close();
        return user;
    }
    public static void add_user(users user) throws SQLException {
        PreparedStatement statement =connection.prepareStatement(
                "Insert into users(email,password,full_name,role_id)" +
                        "values (?,?,?,2)");
        statement.setString(1,user.getEmail());
        statement.setString(2,user.getPassword());
        statement.setString(3,user.getFull_name());
        statement.executeUpdate();
        statement.close();
    }
    public static void add_comment(comment comment) throws SQLException {
        PreparedStatement statement =connection.prepareStatement(
                "Insert into comments(comment,post_date,user_id,news_id)" +
                        "values (?,NOW(),?,?)");
        statement.setString(1,comment.getComment());
        statement.setInt(2,(int)comment.getUser().getId());
        statement.setInt(3,(int)comment.getNews().getId());
        statement.executeUpdate();
        statement.close();
    }
    public static Map<Long,ArrayList<comment>> get_news_with_comment(){
        Map<Long,ArrayList<comment>>nwc=new HashMap<>();
        ArrayList<news>news=getnew();
        if(news!=null){
            for(int i=0;i<news.size();i++){
                nwc.put(news.get(i).getId(),new ArrayList<>());
            }
        }
        ArrayList<comment>comments=getcomment();
        if(comments!=null){
            for(int i=0;i<comments.size();i++){
                nwc.get(comments.get(i).getNews().getId()).add(comments.get(i));
            }
        }
        return nwc;

    }
    public static void  delete_news(int id) throws SQLException {
        PreparedStatement statement =connection.prepareStatement(
                "delete from news where id=?");
        statement.setInt(1,id);
        statement.executeUpdate();
        statement.close();
    }
    public static void  change_news(int id,String title ,String content) throws SQLException {
        PreparedStatement statement =connection.prepareStatement(
                "update news set title=?,content=? where id=?");
        statement.setString(1,title);
        statement.setString(2,content);
        statement.setInt(3,id);
        statement.executeUpdate();
        statement.close();
    }





}
