package iotsuite.compiler;

import iotsuite.codegenerator.CompilationUnit;
import iotsuite.codegenerator.JavaFrameworkFromST;
import iotsuite.codegenerator.SourceFileDumper;
import iotsuite.parser.SymbolTable;
import iotsuite.semanticmodel.Action;
import iotsuite.semanticmodel.ComputationalService;
import iotsuite.semanticmodel.DataAccess;
import iotsuite.semanticmodel.DataType;
import iotsuite.semanticmodel.Information;
import iotsuite.semanticmodel.Parameter;
import java.util.HashSet;
import java.util.Set;

public class ComputationalServiceCompiler {

	private ComputationalService computationalService;

	private Set<Information> generatedInfo = new HashSet<Information>();
	private Set<Information> consumedInfo = new HashSet<Information>();
	// private Set<Operation> operation = new HashSet<Operation>();
	private String operationType;
	private Set<DataAccess> dataAccessList = new HashSet<DataAccess>();
	private Set<Action> actions = new HashSet<Action>();
	private String partitionAttributeValue;
	private String computationalServiceName;
	private Parameter parameter;

	public void addCommand(String actionName) {
		Action action = new Action(actionName, getParameters(), null);
		actions.add(action);
	}

	private Set<Action> getActionList() {
		return actions;
	}

	private Parameter getParameters() {
		return parameter;
	}

	public void addParameter(String parameterName) {
		parameter = new Parameter(parameterName, new DataType(
				getDatafromSymblTable(parameterName)));
	}

	public String getComputationalServiceName() {
		return computationalServiceName;
	}

	public void setComputationalServiceName(String computationalServiceName) {
		this.computationalServiceName = computationalServiceName;
	}

	public void createCSObject() {
		/*
		 * computationalService = new
		 * ComputationalService(getComputationalServiceName(),
		 * getAttributeSet(), getGeneratedInfo(), getConsumedInfo(),
		 * getDataAccessList(), getActionList(), getPartitionAttributeVal());
		 */
		/*
		 * computationalService = new ComputationalService(
		 * getComputationalServiceName(), getGeneratedInfo(),getConsumedInfo(),
		 * getConsumedInfo(), getDataAccessList(), getActionList(),
		 * getPartitionAttributeVal());
		 */

		/*
		 * computationalService = new ComputationalService(
		 * getComputationalServiceName(), getGeneratedInfo(), getConsumedInfo(),
		 * getDataAccessList(), getActionList(), getPartitionAttributeVal(),
		 * computationalServiceName);
		 */

		computationalService = new ComputationalService(
				getComputationalServiceName(), getGeneratedInfo(),
				getConsumedInfo(), getDataAccessList(), getActionList(),
				getPartitionAttributeVal(), getOperation());

	}

	/*
	 * public void dataAccess(Information query, Information generatedInfo) {
	 * DataAccess dataAccess = new DataAccess(query, generatedInfo);
	 * dataAccessList.add(dataAccess); }
	 */

	public Set<DataAccess> getDataAccessList() {
		return dataAccessList;
	}

	public void getDataAccessListFromSymblTable(String dataAccessStr) {
		this.dataAccessList = SymbolTable
				.getDataAccessSymblTable(dataAccessStr);
	}

	// Getter and Setter of Partition Attribute
	public void addPartitionAttribute(String regionName) {
		partitionAttributeValue = regionName;

	}

	public String getPartitionAttributeVal() {
		return partitionAttributeValue;
	}

	// Getter and Setter of Consumed Info

	public Set<Information> getConsumedInfo() {
		return consumedInfo;
	}

	public String getOperation() {

		return operationType;
	}

	public void addOperation(String variableName) {

		this.operationType = variableName;

	}

	public void addConsumedInfo(String variableName) {
		consumedInfo.add(new Information(variableName, new DataType(
				getDatafromSymblTable(variableName))));
	}

	public String getDatafromSymblTable(String variableName) {
		return SymbolTable.getSymblTableData(variableName);
	}

	// Getter and setter of Generated Info
	public Set<Information> getGeneratedInfo() {
		return generatedInfo;
	}

	public void addGeneratedInfo(String variableName, String variableType) {
		generatedInfo.add(new Information(variableName, new DataType(
				variableType)));
	}

	// Getter and Setter of Attribute
	/*
	 * private Set<Attribute> attributeSet = new HashSet<Attribute>();
	 * 
	 * public Set<Attribute> getAttributeSet() { return attributeSet; }
	 * 
	 * public void addAttribute(String fieldName, String fieldType) { Attribute
	 * attribute = new Attribute(fieldName, new PrimitiveType(fieldType));
	 * attributeSet.add(attribute); }
	 */
	/*
	 * The following function generates programming framework for
	 * ComputationalService. It generates code in the following sequence.
	 * 
	 * (1) ComputationalService's Interaction (2) ComputationalService's
	 * ApplicationLogic
	 */

	public void generateAggregatorComputationalServiceCode() {
		generateComputationalServiceInteraction_ComputationalServiceCompiler();
		generateAggregatorComputationalServiceLogic_ComputationalServiceCompiler();
		generateAggregatorComputationalServiceFactory_ComputationalServiceCompiler();

		// Interface
		generateAggregatorComputationalServiceInterface_ComputationalServiceCompiler();
		// Listener

		// generateSensorListener_SensorCompiler(sensorDriver
		// .getAllGeneratedInfo().get(i));
		/*
		 * for (int i = 0; i < sensorDriver.getAllGeneratedInfo().size(); i++) {
		 * generateSensorListener_SensorCompiler(sensorDriver
		 * .getAllGeneratedInfo().get(i)); }
		 */

		for (int i = 0; i < computationalService.getAllConsumedInfo().size(); i++) {
			generateComputationalServiceListener_ComputationalServiceCompiler(computationalService
					.getAllConsumedInfo().get(i));
		}
		// Impl
		generateImplComputationalService_ComputationalServiceCompiler();
		
	}

	
	public void generateComputationalServiceCode() {
		// TODO Auto-generated method stub
		
		generateComputationalServiceInteraction_ComputationalServiceCompiler();
		generateComputationalServiceLogic_ComputationalServiceCompiler();
	}

	
	/*public void generateComputational12ServiceCode() {
		// TODO Auto-generated method stub
		generateAggregatorComputationalServiceLogic_ComputationalServiceCompiler();
	}*/

	public void generateComputationalServiceInteraction_ComputationalServiceCompiler() {

		JavaFrameworkFromST generatedComputationalService = new JavaFrameworkFromST();
		CompilationUnit generatedCU = generatedComputationalService
				.generateComputationalServiceInteraction(computationalService);
		SourceFileDumper dumpGeneratedComputationalService = new SourceFileDumper();
		dumpGeneratedComputationalService.dumpCompilationUnit(generatedCU);

	}

	public void generateAggregatorComputationalServiceLogic_ComputationalServiceCompiler() {
		JavaFrameworkFromST generatedComputationalService = new JavaFrameworkFromST();
		CompilationUnit generatedCU = generatedComputationalService
				.generateAggregatorComputationalServiceLogic(computationalService);
		SourceFileDumper dumpGeneratedComputationalService = new SourceFileDumper();
		dumpGeneratedComputationalService.dumpCompilationUnit(generatedCU);
	}
	
	public void generateComputationalServiceLogic_ComputationalServiceCompiler() {
		JavaFrameworkFromST generatedComputationalService = new JavaFrameworkFromST();
		CompilationUnit generatedCU = generatedComputationalService
				.generateComputationalServiceLogic(computationalService);
		SourceFileDumper dumpGeneratedComputationalService = new SourceFileDumper();
		dumpGeneratedComputationalService.dumpCompilationUnit(generatedCU);
	}

	public void generateAggregatorComputationalServiceFactory_ComputationalServiceCompiler() {

		JavaFrameworkFromST generatedComputationalService = new JavaFrameworkFromST();
		CompilationUnit generatedCU = generatedComputationalService
				.generateComputationalServiceFactory(computationalService);
		SourceFileDumper dumpGeneratedComputationalService = new SourceFileDumper();
		dumpGeneratedComputationalService.dumpCompilationUnit(generatedCU);
	}

	public void generateAggregatorComputationalServiceInterface_ComputationalServiceCompiler() {

		JavaFrameworkFromST generatedComputationalService = new JavaFrameworkFromST();
		CompilationUnit generatedCU = generatedComputationalService
				.generateComputationalServiceInterface(computationalService);
		SourceFileDumper dumpGeneratedComputationalService = new SourceFileDumper();
		dumpGeneratedComputationalService.dumpCompilationUnit(generatedCU);
	}

	public void generateComputationalServiceListener_ComputationalServiceCompiler(
			Information infoConsumeInfo) {
		JavaFrameworkFromST generatedComputationalService = new JavaFrameworkFromST();
		CompilationUnit generatedCU = generatedComputationalService
				.generateComputationalServiceListener(infoConsumeInfo);
		SourceFileDumper dumpGeneratedComputationalService = new SourceFileDumper();
		dumpGeneratedComputationalService.dumpCompilationUnit(generatedCU);
	}

	public void generateImplComputationalService_ComputationalServiceCompiler() {
		JavaFrameworkFromST generatedComputationalService = new JavaFrameworkFromST();
		CompilationUnit generatedCU = generatedComputationalService
				.generateImplComputationalService(computationalService);
		SourceFileDumper dumpGeneratedComputationalService = new SourceFileDumper();
		dumpGeneratedComputationalService.dumpCompilationUnit(generatedCU);
	}
	
	
	
	

	

}