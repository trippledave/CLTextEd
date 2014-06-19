
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public Main() {
		System.out.println("Willkommen zum CommandLine Texteditor \n");
		
		File path=new File("E:\\Dokumente\\Desktop\\depp.txt");
		String[] array=openFile(path);
		
		TextCommandInterface tc=new splitAfterFirstSpace();
		
		delegate(array,tc,null);
		
		tc=new addAtLineEnd();
		
		delegate(array,tc,"@test");
		

		
		
		for(String e:array){
			System.out.println(e);
		}

	}

	public static void main(String[] args) {
		new Main();
	}

	private String[] openFile(File path) {
		BufferedReader reader = null;
		List<String> list=new LinkedList<String>();
		String currentLine;

		try {
			reader = new BufferedReader(new FileReader(path));
			while ((currentLine = reader.readLine()) != null) {
				list.add(currentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return  list.toArray(new String[list.size()]);
	}
	
	private void delegate(String[] array,TextCommandInterface tc,String option){
		for(int i=0;i<array.length;i++){
			array[i]=tc.formatText(array[i], option);
		}	
	}

}
