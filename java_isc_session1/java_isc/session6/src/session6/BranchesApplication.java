package session6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.LogManager;

public class BranchesApplication {

	public static void main(String[] args) throws BranchBuildException, SecurityException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		LogManager.getLogManager().readConfiguration(new FileInputStream("logging.properties"));
		BranchBuilder branchBuilder = new FileBranchBuilder();
		branchBuilder.build();

	}

}
