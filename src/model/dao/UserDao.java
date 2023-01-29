package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.mysql.jdbc.Statement;

import dbManager.DBManager;
import exceptions.InvalidProductDataException;
import model.Genre;
import model.Movie;
import model.Product;
import model.TVSeries;
import model.User;


public class UserDao implements IUserDao{

	private static UserDao instance;
	private Connection connection;
	
	
	private UserDao() {
		connection = DBManager.getInstance().getCon();
	}
	
	public static UserDao getInstance() {
		if(instance == null) {
			instance = new UserDao();
		}
		return instance;
	}
	
	@Override
	public User getUserByID(int id) throws SQLException {
		User user = null;
		String sql = "SELECT user_id, user_type_id, first_name, last_name, username, password, email, phone, registration_date, last_login, money"
					+ " FROM users WHERE user_id = ?;";
		try(PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setInt(1, id);
			try(ResultSet rs = ps.executeQuery();){
				rs.next();
				user = new User(rs.getInt("user_id"),
								rs.getInt("user_type_id"),
								rs.getString("first_name"),
								rs.getString("last_name"),
								rs.getString("username"),
								rs.getString("password"),
								rs.getString("email"),
								rs.getString("phone"),
								rs.getDate("registration_date").toLocalDate(),
								rs.getTimestamp("last_login").toLocalDateTime(),
								rs.getDouble("money")
						);

			}
			ps.close();
		}
		return user;
	}
	
	@Override
	public User getUserByUsername(String username) throws SQLException {
		User user = null;
		String sql = "SELECT user_id, user_type_id, first_name, last_name, username, password, email, phone, registration_date, last_login, money "
					+ "FROM users WHERE username = ?;";
		try(PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setString(1, username);
			try(ResultSet rs = ps.executeQuery();){
				rs.next();
				user = new User(rs.getInt("user_id"),
								rs.getInt("user_type_id"),
								rs.getString("first_name"),
								rs.getString("last_name"),
								rs.getString("username"),
								rs.getString("password"),
								rs.getString("email"),
								rs.getString("phone"),
								rs.getDate("registration_date").toLocalDate(),
								rs.getTimestamp("last_login").toLocalDateTime(),
								rs.getDouble("money")
						);

			}
			ps.close();
		}
		return user;
	}
	
	

	@Override
	public void saveUser(User user) throws SQLException {
		String sql = "INSERT INTO users (user_type_id, first_name, last_name, username, email, password, phone, registration_date, last_login, money) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?);";
		PreparedStatement s = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		s.setInt(1, user.getUserTypeId());
		s.setString(2, user.getFirstName());
		s.setString(3, user.getLastName());
		s.setString(4, user.getUsername());
		s.setString(5, user.getEmail());
		s.setString(6, user.getPassword());
		s.setString(7, user.getPhone());
		s.setDate(8, Date.valueOf(user.getRegisrtationDate()));
		s.setTimestamp(9, Timestamp.valueOf(user.getLastLogin()));
		s.setDouble(10, user.getMoney());
		
		//retrieve the Autogenerated Primary key id
		ResultSet rs = s.getGeneratedKeys();
		rs.next();
		user.setUserId(rs.getLong(1));
		
		s.executeUpdate();
		s.close();
		
		System.out.println("Successfully saved user to database.");
	}

	@Override
	public void updateUser(User user) throws SQLException {
		String sqlQuery = "UPDATE users SET username = ?, email = ?, password = ?, first_name = ?, last_name = ?, phone = ?, last_login = ?, profile_picture = ?, money = ? "
						+ "WHERE user_id = ?;";
		try(PreparedStatement ps = connection.prepareStatement(sqlQuery)){
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getFirstName());
			ps.setString(5, user.getLastName());
			ps.setString(6, user.getPhone());
			ps.setTimestamp(7, Timestamp.valueOf(user.getLastLogin()));
			ps.setString(8, user.getProfilePicture());
			ps.setDouble(9, user.getMoney());
			ps.setLong(10, user.getUserId());
			ps.executeUpdate();
			ps.close();
		}
		System.out.println("Successfully updated user in database.");
	}
	

	@Override
	public void deleteUser(User user) throws SQLException {
		String sqlQuery = "DELETE FROM users WHERE username = ?;";
		try (PreparedStatement ps = connection.prepareStatement(sqlQuery)) {
			ps.setString(1, user.getUsername());
			ps.executeUpdate();
		}
		System.out.println("Successfully deleted account from database.");
	}

	@Override
	public Collection<User> getAllUsers() throws SQLException {
		HashSet<User> resultUsers = new HashSet<>();
		String sql = "SELECT user_id, user_type_id, username, email, password, first_name, last_name, registration_date, phone, last_login, profile_picture, money "
					+ "FROM users ORDER BY user_id DESC;";
		try(PreparedStatement ps = connection.prepareStatement(sql)){
			try(ResultSet rs = ps.executeQuery();) {
				while(rs.next()) {
					User user = new User(rs.getInt("user_id"),
							rs.getInt("user_type_id"),
							rs.getString("first_name"),
							rs.getString("last_name"),
							rs.getString("username"),
							rs.getString("password"),
							rs.getString("email"),
							rs.getString("phone"),
							rs.getDate("registration_date").toLocalDate(),
							rs.getTimestamp("last_login").toLocalDateTime(),
							rs.getDouble("money")
							);
					
					resultUsers.add(user);
				}
			}
			ps.close();
		}
		if(resultUsers.isEmpty()) {
			return Collections.emptyList();
		}
		return resultUsers;
	}

	public void addToFavourites(User user, Product product) throws SQLException{
		String sql = "INSERT INTO user_has_favourite_products (user_id, product_id) VALUES (?,?);";
		PreparedStatement s = connection.prepareStatement(sql);
		s.setLong(1, user.getUserId());
		s.setInt(2, product.getId());
		s.executeUpdate();
		s.close();	
	}

	public void removeFromFavourites(User user, Product product) throws SQLException{
		String sql = "DELETE FROM user_has_favourite_products WHERE user_id = ? AND product_id = ?;";
		PreparedStatement s = connection.prepareStatement(sql);
		s.setLong(1, user.getUserId());
		s.setInt(2, product.getId());
		s.executeUpdate();
		s.close();
	}
	
	public void addToProducts(User user, Product product, LocalDate validity) throws SQLException{
		String sql = "INSERT INTO user_has_products (user_id, product_id, validity) VALUES (?,?,?);";
		PreparedStatement s = connection.prepareStatement(sql);
		s.setLong(1, user.getUserId());
		s.setInt(2, product.getId());
		s.setDate(3, Date.valueOf(validity));
		s.executeUpdate();
		s.close();	
	}

	public void removeFromProducts(User user, Product product) throws SQLException{
		String sql = "DELETE FROM user_has_products WHERE user_id = ? AND product_id = ?;";
		PreparedStatement s = connection.prepareStatement(sql);
		s.setLong(1, user.getUserId());
		s.setInt(2, product.getId());
		s.executeUpdate();
		s.close();
	}
	
	public void addToWatchlist(User user, Product product) throws SQLException{
		String sql = "INSERT INTO user_has_watchlist_products (user_id, product_id) VALUES (?,?);";
		PreparedStatement s = connection.prepareStatement(sql);
		s.setLong(1, user.getUserId());
		s.setInt(2, product.getId());
		s.executeUpdate();
		s.close();	
	}

	public void removeFromWatchlist(User user, Product product) throws SQLException{
		String sql = "DELETE FROM user_has_watchlist_products WHERE user_id = ? AND product_id = ?;";
		PreparedStatement s = connection.prepareStatement(sql);
		s.setLong(1, user.getUserId());
		s.setInt(2, product.getId());
		s.executeUpdate();
		s.close();
	}

	public Map<Product,LocalDate> chargeBoughtProducts(User u) throws SQLException, InvalidProductDataException{
		HashMap<Product, LocalDate> usersProducts = new HashMap<>();
		String usersMoviesQuery = "SELECT DISTINCT m.director, p.*, uhp.validity "
					+ "FROM products AS p"
					+ " JOIN movies AS m ON m.product_id = p.product_id"
					+ " JOIN user_has_products AS uhp ON uhp.product_id = p.product_id"
					+ " JOIN users AS u ON uhp.user_id = u.user_id"
					+ " WHERE u.user_id = ?;";
		
		//charge movies
		try(PreparedStatement ps = connection.prepareStatement(usersMoviesQuery)){
			
			ps.setLong(1, u.getUserId());
	
				try(ResultSet rs = ps.executeQuery();){
					while(rs.next()) {
						int movieId = rs.getInt("product_id");
						
						//Collect the movie's genres
						Set<Genre> genres = new HashSet<>(ProductDao.getInstance().getProductGenresById(movieId));
		
						//Collect the movie's raters
						Map<Integer, Double> raters = new TreeMap<>(ProductDao.getInstance().getProductRatersById(movieId));
						
						//Construct the new movie
						Movie m = new Movie(movieId,
								rs.getString("name"),
								rs.getDate("release_year").toLocalDate(),
								rs.getString("pg_rating"),
								rs.getInt("duration"),
								rs.getDouble("rent_cost"),
								rs.getDouble("buy_cost"),
								rs.getString("description"),
								rs.getString("poster"),
								rs.getString("trailer"),
								rs.getString("writers"),
								rs.getString("actors"),
								genres,
								raters,
								rs.getString("director"));

						//Localdate date = rs.getDate("validity").toLocalDate();
						LocalDate date = LocalDate.now();
						
						usersProducts.put(m, date);
					}
					
				}
			}
		String usersTVSeriesQuery = "SELECT DISTINCT tv.season, tv.finished_airing, p.*, uhp.validity "
				+ "FROM products AS p"
				+ " JOIN tvseries AS tv ON tv.product_id = p.product_id"
				+ " JOIN user_has_products AS uhp ON uhp.product_id = p.product_id"
				+ " JOIN users AS u ON uhp.user_id = u.user_id"
				+ " WHERE u.user_id = ?;";
		
		//charge TV series
		try(PreparedStatement ps = connection.prepareStatement(usersTVSeriesQuery)){
			
			ps.setLong(1, u.getUserId());
	
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					int tvsID = rs.getInt("product_id");
					// Collect the series genres
					Set<Genre> genres = new HashSet<>(ProductDao.getInstance().getProductGenresById(tvsID));

					// Collect the series raters
					Map<Integer, Double> raters = new TreeMap<>(ProductDao.getInstance().getProductRatersById(tvsID));

					// Construct the new TV series
					Date finishedAiring = rs.getDate("finished_airing");
					TVSeries tvs = new TVSeries(tvsID, rs.getString("name"), rs.getDate("release_year").toLocalDate(),
							rs.getString("pg_rating"), rs.getInt("duration"), rs.getDouble("rent_cost"),
							rs.getDouble("buy_cost"), rs.getString("description"), rs.getString("poster"),
							rs.getString("trailer"), rs.getString("writers"), rs.getString("actors"), genres, raters,
							rs.getInt("season"), (finishedAiring != null) ? finishedAiring.toLocalDate() : null);

					
					//Localdate date = rs.getDate("validity").toLocalDate();
					LocalDate date = LocalDate.now();
					
					usersProducts.put(tvs, date);
				}

			}
			}
			if(usersProducts.isEmpty()) {
				return Collections.emptyMap();
			}
			return usersProducts;
	}

	public Collection<Product> chargeFavourites(User u) throws SQLException, InvalidProductDataException {
		HashSet<Product> usersFavourites = new HashSet<>();
		
		String usersFavMovies = "SELECT DISTINCT m.director, p.* "
				+ "FROM products AS p"
				+ " JOIN movies AS m ON m.product_id = p.product_id"
				+ " JOIN user_has_favorite_products AS uhp ON uhp.product_id = p.product_id"
				+ " JOIN users AS u ON uhp.user_id = u.user_id"
				+ " WHERE u.user_id = ?;";
	
	//charge movies
	try(PreparedStatement ps = connection.prepareStatement(usersFavMovies)){
		
		ps.setLong(1, u.getUserId());

			try(ResultSet rs = ps.executeQuery();){
				while(rs.next()) {
					int movieId = rs.getInt("product_id");
					//Collect the movie's genres
					Set<Genre> genres = new HashSet<>(ProductDao.getInstance().getProductGenresById(movieId));
					
					//Collect the movie's raters
					Map<Integer, Double> raters = new TreeMap<>(ProductDao.getInstance().getProductRatersById(movieId));
					
					//Construct the new movie
					Movie m = new Movie(movieId,
							rs.getString("name"),
							rs.getDate("release_year").toLocalDate(),
							rs.getString("pg_rating"),
							rs.getInt("duration"),
							rs.getDouble("rent_cost"),
							rs.getDouble("buy_cost"),
							rs.getString("description"),
							rs.getString("poster"),
							rs.getString("trailer"),
							rs.getString("writers"),
							rs.getString("actors"),
							genres,
							raters,
							rs.getString("director"));

					usersFavourites.add(m);
					
				}
				
			}
		}
	String usersFavTVSeries = "SELECT DISTINCT tv.season, tv.finished_airing, p.* "
			+ "FROM products AS p"
			+ " JOIN tvseries AS tv ON tv.product_id = p.product_id"
			+ " JOIN user_has_favorite_products AS uhp ON uhp.product_id = p.product_id"
			+ " JOIN users AS u ON uhp.user_id = u.user_id"
			+ " WHERE u.user_id = ?;";
	
	//charge TV series
	try(PreparedStatement ps = connection.prepareStatement(usersFavTVSeries)){
		
		ps.setLong(1, u.getUserId());

		try (ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				int tvsID = rs.getInt("product_id");
				// Collect the series genres
				Set<Genre> genres = new HashSet<>(ProductDao.getInstance().getProductGenresById(tvsID));

				// Collect the series raters
				Map<Integer, Double> raters = new TreeMap<>(ProductDao.getInstance().getProductRatersById(tvsID));

				// Construct the new TV series
				Date finishedAiring = rs.getDate("finished_airing");
				TVSeries tvs = new TVSeries(tvsID, rs.getString("name"), rs.getDate("release_year").toLocalDate(),
						rs.getString("pg_rating"), rs.getInt("duration"), rs.getDouble("rent_cost"),
						rs.getDouble("buy_cost"), rs.getString("description"), rs.getString("poster"),
						rs.getString("trailer"), rs.getString("writers"), rs.getString("actors"), genres, raters,
						rs.getInt("season"), (finishedAiring != null) ? finishedAiring.toLocalDate() : null);

				usersFavourites.add(tvs);
			}

		}
		}
		
		if(usersFavourites.isEmpty()) {
			return Collections.emptySet();
		}
		return usersFavourites;
	}
	
	public Collection<Product> chargeWatchlist(User u) throws SQLException, InvalidProductDataException {
		HashSet<Product> usersWatchlist = new HashSet<>();
		
		String usersWatchlistMovies = "SELECT DISTINCT m.director, p.* "
				+ "FROM products AS p"
				+ " JOIN movies AS m ON m.product_id = p.product_id"
				+ " JOIN user_has_watchlist_products AS uhp ON uhp.product_id = p.product_id"
				+ " JOIN users AS u ON uhp.user_id = u.user_id"
				+ " WHERE u.user_id = ?;";
	
	//charge movies
	try(PreparedStatement ps = connection.prepareStatement(usersWatchlistMovies)){
		
		ps.setLong(1, u.getUserId());

			try(ResultSet rs = ps.executeQuery();){
				while(rs.next()) {
					int movieId = rs.getInt("product_id");
					//Collect the movie's genres
					Set<Genre> genres = new HashSet<>(ProductDao.getInstance().getProductGenresById(movieId));
					
					//Collect the movie's raters
					Map<Integer, Double> raters = new TreeMap<>(ProductDao.getInstance().getProductRatersById(movieId));
					
					//Construct the new movie
					Movie m = new Movie(movieId,
							rs.getString("name"),
							rs.getDate("release_year").toLocalDate(),
							rs.getString("pg_rating"),
							rs.getInt("duration"),
							rs.getDouble("rent_cost"),
							rs.getDouble("buy_cost"),
							rs.getString("description"),
							rs.getString("poster"),
							rs.getString("trailer"),
							rs.getString("writers"),
							rs.getString("actors"),
							genres,
							raters,
							rs.getString("director"));

					usersWatchlist.add(m);
					
				}
				
			}
		}
	String usersWatchlistTVSeries = "SELECT DISTINCT tv.season, tv.finished_airing, p.* "
			+ "FROM products AS p"
			+ " JOIN tvseries AS tv ON tv.product_id = p.product_id"
			+ " JOIN user_has_watchlist_products AS uhp ON uhp.product_id = p.product_id"
			+ " JOIN users AS u ON uhp.user_id = u.user_id"
			+ " WHERE u.user_id = ?;";
	
	//charge TV series
	try(PreparedStatement ps = connection.prepareStatement(usersWatchlistTVSeries)){
		
		ps.setLong(1, u.getUserId());

		try (ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				int tvsID = rs.getInt("product_id");
				// Collect the series genres
				Set<Genre> genres = new HashSet<>(ProductDao.getInstance().getProductGenresById(tvsID));

				// Collect the series raters
				Map<Integer, Double> raters = new TreeMap<>(ProductDao.getInstance().getProductRatersById(tvsID));

				// Construct the new TV series
				Date finishedAiring = rs.getDate("finished_airing");
				TVSeries tvs = new TVSeries(tvsID, rs.getString("name"), rs.getDate("release_year").toLocalDate(),
						rs.getString("pg_rating"), rs.getInt("duration"), rs.getDouble("rent_cost"),
						rs.getDouble("buy_cost"), rs.getString("description"), rs.getString("poster"),
						rs.getString("trailer"), rs.getString("writers"), rs.getString("actors"), genres, raters,
						rs.getInt("season"), (finishedAiring != null) ? finishedAiring.toLocalDate() : null);

				usersWatchlist.add(tvs);
			}

		}
		}
		
		if(usersWatchlist.isEmpty()) {
			return Collections.emptySet();
		}
		return usersWatchlist;
	}
}