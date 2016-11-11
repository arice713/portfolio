/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdcollectionmvc.DAO;

import com.mycompany.dvdcollectionmvc.model.Dvd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class DvdCollectionDAOInMemImpl implements DvdCollectionDAO{
    
    private Map<Integer, Dvd> dvdMap = new HashMap<>();
    
     private static int dvdIdCounter = 0;

    @Override
    public Dvd addDvd(Dvd dvd) {
       // In our DB implementation, the database will assign the ID
        dvd.setDvdId(dvdIdCounter);
        dvdIdCounter++;
        dvdMap.put(dvd.getDvdId(), dvd);
        return dvd;
    }

   @Override
    public Dvd getDvdById(int dvdId) {
        return dvdMap.get(dvdId);
    }

    @Override
    public List<Dvd> getAllDvdsByTitle(String titleToSearch) {
       
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        
    }

    @Override
    public List<Dvd> getAllDvds() {
       List<Dvd> allDvds = new ArrayList<>(dvdMap.values());
        return allDvds;
    }

    @Override
    public void updateDvd(Dvd dvd) {
       
        dvdMap.put(dvd.getDvdId(), dvd);
    }

    
    @Override
    public void removeDvd(int dvdId) {
       
        dvdMap.remove(dvdId);
    }

    

    @Override
    public List<Dvd> searchDvds(Map<SearchTerm, String> criteria) {
        String titleCriteria = criteria.get(SearchTerm.TITLE);
        String releaseDateCriteria = criteria.get(SearchTerm.RELEASE_DATE);
        String ratingCriteria = criteria.get(SearchTerm.RATING);
        String directorCriteria = criteria.get(SearchTerm.DIRECTOR);
        String studioCriteria = criteria.get(SearchTerm.STUDIO);
        String userRatingCriteria = criteria.get(SearchTerm.USER_RATING);
        
        Predicate<Dvd> titleMatches;
        Predicate<Dvd> releaseDateMatches;
        Predicate<Dvd> ratingMatches;
        Predicate<Dvd> directorMatches;
        Predicate<Dvd> studioMatches;
        Predicate<Dvd> userRatingMatches;
        
        
        Predicate<Dvd> truePredicate = (c) -> {return true; };
        
     
             titleMatches = (titleCriteria == null || titleCriteria.isEmpty()) ?
                truePredicate
                : (c) -> c.getTitle().equalsIgnoreCase(titleCriteria);
        
             releaseDateMatches = (releaseDateCriteria == null || releaseDateCriteria.isEmpty()) ?
                truePredicate
                : (c) -> c.getReleaseDate().equalsIgnoreCase(releaseDateCriteria);
        
             ratingMatches = (ratingCriteria == null || ratingCriteria.isEmpty()) ?
                truePredicate
                : (c) -> c.getRating().equalsIgnoreCase(ratingCriteria);
        
             directorMatches = (directorCriteria == null || directorCriteria.isEmpty()) ?
                truePredicate
                : (c) -> c.getDirector().equalsIgnoreCase(directorCriteria);
        
             studioMatches = (studioCriteria == null || studioCriteria.isEmpty()) ?
                truePredicate
                : (c) -> c.getStudio().equalsIgnoreCase(studioCriteria);
        
             userRatingMatches = (userRatingCriteria == null || userRatingCriteria.isEmpty()) ?
                truePredicate
                : (c) -> c.getUserRating().equalsIgnoreCase(userRatingCriteria);
        
        
        return dvdMap.values().stream()
                .filter(titleMatches
                .and(releaseDateMatches)
                .and(ratingMatches)
                .and(directorMatches)
                .and(studioMatches)     
                .and(userRatingMatches))
                .collect(Collectors.toList());
        
        
        
    }
    
}
