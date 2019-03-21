package HWTrees;
import java.io.File;
/**
 * @author Emmet Stanevich
 * Created on 3/20/19
 */
public class FileSize extends File {
	
	public FileSize(String pathname) {
		super(pathname);
	}
	public static void printName(int depth){
		for(int i=0;i<depth;i++)System.out.print("\t");
		System.out.print();
	}
	public void listAll(){
		listAll(0);
	}
	private void listAll(int depth){
		printName(depth);
		if(isDirectory()) for (File c:
		                       ) {
			
		}
	}
}
