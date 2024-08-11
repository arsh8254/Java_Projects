package com.example.aryan.watchlist.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.aryan.watchlist.entity.Movie;
import com.example.aryan.watchlist.service.DatabaseService;

@RestController
public class MovieController {

	@Autowired
	DatabaseService databaseService;
	
	@GetMapping("/watchlistItemForm")
	// if we set the parameter to false it will be used only when required
	public ModelAndView showWatchListForm(@RequestParam(required = false) Integer id) {
		
		System.out.println(id);
		String viewName = "watchlistItemForm";
		
		Map<String, Object> model = new HashMap<>();
		
		
		// if no existing movie is there, blank form should open
		// otherwise form containing existing data of given id should open
		if(id == null) {
			model.put("watchlistItem", new Movie());
			// we can pass object reference, constructor, as well as object name in parameter of put method
			
		} else {
			model.put("watchlistItem", databaseService.getMovieById(id));
		}
		
		
		
//      // we can set pre defined objects as well		
//		Movie dummyMovie = new Movie();
//		dummyMovie.setTitle("dummy");
//		dummyMovie.setRating(0);
//		dummyMovie.setPriority("Low");
//		dummyMovie.setComment("john doe");
//		
//		model.put("watchlistItem", dummyMovie);
		
		
		return new ModelAndView(viewName, model);
	}
	
	@PostMapping("/watchlistItemForm")
	public ModelAndView submitWatchListForm(@Valid @ModelAttribute("watchlistItem") Movie movie, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult.hasErrors());
			// if errors are there, redisplay the form and let user enter data again"
			return new ModelAndView("watchlistItemForm");
		}
		/*
		 if(id == null) {
		 create new movie
		 } else {
		 update existing movie
		 }
		 */
		
		Integer id = movie.getId();
		if(id == null) {
			databaseService.create(movie);
		} else {
			databaseService.update(movie, id);
		}
		
		
		// used for redirecting to different page
		RedirectView rd = new RedirectView();
		rd.setUrl("/watchlist");
		
		return new ModelAndView(rd);
	}
	
	@GetMapping("/watchlist")
	public ModelAndView getWatchlist() {
		// TODO Auto-generated method stub

		String viewName = "watchlist";
		
		//map stores both model and view
		Map<String, Object> model = new HashMap<>();
		
		// list stores all rows of movies database table
		List<Movie> movieList = databaseService.getAllMovies();
		model.put("watchlistrows", movieList);
		model.put("noofmovies", movieList.size());
		return new ModelAndView(viewName, model);
	}
}
