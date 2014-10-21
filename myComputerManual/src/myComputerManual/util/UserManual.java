package myComputerManual.util;


import myComputerManual.dataStore.Component;
import java.util.Vector;

public class UserManual{
	Vector<Component>allComponents = null;
	Logger logger = Logger.getInstance();

	/**
	* Constructor which initialises the vector of components
	* Return type: none
	*/
	public UserManual( Vector<Component> allComponentsIn){
		this.allComponents = allComponentsIn;
	}
	
	/**
	* Prints the manual based upon the user choices
	* Return type: void
	*/
	public void printManual(){

		printTableContent();
		printActualManual();
		printGlossary();
	}

	/**
	* Prints the table content
	* Return type: void
	*/
	public void printTableContent(){
		int pageNumber = 1;

		String title = String.format("\n Component Name" +
				" \t\t\t\t\t\t\t\t ...............     Page Number\n");
		logger.write(title);
		//logger.write(title);

		String body = null;
		for( int i=0; i< allComponents.size(); i++){
			
			if(null != allComponents.get(i))
				body = String.format( "\t %-100s %s\n", 
						allComponents.get(i).getName(), pageNumber );

			System.out.printf( "%s\n",pageNumber );
			logger.write(body);
			//logger.write(3, body);
			if(null != allComponents.get(i))
			pageNumber += allComponents.get(i).getPages();
		}
		logger.write("\n");
		//logger.write(3, "\n");
	}


	/**
	* Prints the whole actual manual
	* Return type: void
	*/
	public void printActualManual(){
		int pageNumber = 1;
		String title = String.format("\n Component " +
				" \t\t\t\t\t\t\t\t ...............   \t  Page Number\n");
		logger.write(title);
		//logger.write(title);

		String body = null;
		for( int i=0; i< allComponents.size(); i++){
			if(null != allComponents.get(i))
			body = String.format("\t%s\n\t\t%-100s%s\n",
				allComponents.get(i).getName(), 
				allComponents.get(i).getDescription(), pageNumber);
			//logger.write(body);
			logger.write(body);
			for( int j =0; j< allComponents.get(i).getListOfFigures(); j++){
				if(null != allComponents.get(i))
				body = String.format("\t\t%-100s%s\n", 
					allComponents.get(i).getGlossary() + " Figure " +(j+1),
					pageNumber + j
					);
				//logger.write( body);
				logger.write( body);
			}
			pageNumber += allComponents.get(i).getPages();
		}

	}

	/**
	* Prints the glossary of the manual
	* Return type: void
	*/
	public void printGlossary(){
		String title = String.format("\nGlossary\n");
		logger.write(title);
		//logger.write( 3, title);


		String body = null;
		for( int i=0; i< allComponents.size(); i++){
			if(null != allComponents.get(i))
			body = String.format("\t" + allComponents.get(i).getGlossary()+ "\n");
			logger.write(body);
			//logger.write(3, body);

		}
	}
}
