import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Menu {
	
public static void main(String[] args){
	try{
		
	int opcion = 0;
	Boolean vacio = true;
	Persona mostrar = null;
	BufferedReader usuario = new BufferedReader(new InputStreamReader (System.in));

	//Ubicamos donde estara el archivo para aÒadir los datos
	//FileOutputStream fos = new FileOutputStream("/Users/usu27/Documents/workspace/Señalizacion/src/fichero.dat");
	
	//Ubicamos donde estara el archivo para leer los datos
	//FileInputStream fis = new FileInputStream("/Users/usu27/Documents/workspace/Señalizacion/src/fichero.dat");

	//Indicamos que archivo le leeremos los datos
	ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/usu27/Documents/workspace/Señalizacion/src/fichero.dat"));

	ArrayList<Persona> listado = new ArrayList<Persona>();
	
	//compruebo que el archivo que voy a leer haya valores
	try{
		mostrar = (Persona) in.readObject();
	}catch(Exception a){
		vacio = false;
	}
	
	if(vacio){
		//inserto los valores leeidos del archivo en nuestro arraylist
		while(mostrar != null){
			try{
			listado.add(mostrar);		
			mostrar = (Persona) in.readObject();	
			}catch(IOException a){
				break;
			}
		}
	}
	
	while(opcion != 4){
		System.out.println("Menu");
		System.out.println("1. Insertar Persona");
		System.out.println("2. Ver listado Personas");
		System.out.println("3. Borrar Persona");
		System.out.println("4. Salir");
		opcion = Integer.parseInt(usuario.readLine());
		
		if(opcion == 1){
			//Creo el objeto e inserto los datos en cada metodo de la clase de ese objeto creado
			Persona persona = new Persona();	
			System.out.println("Nombre:");
			persona.setNombre(usuario.readLine());
			System.out.println("Edad:");
			persona.setEdad(Integer.parseInt(usuario.readLine()));
			System.out.println("Peso:");
			persona.setPeso(Double.parseDouble(usuario.readLine()));	
			System.out.println("Indique en que posicion lo quieres añadir (1 - " + (listado.size()+1) +")");
			opcion = Integer.parseInt(usuario.readLine());
			
			//inserto el objeto creado con todos sus atributos en el arraylist del mismo objeto en la posicion indicada por el usuario
			listado.add(opcion-1, persona);						
		}
		else if(opcion == 2){
			if(listado.size()==0){
				System.out.println("No hay personas");
			}else{
			for(int i=0; i<listado.size(); i++){
				//muestro todos los objetos de cada posicion del arrayList
				System.out.println(listado.get(i).nombre+", "+listado.get(i).edad+", "+listado.get(i).peso);
			}
			}
		}
		else if(opcion == 3){
			if(listado.size()==0){
				System.out.println("No hay personas");
			}else{
				//Elimino el objeto del arrayList indicado por el usuario
				System.out.println("Que persona quieres eliminar? (1 -"+ (listado.size()) +")");
				opcion = Integer.parseInt(usuario.readLine());
				listado.remove(opcion-1);	
			}

		}
		else if(opcion == 4){
			//Indicamos que archivo le anyadiremos los datos del archivo ubicado
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/Users/usu27/Documents/workspace/Señalizacion/src/fichero.dat"));
			
			//Guardo todos los objetos del arrayList en el fichero
			for(int i=0; i<listado.size(); i++){
				Persona persona = new Persona();	
				persona = listado.get(i);
				out.writeObject(persona);
			}
			System.out.println("Adiós");

			out.close();
			break;
		}
		else{
			System.out.println("Opción incorrecta");
		}
	}
	
	in.close();

	}
	catch(Exception a){
		a.printStackTrace();
		System.out.println(a);
		return;
		}
	}
}
