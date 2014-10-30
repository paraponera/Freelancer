package delegate;

import java.util.List;

import com.pidev.persistence.Sous_Categories;
import com.pidev.services.SousCategoriesServices;
import com.pidev.services.SousCategoriesServicesRemote;

public class CategoriesServiceDelegate {
	
	private static final String jndiNameService = "ejb:/Pidev-EJB/SousCategoriesServices!com.pidev.services.SousCategoriesServicesRemote";

	private static SousCategoriesServicesRemote getProxyUser() {
		return  (SousCategoriesServicesRemote) ServiceLocator.getInstance().getProxy(
				jndiNameService);
	}

	public static void insertSousCategories(Sous_Categories sous_Categories) {
		getProxyUser().insertSousCategories(sous_Categories);

	}

	

	public static List<Sous_Categories> getAll() {
		return getProxyUser().getAll();
	}
	

	public static void Delete(int id) {
		getProxyUser().delete(id);
	}
	
	public static Sous_Categories Findbyid1(int id) {
		return getProxyUser().findbyid(id);
	}
	
	

	

}
