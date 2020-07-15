package br.com.ximenes.simpleproject.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.ximenes.simpleproject.dao.RecipeDao;
import br.com.ximenes.simpleproject.model.UserType;
import br.com.ximenes.simpleproject.model.Recipe;
import br.com.ximenes.simpleproject.security.Protection;

@Controller
public class IndexController {

	@Inject private Result result;
	@Inject private RecipeDao recipeDao;
	
	@Path("/")
	public void index() {
//		Calendar c = Calendar.getInstance();
//        c.set(2013, Calendar.FEBRUARY, 28);
//        Date date = c.getTime();
//        result.include("datanaoformatada", date);
//        DateFormat formataData = DateFormat.getDateInstance();
//		result.include("dataformatada", formataData.format(date));
//         
//		Calendar c = Calendar.getInstance();
//		Date data = c.getTime();
//        DateFormat f = DateFormat.getDateInstance(DateFormat.FULL);
//        f = DateFormat.getDateInstance(DateFormat.SHORT);
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        result.include("data",sdf.format(data));

	}

	@Protection(type = { UserType.ADMIN, UserType.NORMAL })
	@Get("/dashboard")
	public void dashboard() {
		List<Recipe> recipes = recipeDao.list();
		result.include("recipes", recipes);
	}
}