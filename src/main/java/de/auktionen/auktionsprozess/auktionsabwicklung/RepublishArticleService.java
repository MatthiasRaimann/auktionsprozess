package de.auktionen.auktionsprozess.auktionsabwicklung;

import java.util.ArrayList;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class RepublishArticleService implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String attribute1 = (String) execution.getVariable(AbwicklungsVartibleNames.attribute1name);
		String attribute2 = (String) execution.getVariable(AbwicklungsVartibleNames.attribute2name);
		String attribute3 = (String) execution.getVariable(AbwicklungsVartibleNames.attribute3name);

		Order order = new Order(attribute1, attribute2, attribute3);

		@SuppressWarnings("unchecked")
		ArrayList<Order> orderList = (ArrayList<Order>) execution
				.getVariable(AbwicklungsVartibleNames.collectionAttribute1name);
		if (orderList == null) {
			orderList = new ArrayList<Order>();

			orderList.add(order);
			execution.setVariable(AbwicklungsVartibleNames.collectionAttribute1name, orderList);
			execution.setVariable("counter", (Integer) orderList.size());
		}
	}

}
