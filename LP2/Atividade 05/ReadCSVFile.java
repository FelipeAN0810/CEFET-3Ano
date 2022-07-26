import java.io.*;
import java.util.*;

public class ReadCSVFile{
	public static ArrayList<Funcionario> readCSV(String fileName, ArrayList<Funcionario> funcionarios) throws IOException{
		try{
			String linha = "";
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			br.readLine();
			while((linha = br.readLine()) != null){
				String[] values = linha.split(";");
				if(values[4].equals("Geral")){
					Setor func = new Setor(values[0], values[1], values[2], values[3], values[4], values[5]);
					funcionarios.add(func);
				}else if(values[4].equals("Docente")){
					Funcionario func = new Funcionario(values[0], values[1], values[2], values[3], values[4]);
					funcionarios.add(func);
				}else if(values[4].equals("Discente")){
					Turma func = new Turma(values[0], values[1], values[2], values[3], values[4], values[5]);
					funcionarios.add(func);
				}
			}
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return funcionarios;
	}
}

//Peguei na internet ;)

