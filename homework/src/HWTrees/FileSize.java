package HWTrees;
import java.io.File;
/**
 * @author Emmet Stanevich
 * Created on 3/20/19
 * This program will list all the files in a directory, including any subdirectories.
 * Each file and directory will have its size displayed next to its name, in bytes.
 * It will then output the total size of the directory, in bytes.
 */
public class FileSize extends File {
		//Constructor
	public FileSize(String pathname) {
		super(pathname);
	}
	
	/**
	 * Outputs the name of a file or directory
	 * Also displays the size of the file or directory in bytes
	 * @param depth The depth of the file or directory, each level results in an additional tab before the name
	 */
	public void printName(int depth){
		for(int i=0;i<depth;i++)System.out.print("\t");
		System.out.println(getName()+"\t"+size()+" bytes");
	}
	
	/**
	 * Public driver to list all files in the directory
	 */
	public void listAll(){
		listAll(0);
	}
	
	/**
	 * Recursive method that will list all files in the directory
	 * @param depth How many links this node is from the root
	 */
	private void listAll(int depth){
		printName(depth);
		if(isDirectory()){
			String[] entries = list();
			for(int i=0;i<entries.length;i++){
				FileSize child=new FileSize(getPath()+separatorChar+entries[i]);
				child.listAll(depth+1);
			}
		}
	}
	
	/**
	 * Looks at the current FileSize object, and returns its size
	 * @return The size of the current object, including that of its children, if any
	 */
	public long size(){
		long totalSize=length();
		if(isDirectory()){
			String[] entries = list();
			for(int i=0;i<entries.length;i++){
				FileSize child = new FileSize(getPath()+separatorChar+entries[i]);
				totalSize+=child.size();
			}
		}
		return totalSize;
	}
	public static void main(String[] args){
		FileSize f;
		if(args.length==0)f=new FileSize(".");
		else f=new FileSize(args[0]);
		f.listAll();
		System.out.println("Total bytes: "+f.size());
	}
}
