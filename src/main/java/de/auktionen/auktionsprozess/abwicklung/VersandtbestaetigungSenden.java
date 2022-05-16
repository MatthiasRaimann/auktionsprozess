package de.auktionen.abwicklung;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;
import org.camunda.bpm.engine.runtime.MessageCorrelationResultType;
import org.camunda.bpm.engine.runtime.ProcessInstance;

import de.auktionen.auktionsprozess.auktionsabwicklung.AbwicklungsVartibleNames;

public class VersandtbestaetigungSenden implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String attribute1 = (String) execution.getVariable(AbwicklungsVartibleNames.attribute1name);
		String attribute2 = (String) execution.getVariable(AbwicklungsVartibleNames.attribute2name);
		String attribute3 = (String) execution.getVariable(AbwicklungsVartibleNames.attribute3name);

		Map<String, Object> data = new HashMap<String, Object>();
		data.put(AbwicklungsVartibleNames.attribute1name, attribute1);
		data.put(AbwicklungsVartibleNames.attribute2name, attribute2);
		data.put(AbwicklungsVartibleNames.attribute3name, attribute3);

		RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
		MessageCorrelationResult mcresult = runtimeService.createMessageCorrelation(messageCorrelation)
				.processInstanceVariableEquals(AbwicklungsVartibleNames.attribute1name, attribute1).setVariables(data).correlateWithResult();
		if (mcresult.getResultType() == MessageCorrelationResultType.Execution) {
			Execution exec = mcresult.getExecution();
			System.out.println(
					"Waiting process with ProcessInstanceId " + exec.getProcessInstanceId() + " was continued!");
		} else {
			ProcessInstance processInstance = mcresult.getProcessInstance();
			System.out.println("New process with ProcessInstanceId " + processInstance.getRootProcessInstanceId()
					+ " was started!");
		}
		
	}
	
}
