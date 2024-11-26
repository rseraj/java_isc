package session6;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;




public class FileBranchBuilder implements BranchBuilder {
	private static final Logger logger = Logger.getLogger(FileBranchBuilder.class.getName());

	@Override
	public Set<Branch> build() throws BranchBuildException {
		// TODO Auto-generated method stub
        Set<Branch> branches = new HashSet<>(); //@TODO: how initial it?
		
		List<String> branch = readFile("branches.txt");
		
		//@TODO: fill the branches set
		branch.forEach(t -> {
			String [] prop =t.split(";");
			Branch abranch = new Branch(prop[0],prop[1],prop[2],prop[3]);
			
			branches.add(abranch);
		} );
		
		System.out.printf(" Total %d branch found.%n object are ready:%n %s", branches.size(), branches);
		return branches;
	}
	private static List<String> readFile(String filePath) throws BranchBuildException {
    	List<String> fileLines = new ArrayList<>();
        // Using try-with-resources to automatically close the resources
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
            	//@TODO: all fileLines
            	fileLines.add(line);
            	
            	
            }        
        } catch (Exception e) { //see the chain
        	//@TODO: all manage exception
        	logger.severe("can not found file" + filePath);
        	throw new BranchBuildException("not found",e);
        }
        return fileLines;
    }

}
