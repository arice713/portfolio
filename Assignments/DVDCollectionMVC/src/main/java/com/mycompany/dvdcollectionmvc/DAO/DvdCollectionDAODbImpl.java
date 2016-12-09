/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdcollectionmvc.DAO;

import com.mycompany.dvdcollectionmvc.model.Dvd;
import com.mycompany.dvdcollectionmvc.model.DvdCollectionCount;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class DvdCollectionDAODbImpl implements DvdCollectionDAO{
    
    private static final String SQL_INSERT_DVD ="insert into dvds(title, release_date, rating, director, studio, user_rating) values (?,?,?,?,?.?)";
    
    private static final String SQL_DELETE_DVD ="delete from dvds where dvd_id = ?";
    private static final String SQL_SELECT_DVD = "select * from dvds where dvd_id = ?";
    private static final String SQL_SELECT_DVDS_BY_TITLE = "select * from dvds where title = ?";
    private static final String SQL_SELECT_DVDS_BY_RELEASE_DATE = "select * from dvds where release_date = ?";
    private static final String SQL_SELECT_DVDS_BY_RATING = "select * from dvds where rating = ?";
    private static final String SQL_SELECT_DVDS_BY_DIRECTOR = "select * from dvds where director = ?";
    private static final String SQL_SELECT_DVDS_BY_STUDIO = "select * from dvds where studio = ?";
    private static final String SQL_SELECT_DVDS_BY_USER_RATING = "select * from dvds where user_rating = ?";
    private static final String SQL_SELECT_DVD_COLLECTION_COUNTS = "SELECT collection, count (*) as num_dvds FROM dvds GROUP BY collection;";
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Dvd addDvd(Dvd dvd) {
        jdbcTemplate.update(SQL_INSERT_DVD,
                dvd.getTitle(),
                dvd.getReleaseDate(),
                dvd.getRating(),
                dvd.getDirector(),
                dvd.getStudio(),
                dvd.getUserRating());
        dvd.setDvdId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", 
                Integer.class));
        return dvd;
    }

    @Override
    public Dvd getDvdById(int dvdId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_DVD, 
               new DvdMapper(), dvdId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Dvd> getAllDvdsByTitle(String titleToSearch) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Dvd> getAllDvds() {
        return jdbcTemplate.query(SQL_SELECT_ALL_DVDS, new DvdMapper());
    }

    @Override
    public void updateDvd(Dvd dvd) {
jdbcTemplate.update(SQL_UPDATE_DVD,
                dvd.getTitle(),
                dvd.getReleaseDate(),
                dvd.getRating(),
                dvd.getDirector(),
                dvd.getStudio(),
                dvd.getUserRating(),
                dvd.getDvdId());

    }

    @Override
    public void removeDvd(int dvdId) {
        jdbcTemplate.update(SQL_DELETE_DVD, dvdId);
    }

    @Override
    public List<Dvd> searchDvds(Map<SearchTerm, String> criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
   // public List<Dvd> searchDvds(Map<SearchTerm, String> criteria) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
    
    private static final class DvdMapper implements RowMapper<Dvd> {
        
        @Override
        public Dvd mapRow(ResultSet rs, int rowNum) throws SQLException {
            Dvd dvd = new Dvd();
            dvd.setDvdId(rs.getInt("dvd_id"));
            dvd.setTitle(rs.getString("title"));
            dvd.setReleaseDate(rs.getString("release_date"));
            dvd.setRating(rs.getString("rating"));
            dvd.setDirector(rs.getString("director"));
            dvd.setStudio(rs.getString("studio"));
            dvd.setUserRating(rs.getString("user_rating"));
            return dvd;
        }
    }
    
    private static final class DvdCollectionCountMapper implements RowMapper<DvdCollectionCount> {
        
        @Override
        public DvdCollectionCount mapRow(ResultSet rs, int i) throws SQLException {
            DvdCollectionCount count = new DvdCollectionCount();
            
            count.setCollection(rs.getString("collection"));
            count.setNumCollection(rs.getInt("num_collection"));
            return count;
        }
    }
    
}
