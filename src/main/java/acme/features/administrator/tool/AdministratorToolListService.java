
package acme.features.administrator.tool;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.tools.Tool;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorToolListService implements AbstractListService<Administrator, Tool> {

	@Autowired
	AdministratorToolRepository repository;


	@Override
	public boolean authorise(final Request<Tool> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Tool> request, final Tool entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "sector", "starsNumber");
	}

	@Override
	public Collection<Tool> findMany(final Request<Tool> request) {
		assert request != null;

		Collection<Tool> result;

		result = this.repository.findManyTools();

		return result;
	}

}
