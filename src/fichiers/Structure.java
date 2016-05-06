package fichiers;

import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

public class Structure {
	public static void main(String[] args) throws FileNotFoundException {
		String myPath;
		try(Scanner input = new Scanner(System.in)){
			System.out.println("entrez le chemin:");
			myPath=input.next();
			if(!folderExist(myPath)){
				//create folder
				createFolder(myPath);
			}
			else{
				System.out.println(myPath+": Dossier existe deja");
			}
			
			System.out.println("Voulez vous creer une arborescence a 2 niveau ?");
			String answer1 = input.next();
			
			if(answer1.equals("y")){
				createFolder(myPath+"/dir1");
				createFolder(myPath+"/dir1/dir2");
			}
			
		}
	}
	
	
	private static void createFolder(String pathname) throws FileNotFoundException{
		File myFile = new File(pathname);
		myFile.mkdir();
		
		BufferedOutputStream buff = new BufferedOutputStream(new FileOutputStream(pathname+"/.directory"));
		
		String[] content = myFile.list();
		for(String cont: content){
			try {
				buff.write(cont.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private static boolean folderExist(String pathname){
		File myFile = new File(pathname);
		return myFile.exists();
	}
}
