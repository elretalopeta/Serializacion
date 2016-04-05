import java.io.Serializable;

public class Persona implements Serializable {
	String nombre;
	Integer edad;
	Double peso;
	
	Persona(){
	}

	public Persona (String nombre, int edad, double peso){
		this.nombre=nombre;
		this.edad=edad;
		this.peso=peso;
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}
	

}